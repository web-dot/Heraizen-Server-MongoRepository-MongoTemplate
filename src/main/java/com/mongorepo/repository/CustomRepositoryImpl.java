package com.mongorepo.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.aggregation.Aggregation;
import org.springframework.data.mongodb.core.aggregation.MatchOperation;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.stereotype.Component;

import com.mongorepo.model.GroceryDetails;
import com.mongorepo.model.GroceryItem;

@Component
public class CustomRepositoryImpl implements CustomRepository {

	
	@Autowired
	MongoTemplate mongoTemplate;
	
	@Override
	public List<GroceryDetails> getGroceryDetails(String name) {
		MatchOperation match = Aggregation.match(Criteria.where("name").is(name));
		Aggregation aggregate = Aggregation.newAggregation(match);
		List<GroceryDetails> groceryData = mongoTemplate.aggregate(aggregate, GroceryItem.class, GroceryDetails.class)
				.getMappedResults();
		return groceryData;
	}

}
