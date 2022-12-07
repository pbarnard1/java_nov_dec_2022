package com.adrianbarnard.brokenappfixed.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.adrianbarnard.brokenappfixed.models.City;
import com.adrianbarnard.brokenappfixed.models.Store;

public interface CityRepository extends CrudRepository<City, Long> {
	List<City> findAll();
	
	List<City> findByStoresNotContains(Store store);
}