package com.adrianbarnard.manytomanystartercode.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.adrianbarnard.manytomanystartercode.models.Chain;
import com.adrianbarnard.manytomanystartercode.models.City;

@Repository
public interface CityRepository extends CrudRepository<City, Long> {
	List<City> findAll();
	
	List<City> findByChainsNotContains(Chain chain);
}