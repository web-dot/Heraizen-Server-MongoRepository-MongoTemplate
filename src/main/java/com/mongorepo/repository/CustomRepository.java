package com.mongorepo.repository;

import java.util.List;

import com.mongorepo.model.GroceryDetails;

public interface CustomRepository {
	
	List<GroceryDetails> getGroceryDetails(String name);
	
}
