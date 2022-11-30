package com.adrianbarnard.refresherproject.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {
	@GetMapping("/")
	public String homePage() {
		return "home.jsp";
	}
	
}
