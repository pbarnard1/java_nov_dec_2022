package com.adrianbarnard.manytomanydemo.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.adrianbarnard.manytomanydemo.models.Chain;
import com.adrianbarnard.manytomanydemo.models.City;

@Repository
public interface CityRepository extends CrudRepository<City, Long> {
	List<City> findAll();
	
//	List<City> findByChainsNotContains(Chain chain);
}