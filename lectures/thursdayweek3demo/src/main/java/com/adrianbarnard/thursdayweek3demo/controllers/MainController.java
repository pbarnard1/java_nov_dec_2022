package com.adrianbarnard.thursdayweek3demo.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class MainController {
	@GetMapping("/") // OR @RequestMapping()
	public String homePage() { // This route will basically a form
		return "home.jsp";
	}
	
	@PostMapping("/processform") // OR @RequestMapping(value="/processform", method=RequestMethod.POST)
	public String handleForm(
			@RequestParam(value="username") String username,
			@RequestParam(value="email") String emailFromForm,
			@RequestParam(value="age", defaultValue="0") String age,
			@RequestParam(value="password") String password,
			HttpSession session, RedirectAttributes flashAttributes) {
		boolean isValid = true; // Assume everything in the form is good
		if (username.length() < 3) { // Message: user name must be 3 or more characters
			flashAttributes.addFlashAttribute("usernameMessage", "User name must be 3 or more characters");
			isValid = false;
		}
		if (Integer.parseInt(age) < 18) { // Message: age must be 18 or older
			flashAttributes.addFlashAttribute("ageMessage", "You must be 18 or older");
			isValid = false;
		}
		if (!isValid) { // Send back to form if validations fail
			return "redirect:/";
		}
		// Save values in session so they're available in other routes
		session.setAttribute("name", username);
		session.setAttribute("email", emailFromForm);
		session.setAttribute("age", age);
		session.setAttribute("password", password);
		return "redirect:/results";
	}
	
	@GetMapping("/results")
	public String resultsPage(Model viewModel, HttpSession session) {
		// Put the values from session into our view model so they're available in our jsp file
		viewModel.addAttribute("username", (String) session.getAttribute("name"));
		viewModel.addAttribute("email", (String) session.getAttribute("email"));
		viewModel.addAttribute("age", (String) session.getAttribute("age"));
		viewModel.addAttribute("password", (String) session.getAttribute("password"));	
		
		return "output.jsp";
	}
}
