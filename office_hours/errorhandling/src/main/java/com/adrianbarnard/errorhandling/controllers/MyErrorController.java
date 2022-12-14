package com.adrianbarnard.errorhandling.controllers;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MyErrorController implements ErrorController { // Note the interface ErrorController
	
	@RequestMapping("/error")
	public String errorPage(HttpServletRequest request) {
		Object status = request.getAttribute(RequestDispatcher.ERROR_STATUS_CODE); // Return the error status code, if any
		if (status != null) { // If there is an error code (not null)
			Integer statusCode = Integer.valueOf(status.toString()); // Store the actual error code as an integer
			if (statusCode == HttpStatus.NOT_FOUND.value()) { // If it's a 404 error
				return "error404.jsp";
			} else if (statusCode == HttpStatus.INTERNAL_SERVER_ERROR.value()) { // If it's a 500 error
				return "error500.jsp";
			}
		}
		return "error.jsp"; // Generic error page if it's none of the other error codes
	}
}
