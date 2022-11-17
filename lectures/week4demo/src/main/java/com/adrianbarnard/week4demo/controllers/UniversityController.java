package com.adrianbarnard.week4demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.adrianbarnard.week4demo.models.University;
import com.adrianbarnard.week4demo.services.UniversityService;

@Controller
public class UniversityController {
	@Autowired
	private UniversityService universityService;
	
	@GetMapping("/")
	public String homeRoute() {
		return "redirect:/universities";
	}
	
	@GetMapping("/universities")
	public String allUniversitiesPage() {
		return "universities.jsp";
	}
	
	@GetMapping("/universities/new")
	public String newUniversityPage(@ModelAttribute("newUniversity") University thisUniversity) {
		return "newuniversity.jsp";
	}
}
