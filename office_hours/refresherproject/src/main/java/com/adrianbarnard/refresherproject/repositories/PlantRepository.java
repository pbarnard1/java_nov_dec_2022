package com.adrianbarnard.refresherproject.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.adrianbarnard.refresherproject.models.Plant;

@Repository
public interface PlantRepository extends CrudRepository<Plant, Long> {
	// Your JPA queries will go here, such as findByEmail, findAll, etc.
	List<Plant> findAll();
	
	List<Plant> findByName(String name);
}
