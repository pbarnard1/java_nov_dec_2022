package com.adrianbarnard.week5onetomanydemo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.adrianbarnard.week5onetomanydemo.models.Hall;
import com.adrianbarnard.week5onetomanydemo.repositories.HallRepository;

@Service
public class HallService {
	@Autowired
	private HallRepository HallRepository;
	
	// Methods to interact with our repository
	
	// Add a Hall
	public Hall createHall(Hall newHall) {
		return HallRepository.save(newHall); // Save the Hall (bound) in our DB
	}
	
	// Gets all Halls
	public List<Hall> getAllHalls() {
		return HallRepository.findAll();
	}
	
	// Get all Halls in reverse alphabetical order
	public List<Hall> getAllHallsReversed() {
		return HallRepository.findAllByOrderByNameDesc();
	}
	
	// Gets one Hall
	public Hall getOneHall(Long id) {
		Optional<Hall> optionalHall = HallRepository.findById(id);
//		if (optionalHall.isPresent()) {
//			return optionalHall.get();
//		} else {
//			return null;
//		}
		// One-line version where we return the object or return null
		// () -> uses something called a lambda function that will return the value null in this case
		return optionalHall.orElseGet(() -> null);
	}
	
	// Updates a Hall
	public Hall updateHall(Hall changedHall) {
		return HallRepository.save(changedHall); // Save the update Hall (bound) in our DB
	}
	
	// Delete a Hall
	public void deleteHall(Long id) {
		HallRepository.deleteById(id);
	}
}
