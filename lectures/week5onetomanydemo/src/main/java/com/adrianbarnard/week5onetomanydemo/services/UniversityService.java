package com.adrianbarnard.week5onetomanydemo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.adrianbarnard.week5onetomanydemo.models.Hall;
import com.adrianbarnard.week5onetomanydemo.models.University;
import com.adrianbarnard.week5onetomanydemo.repositories.HallRepository;
import com.adrianbarnard.week5onetomanydemo.repositories.UniversityRepository;

@Service
public class UniversityService {
	@Autowired
	private UniversityRepository universityRepository;
	
	@Autowired
	private HallRepository hallRepository;
	
	// Methods to interact with our repository
	
	// Add a University
	public University createUniversity(University newUniversity) {
		return universityRepository.save(newUniversity); // Save the University (bound) in our DB
	}
	
	// Gets all Universities
	public List<University> getAllUniversities() {
		return universityRepository.findAll();
	}
	
	// Get all Universities in reverse alphabetical order
	public List<University> getAllUniversitiesReversed() {
		return universityRepository.findAllByOrderByNameDesc();
	}
	
	// Gets one University
	public University getOneUniversity(Long id) {
		Optional<University> optionalUniversity = universityRepository.findById(id);
//		if (optionalUniversity.isPresent()) {
//			return optionalUniversity.get();
//		} else {
//			return null;
//		}
		// One-line version where we return the object or return null
		// () -> uses something called a lambda function that will return the value null in this case
		return optionalUniversity.orElseGet(() -> null);
	}
	
	// Updates a University
	public University updateUniversity(University changedUniversity) {
		return universityRepository.save(changedUniversity); // Save the update University (bound) in our DB
	}
	
	// Delete a University
	public void deleteUniversity(Long id) {
		// METHOD 2 for deleting a University with Halls linked: just delete the University, but NOT the Halls
		
		// Disconnect each Hall from this University we're deleting - so we don't necessarily remove the Halls
		University thisUniversity = this.getOneUniversity(id);
		// Go through each Hall and disconnect this University
		for (Hall thisHall : thisUniversity.getHalls()) {
			thisHall.setUniversity(null); // This disconnects this Hall to the University we're deleting
			hallRepository.save(thisHall); // Tell the Hall repository to save the updated hall
		}
		universityRepository.deleteById(id);
	}
}
