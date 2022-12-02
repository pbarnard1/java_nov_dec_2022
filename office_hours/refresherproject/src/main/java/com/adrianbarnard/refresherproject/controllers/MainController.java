package com.adrianbarnard.refresherproject.controllers;

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

import com.adrianbarnard.refresherproject.models.Plant;
import com.adrianbarnard.refresherproject.services.PlantService;

@Controller
public class MainController {
	@Autowired
	private PlantService plantServ;
	
	@GetMapping("/")
	public String homePage(Model viewModel) {
		viewModel.addAttribute("allPlants", plantServ.findAllPlants());
		return "home.jsp";
	}
	
	@GetMapping("/plants/new")
	public String addPlantPage(@ModelAttribute("newPlant") Plant newPlant) {
		return "addplant.jsp";
	}
	
	@PostMapping("/plants/new")
	public String addPlantToDB(@Valid @ModelAttribute("newPlant") Plant newPlant, BindingResult result) {
		if (result.hasErrors()) {
			return "addplant.jsp";
		} else {
			plantServ.createPlant(newPlant);
			return "redirect:/";
		}
	}
	
	// Displaying one plant
	@GetMapping("/plants/{id}")
	public String viewOnePlant(@PathVariable("id") Long id, Model viewModel) {
		viewModel.addAttribute("thisPlant", plantServ.findPlantById(id));
		return "viewplant.jsp";
	}
	
	// Edit page
	@GetMapping("/plants/{id}/edit")
	public String editOnePlantPage(@PathVariable Long id, Model viewModel) {
		viewModel.addAttribute("editedPlant", plantServ.findPlantById(id));
		return "editplant.jsp";
	}
	
	// Edit in DB
	@PutMapping("/plants/{id}/edit")
	public String editPlantInDB(
			@Valid @ModelAttribute("editedPlant") Plant changedPlant, 
			BindingResult result, @PathVariable("id") Long id) {
		if (result.hasErrors()) {
			return "editplant.jsp"; // No need to pass anything in again in this case
		}
		plantServ.updatePlant(changedPlant);
		return "redirect:/plants/" + id; // Redirect to the individual plant's page
	}
	
	// Delete from DB
	@GetMapping("/plants/{id}/delete")
	public String deletePlant(@PathVariable Long id) {
		plantServ.deletePlant(id);
		return "redirect:/";
	}
}
