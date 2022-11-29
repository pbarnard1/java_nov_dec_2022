package com.adrianbarnard.week5startercode.controllers;

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

import com.adrianbarnard.week5startercode.models.University;
import com.adrianbarnard.week5startercode.services.UniversityService;

@Controller
public class UniversityController {
	@Autowired
	private UniversityService universityService;
	
	@GetMapping("/")
	public String homeRoute() {
		return "redirect:/universities";
	}
	
	// Page that displays all the universities
	@GetMapping("/universities")
	public String allUniversitiesPage(Model viewModel) {
		viewModel.addAttribute("universities",universityService.getAllUniversities());
		return "universities.jsp";
	}
	
	// Page to show a university
	@GetMapping("/universities/{id}")
	public String viewOneUniversityPage(Model viewModel, @PathVariable("id") Long id) {
		viewModel.addAttribute("thisUniversity", universityService.getOneUniversity(id));
		return "viewoneuniversity.jsp";
	}
	
	// Page that displays the form for adding a university
	@GetMapping("/universities/new")
	public String newUniversityPage(@ModelAttribute("newUniversity") University thisUniversity) {
		return "newuniversity.jsp";
	}
	
	// POST route that adds a university to the database
	@PostMapping("/universities/new")
	public String addUniversityToDB(
			@Valid @ModelAttribute("newUniversity") University aNewUniversity,
			BindingResult result) {
		if (result.hasErrors()) { // If validations fail
			// If your jsp file from before required you to pass anything in, you MUST pass those
			// items in AGAIN using model.addAttribute()
			return "newuniversity.jsp";
		}
		// If the validations succeed
		universityService.createUniversity(aNewUniversity);
		return "redirect:/universities";
	}
	
	// Page that displays the edit form
	@GetMapping("/universities/{id}/edit")
	public String editOneUniversityPage(@PathVariable Long id, Model viewModel) {
		viewModel.addAttribute("thisUniversity",universityService.getOneUniversity(id));
		return "edituniversity.jsp";
	}
	
	// PUT request route to edit the university
	@PutMapping("/universities/{id}/edit")
	public String editUniversityInDB(
			@Valid @ModelAttribute("thisUniversity") University changedUniversity,
			BindingResult result, @PathVariable Long id) {
		if (result.hasErrors()) { // If validations fail
			// If your jsp file from before required you to pass anything in, you MUST pass those
			// items in AGAIN using model.addAttribute()
			return "edituniversity.jsp";
		}
		// If the validations succeed
		universityService.updateUniversity(changedUniversity);
		return "redirect:/universities";
	}
	
	// Deleting a university
	
	/*
	 *  Instructor's note:
	 *  @GetMapping()
	 *  @DeleteMapping() does NOT work - you either have to separate them as seen below, or combine them.
	 */
	
	
//	// DELETE request - unfortunately, you can't combine like that
//	@GetMapping("/universities/{id}/delete") // For hyperlinks
//	public String deleteFromDBV1(@PathVariable("id") Long id) {
//		universityService.deleteUniversity(id);
//		return "redirect:/universities";
//	}
//	
//	@DeleteMapping("/universities/{id}/delete") // For buttons in forms
//	public String deleteFromDBV2(@PathVariable("id") Long id) {
//		universityService.deleteUniversity(id);
//		return "redirect:/universities";
//	}
	
	@RequestMapping(value="/universities/{id}/delete", method={RequestMethod.GET, RequestMethod.DELETE})
	public String deleteFromDB(@PathVariable("id") Long id) {
		universityService.deleteUniversity(id);
		return "redirect:/universities";
	}
}
