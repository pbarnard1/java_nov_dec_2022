package com.adrianbarnard.manytomanydemo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.adrianbarnard.manytomanydemo.models.Store;
import com.adrianbarnard.manytomanydemo.repositories.StoreRepository;

@Service
public class StoreService {
	@Autowired
	private StoreRepository storeRepo;
	
	// Create
	public Store createStore(Store newStore) {
		return storeRepo.save(newStore);
	}
	
	// Read all
	public List<Store> findAllStores() {
		return storeRepo.findAll();
	}
	
	// Read one
	public Store findStoreById(Long id) {
		Optional<Store> optionalStore = storeRepo.findById(id);
		return optionalStore.orElseGet(() -> null);
	}
	
	// Update one
	public Store updateStore(Store updatedStore) {
		return storeRepo.save(updatedStore);
	}
	
	// Delete one
	public void deleteStoreById(Long id) {
		storeRepo.deleteById(id);
	}
	
	public void deleteStore(Store store) {
		storeRepo.delete(store);
	}
}
