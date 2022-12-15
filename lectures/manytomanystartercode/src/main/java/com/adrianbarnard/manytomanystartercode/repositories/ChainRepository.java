package com.adrianbarnard.manytomanystartercode.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.adrianbarnard.manytomanystartercode.models.Chain;
import com.adrianbarnard.manytomanystartercode.models.City;

@Repository
public interface ChainRepository extends CrudRepository<Chain, Long>{
	List<Chain> findAll();
	
	List<Chain> findByCitiesNotContains(City city);
}