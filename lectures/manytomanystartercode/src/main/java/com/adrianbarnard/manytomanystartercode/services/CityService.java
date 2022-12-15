package com.adrianbarnard.manytomanystartercode.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.adrianbarnard.manytomanystartercode.models.Chain;
import com.adrianbarnard.manytomanystartercode.models.City;
import com.adrianbarnard.manytomanystartercode.repositories.CityRepository;

@Service
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
	
	public List<City> findCitiesNotWithChain(Chain chain) {
		return cityRepo.findByChainsNotContains(chain);
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
	
	public void deleteCity(City city) {
		cityRepo.delete(city);
	}
}
