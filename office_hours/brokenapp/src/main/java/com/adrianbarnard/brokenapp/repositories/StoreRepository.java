package com.adrianbarnard.brokenapp.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.adrianbarnard.brokenapp.models.City;
import com.adrianbarnard.brokenapp.models.Store;

public interface StoreRepository extends CrudRepository<Store, Long>{
	List<Store> findAll();
	
	List<Store> findByCitiesNotContains(City city);
}
