package com.mongorepo.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.mongorepo.model.GroceryItem;

@Repository
public interface ItemRepository extends MongoRepository<GroceryItem, String> {
	
	List<GroceryItem> findAll();
	
	List<GroceryItem> findByCategory(String category);
	
	@Query("{name:?0}")
    GroceryItem findItemByName(String name);
	
	@Query(value="{category:?0}", fields="{name:1, quantity:1}")
	List<GroceryItem> findAll(String category);
	
	public long count();
	
}
