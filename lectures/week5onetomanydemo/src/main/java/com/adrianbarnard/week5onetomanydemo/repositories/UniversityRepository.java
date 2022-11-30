package com.adrianbarnard.week5onetomanydemo.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.adrianbarnard.week5onetomanydemo.models.University;

@Repository
public interface UniversityRepository extends CrudRepository<University, Long> {
	// This is where your JPA methods will go
	List<University> findAll(); // Equivalent to the MySQL query "SELECT * FROM universities;"
	
	// Grab the Universities in reverse alphabetical order
	List<University> findAllByOrderByNameDesc(); // Equivalent to "SELECT * FROM universities ORDER BY name DESC;"
}
