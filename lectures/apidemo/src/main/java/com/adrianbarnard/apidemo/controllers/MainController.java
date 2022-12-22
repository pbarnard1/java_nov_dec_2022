package com.adrianbarnard.apidemo.controllers;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {
	// You may have to right click on Project -> "Maven" -> "update project..." -> click OK.
	@Value("${nasa_api_key:TEST}") // Default value of "TEST" if not found
	private String thisApiKey;
	
	@GetMapping("/")
	public String mainPage() {
		System.out.println(thisApiKey);
		return "home.jsp";
		// Link to grab picture of day from NASA: https://api.nasa.gov/planetary/apod&api_key=???
	}
}
