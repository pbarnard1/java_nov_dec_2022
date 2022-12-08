package com.adrianbarnard.brokenappfixed.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.adrianbarnard.brokenappfixed.models.City;
import com.adrianbarnard.brokenappfixed.models.Store;

@Repository // Bug fix: added this annotation
public interface StoreRepository extends CrudRepository<Store, Long>{
	List<Store> findAll();
	
	List<Store> findByCitiesNotContains(City city);
}
