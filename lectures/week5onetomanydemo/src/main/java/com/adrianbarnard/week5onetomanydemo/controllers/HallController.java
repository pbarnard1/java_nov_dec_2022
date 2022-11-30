package com.adrianbarnard.week5onetomanydemo.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.adrianbarnard.week5onetomanydemo.models.Hall;
import com.adrianbarnard.week5onetomanydemo.services.HallService;
import com.adrianbarnard.week5onetomanydemo.services.UniversityService;

@Controller
public class HallController {
	// Here are our services!
	@Autowired
	private HallService hallService;
	
	@Autowired
	private UniversityService universityService;
	
	// All halls page
	@GetMapping("/halls")
	public String allHallsPage() {
		return null; // Placeholder
	}
	
	// New hall form
	@GetMapping("/halls/new")
	public String newHallPage(@ModelAttribute("newHall") Hall newHall, Model viewModel) {
		viewModel.addAttribute("universities", universityService.getAllUniversities());
		return "newhall.jsp";
	}
	
	// View one hall page
	@GetMapping("/halls/{id}")
	public String viewOneHallPage(@PathVariable("id") Long id) {
		return null; // Placeholder
	}
	
	// Edit page
	@GetMapping("/halls/{id}/edit")
	public String editOneHallPage(@PathVariable("id") Long id) {
		return null; // Placeholder
	}
	
	/*
	 * Hidden routes
	 */
	// Add Hall to DB
	@PostMapping("/halls/new")
	public String addHallToDB(@Valid @ModelAttribute("newHall") Hall newHall, BindingResult result, Model viewModel) {
		if (result.hasErrors()) { // If validations fail
			// If your jsp file from before required you to pass anything in, you MUST pass those
			// items in AGAIN using model.addAttribute()
			viewModel.addAttribute("universities", universityService.getAllUniversities());
			return "newhall.jsp";
		}
		// If the validations succeed
		hallService.createHall(newHall);
		return "redirect:/halls";
	}
	
	// Editing a Hall in DB
	@PutMapping("/halls/{id}/edit")
	public String editHallInDB(@PathVariable("id") Long id) {
		return "redirect:/halls"; // Placeholder
	}
	
	// Route to delete a Hall from the DB
	@RequestMapping(value="/halls/{id}/delete", method={RequestMethod.GET, RequestMethod.DELETE})
	public String deleteHallFromDB(@PathVariable("id") Long id) {
		return "redirect:/halls"; // Placeholder
	}
}
