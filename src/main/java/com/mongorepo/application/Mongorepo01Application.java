package com.mongorepo.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import com.mongorepo.repository.ItemRepository;

@SpringBootApplication
@ComponentScan({"com.mongorepo.controller", "com.mongorepo.model", "com.mongorepo.repository"})
@EnableMongoRepositories(basePackageClasses = ItemRepository.class)
public class Mongorepo01Application {

	public static void main(String[] args) {
		SpringApplication.run(Mongorepo01Application.class, args);
	}

}
