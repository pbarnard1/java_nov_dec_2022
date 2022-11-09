package com.adrianbarnard.tuesdayweek3demo.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FirstController {
	@RequestMapping("/") // Root route - this is localhost:8080
	public String homeRoute() {
		return "<h1>Yay!  I just created my first Spring Boot app!</h1><p>Created by Adrian</p>";
	}
	
	// localhost:8080/favorites
	@GetMapping("/favorites") // Think of this as /favorites?name=Adrian&number=20, where name will be Adrian and number will be 20
	public String showNameAndFavoriteNumber(@RequestParam("name") String name, @RequestParam("number") String number) {
		return "<p>My name is "+ name + ", and my favorite number is "+ number +".</p>";
	}
	
	// Route: localhost:8080/favorites/{name}/{number}, where the {} represent path variables
	@GetMapping("/favorites/{name}/{number}") // Example: /favorites/jenny/20
	public String secondWayToDisplay(@PathVariable("name") String name, @PathVariable("number") Long number) {
		return "<p>Name: " + name + ", number: " + number + "</p>";
	}
}
