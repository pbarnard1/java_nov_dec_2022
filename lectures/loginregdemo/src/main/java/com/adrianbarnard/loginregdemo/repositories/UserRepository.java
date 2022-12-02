package com.adrianbarnard.loginregdemo.repositories;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.adrianbarnard.loginregdemo.models.User;

@Repository // Don't forget this annotation!!!
public interface UserRepository extends CrudRepository<User, Long> {
	// List<User> findAll(); // Don't need to grab all users
	
	Optional<User> findByEmail(String email); // Find any users with the given email - if any
}
