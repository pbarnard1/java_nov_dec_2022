package com.adrianbarnard.loginregdemo.services;

import java.util.Optional;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import com.adrianbarnard.loginregdemo.models.LoginUser;
import com.adrianbarnard.loginregdemo.models.User;
import com.adrianbarnard.loginregdemo.repositories.UserRepository;

@Service // Don't forget this!!!
public class UserService {
	// Add additional validations here, like checking to make sure the passwords match for registering, checking for unique email,
	// and checking for a valid login
	
	@Autowired
	private UserRepository userRepo;
	
	public User register(User newUser, BindingResult result) {
		// Check to see if the passwords agree
		if (!newUser.getConfirmedPassword().equals(newUser.getPassword())) { // !true -> false; !false -> true
			result.rejectValue("confirmedPassword", "Matches", "Your passwords must agree!");
		}
		// Check to see whether we have any users registered already with the email
		Optional<User> optionalUser = userRepo.findByEmail(newUser.getEmail());
		// If a user already registered with that email
		if (optionalUser.isPresent()) {
			result.rejectValue("email", "Matches", "Email is already registered.");
		}
		// Return the user back - if these validations are okay
		if (result.hasErrors()) {
			return null;
		} else { // All validations are good
			// Hash the password and then save the user in the database
			String hashedPassword = BCrypt.hashpw(newUser.getPassword(), BCrypt.gensalt());
			newUser.setPassword(hashedPassword); // Hashed password will be saved in the DB
			return userRepo.save(newUser); // Save new user in DB
		}
	}
	
	// Custom validations for checking for a valid login
	public User login(LoginUser newLogin, BindingResult result) {
		// Check to see if anyone the given email is found
		// Check to see whether we have any users registered with that email
		Optional<User> optionalUser = userRepo.findByEmail(newLogin.getLoginEmail());
		if (!optionalUser.isPresent()) { // If User is NOT found with that email
			result.rejectValue("loginEmail", "Matches", "Invalid login credentials.");
			result.rejectValue("loginPassword", "Matches", "Invalid login credentials.");
			return null; // Stop us from checking the password - no need if nobody exists with that email
		}
		User thisUser = optionalUser.get(); // Return the actual User with that email
		// Check the password
		if (!BCrypt.checkpw(newLogin.getLoginPassword(), thisUser.getPassword())) { // Passwords don't agree
			result.rejectValue("loginEmail", "Matches", "Invalid login credentials.");
			result.rejectValue("loginPassword", "Matches", "Invalid login credentials.");
			return null; // Can't return the User - invalid login
		}
		return thisUser;
	}
	
	public User findById(Long id) {
		Optional<User> optionalUser = userRepo.findById(id);
		return optionalUser.orElseGet(() -> null);
	}
	
	public User findByEmail(String email) {
		Optional<User> optionalUser = userRepo.findByEmail(email);
		return optionalUser.orElseGet(() -> null);
	}
	
	public User updateUser(User newUser) {
		return userRepo.save(newUser);
	}
	
	public void deleteUser(Long id) {
		userRepo.deleteById(id);
	}
}
