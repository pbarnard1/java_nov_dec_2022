package com.adrianbarnard.firstspring.controllers;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FirstController {
	@RequestMapping("/")
	public String homePage() {
		return "<h1>Hello there!</h1><p>This is my first page</p>";
	}
	
	@RequestMapping("/hello/{name}")
	public String showName(@PathVariable String name) {
		return "<h1>Hello " + name + "!</h1>";
	}
	
	@RequestMapping("/blog/{id}")
	public String displayBlogNumber(@PathVariable("id") Long blogID) {
		return "<p>This is blog number " + blogID.toString() + "!</p>";
	}
}
