package com.adrianbarnard.brokenappfixed.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.adrianbarnard.brokenappfixed.models.City;
import com.adrianbarnard.brokenappfixed.models.Store;

@Repository // Bug fix: don't forget annotation!
public interface CityRepository extends CrudRepository<City, Long> {
	List<City> findAll();
	
	List<City> findByStoresNotContains(Store store);
}