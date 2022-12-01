package com.adrianbarnard.refresherproject.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.adrianbarnard.refresherproject.models.Plant;
import com.adrianbarnard.refresherproject.repositories.PlantRepository;

@Service
public class PlantService {
	// Inject our repository
	@Autowired
	private PlantRepository plantRepo;
	
	// Creating a Plant
	public Plant createPlant(Plant newPlant) {
		return plantRepo.save(newPlant);
	}
	
	// Read a Plant
	public Plant findPlantById(Long id) {
		Optional<Plant> optionalPlant = plantRepo.findById(id);
		if (optionalPlant.isPresent()) {
			return optionalPlant.get(); // Plant found - if it exists
		} else {
			return null; // No Plant found
		}
	}
	
	// Add additional methods as needed if you use any additional JPA queries, like findAll
	public List<Plant> findAllPlants() {
		return plantRepo.findAll();
	}
	
	// Update a Plant
	public Plant updatePlant(Plant newPlant) {
		return plantRepo.save(newPlant);
	}
	
	// Delete a Plant
	public void deletePlant(Long id) {
		// Later on, when dealing with relationships, you might to delete some connections in
		// other tables before you can delete the item in question
		plantRepo.deleteById(id);
	}
}
