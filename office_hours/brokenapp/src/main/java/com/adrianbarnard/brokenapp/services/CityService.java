package com.adrianbarnard.brokenapp.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.adrianbarnard.brokenapp.models.City;
import com.adrianbarnard.brokenapp.models.Store;
import com.adrianbarnard.brokenapp.repositories.CityRepository;

public class CityService {
	@Autowired
	private CityRepository cityRepo;
	
	public City createCity(City city) {
		return cityRepo.save(city);
	}
	
	public City findCityById(Long id) {
		Optional<City> optionalCity = cityRepo.findById(id);
		return optionalCity.orElseGet(() -> null);
	}
	
	public List<City> findCitiesNotWithStore(Store store) {
		return cityRepo.findByStoresNotContains(store);
	}
	
	public List<City> findAll() {
		return cityRepo.findAll();
	}
	
	public City updateCity(City city) {
		return cityRepo.save(city);
	}
	
	public void deleteCity(Long id) {
		cityRepo.deleteById(id);
	}
}
