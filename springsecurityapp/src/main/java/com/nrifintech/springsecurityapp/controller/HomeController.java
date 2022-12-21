package com.nrifintech.springsecurityapp.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/public")
public class HomeController {
	
	//localhost:8080/public/home
	@GetMapping("/home")
	public String home() {
		return "Welcome to Home Page";
	}
	
	//localhost:8080/public/login
	@GetMapping("/login")
	public String login() {
		return "Welcome to Login Page";
	}
	
	//localhost:8080/public/register
	@GetMapping("/register")
	public String register() {
		return "Welcome to Register Page";
	}

}
