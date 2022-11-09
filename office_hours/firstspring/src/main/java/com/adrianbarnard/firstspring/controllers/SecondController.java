package com.adrianbarnard.firstspring.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class SecondController {
	@RequestMapping("/test")
	public String testJSPRoute(Model viewModel) {
		viewModel.addAttribute("name", "Jenny");
		return "FirstJSP.jsp";
	}
}
