package com.adrianbarnard.brokenapp.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.adrianbarnard.brokenapp.models.City;
import com.adrianbarnard.brokenapp.models.Store;

public interface CityRepository extends CrudRepository<City, Long> {
	List<City> findAll();
	
	List<City> findByStoresNotContains(Store store);
}
