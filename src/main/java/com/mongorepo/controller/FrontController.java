package com.mongorepo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mongorepo.model.GroceryDetails;
import com.mongorepo.model.GroceryItem;
import com.mongorepo.repository.CustomRepository;
import com.mongorepo.repository.ItemRepository;

@RestController
@RequestMapping("/api")
public class FrontController {

	@Autowired
	private ItemRepository repository;
	
	@Autowired
	private CustomRepository customRepository;

	
	@GetMapping("/getGrocery")
	public List<GroceryItem> showAllGroceryItems() {
		List<GroceryItem> list = repository.findAll();
		return list;
	}
	
	
	
	//@PathVariable ---->
	
	
	@GetMapping("/getGroceryByName/{name}")
	public GroceryItem getGroceryItemByName(@PathVariable String name) {
		return repository.findItemByName(name);
	}
	
	@GetMapping("/getGroceryByCategory/{category}")
	//api/getGroceryByCategory/snacks 				--> 	URL Pattern
	public List<GroceryItem> getGroceryItemByCategory(@PathVariable String category) {
		return repository.findByCategory(category);
	}
	
	//@RequestParam ---->
	
	@GetMapping("/findGroceryByCategory/items")
	//api/findGroceryByCategory/items?category=snacks --> 	Query Parameters
	public List<GroceryItem>  findGroceryItemByCategory(@RequestParam String category){
		return repository.findAll(category);
	}
	
	@GetMapping("/findGroceryDetailsByName/{name}")
	public List<GroceryDetails> getGroceryByName(@PathVariable String name){	
		return customRepository.getGroceryDetails(name);
	}
	
	
}
