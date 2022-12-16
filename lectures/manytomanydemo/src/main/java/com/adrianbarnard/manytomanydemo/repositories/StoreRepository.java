package com.adrianbarnard.manytomanydemo.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.adrianbarnard.manytomanydemo.models.Store;

@Repository
public interface StoreRepository extends CrudRepository<Store, Long> {
	List<Store> findAll();
	
}
