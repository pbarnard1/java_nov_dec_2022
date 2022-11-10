package com.adrianbarnard.wednesdayweek3demo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
	@GetMapping("/")
	public String homePage(Model viewModel) {
		// Adding attributes to our model to send to the client along with the .jsp file
		viewModel.addAttribute("userName","AdrianB");
		viewModel.addAttribute("number", 20);
		viewModel.addAttribute("salary", 200000);
//		ArrayList<String> favoriteQuotes = new ArrayList<String>();
//		favoriteQuotes.add("Roads?  Where we're going we don't need roads.");
//		favoriteQuotes.add("No, I am your father!");
		String[] favoriteQuotes = {"Roads?  Where we're going we don't need roads.", "No, I am your father!"};
		viewModel.addAttribute("quotes", favoriteQuotes);
		return "home.jsp"; // Return or serve this jsp file
	}
}
