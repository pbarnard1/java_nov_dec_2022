package com.adrianbarnard.jspdemo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomeController {
	@GetMapping("/")
	public String homePage(
			@RequestParam(value="name", defaultValue="human", required=false) String name, 
			@RequestParam(value="color", defaultValue="blue", required=false) String color,
			@RequestParam(value="times", defaultValue="1", required=false) String count,
			Model viewModel) {
		// Passing in values to the .jsp file
		viewModel.addAttribute("firstName", name);
		viewModel.addAttribute("favColor", color);
		viewModel.addAttribute("repetitions", count);
		return "home.jsp";
	}
}
