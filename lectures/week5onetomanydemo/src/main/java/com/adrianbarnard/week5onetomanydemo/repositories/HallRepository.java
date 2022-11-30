package com.adrianbarnard.week5onetomanydemo.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.adrianbarnard.week5onetomanydemo.models.Hall;

@Repository
public interface HallRepository extends CrudRepository<Hall, Long> {
	// This is where your JPA methods will go
	List<Hall> findAll(); // Equivalent to the MySQL query "SELECT * FROM halls;"
	
	// Grab the Universities in reverse alphabetical order
	List<Hall> findAllByOrderByNameDesc(); // Equivalent to "SELECT * FROM halls ORDER BY name DESC;"
}
