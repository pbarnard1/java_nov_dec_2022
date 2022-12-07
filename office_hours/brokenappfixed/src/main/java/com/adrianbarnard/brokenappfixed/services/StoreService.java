package com.adrianbarnard.brokenappfixed.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.adrianbarnard.brokenappfixed.models.City;
import com.adrianbarnard.brokenappfixed.models.Store;
import com.adrianbarnard.brokenappfixed.repositories.StoreRepository;

public class StoreService {
	@Autowired
	private StoreRepository storeRepo;
	
	public Store createStore(Store store) {
		return storeRepo.save(store);
	}
	
	public Store findStoreById(Long id) {
		Optional<Store> optionalStore = storeRepo.findById(id);
		return optionalStore.orElseGet(() -> null);
	}
	
	public List<Store> findAll() {
		return storeRepo.findAll();
	}
	
	public List<Store> findStoresNotInCity(City city) {
		return storeRepo.findByCitiesNotContains(city);
	}
	
	public Store updateStore(Store store) {
		return storeRepo.save(store);
	}
	
	public void deleteStore(Long id) {
		storeRepo.deleteById(id);
	}
}
