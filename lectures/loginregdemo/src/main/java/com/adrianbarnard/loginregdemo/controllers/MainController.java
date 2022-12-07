package com.adrianbarnard.loginregdemo.controllers;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.adrianbarnard.loginregdemo.models.LoginUser;
import com.adrianbarnard.loginregdemo.models.User;
import com.adrianbarnard.loginregdemo.services.UserService;

@Controller
public class MainController {
	@Autowired
	private UserService userServ;
	
	// Login/registration page
	@GetMapping("/")
	public String loginRegPage(@ModelAttribute("registerUser") User newUser, @ModelAttribute("loginUser") LoginUser loginUser) {
		// model.addAttribute("registerUser", new User());
		return "loginreg.jsp";
	}
	
	// Dashboard - must be logged in
	@GetMapping("/dashboard")
	public String dashboard(HttpSession session, Model viewModel) {
		if (session.getAttribute("userId") == null) { // If you're not logged in...
			return "redirect:/"; // ...send back to login/reg page if nobody is logged in
		}
		Long userId = (Long) session.getAttribute("userId");
		viewModel.addAttribute("loggedUser", userServ.findById(userId));
		return "dashboard.jsp";
	}
	
	// Register user, if valid
	@PostMapping("/register")
	public String registerUser(@Valid @ModelAttribute("registerUser") User newUser, BindingResult result, 
			@ModelAttribute("loginUser") LoginUser loginUser,
			HttpSession session) {
		User changedUser = userServ.register(newUser, result); // Call on additional validations here!
		if (result.hasErrors()) { // Any errors of any kind - including the additional validations
			// model.addAttribute("loginUser", new LoginUser());
			return "loginreg.jsp";
		}
		// User is already registered in the register method in the service file
		session.setAttribute("userId", changedUser.getId());
		// Go to the dashboard
		return "redirect:/dashboard";
	}
	
	// Login user, if valid
	@PostMapping("/login")
	public String loginUser(@Valid @ModelAttribute("loginUser") LoginUser loginUser, BindingResult result,
			@ModelAttribute("registerUser") User newUser, HttpSession session) {
		User foundUser = userServ.login(loginUser, result);
		if (result.hasErrors()) { // Any errors of any kind - including the additional validations
			return "loginreg.jsp";
		}
		// User is already registered in the register method in the service file
		session.setAttribute("userId", foundUser.getId());
		// Go to the dashboard
		return "redirect:/dashboard";
	}
	
	// Log out by clearing session and sending back to login/reg page
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate(); // Clears session
		return "redirect:/";
	}
}
