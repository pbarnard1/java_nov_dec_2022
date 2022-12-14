package com.adrianbarnard.errorhandling.controllers;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MainController {
	/* Handy reference: https://www.baeldung.com/spring-boot-custom-error-page */
	
	@GetMapping("/")
	public String homePage(HttpServletRequest request, HttpServletResponse response) throws IOException { // "throws IOException" is added to handle the new 500 error that we force
//		response.sendError(500);
		System.out.println(request.getMethod()); // Prints GET as this is a GET request route
		return "home.jsp";
	}
	
	@RequestMapping(value="/home",method={RequestMethod.GET, RequestMethod.POST})
	public String testWithMultipleRequestMethods(HttpServletRequest request) {
		String methodType = request.getMethod();
		if (methodType.equals("GET")) {
			System.out.println("This is a GET request - add your logic here!");
		} else { // POST request
			System.out.println("This is a POST request - add your logic here!");
		}
		return "home.jsp";
	}
}
