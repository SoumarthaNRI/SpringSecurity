package com.nrifintech.springsecurityapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nrifintech.springsecurityapp.model.User;
import com.nrifintech.springsecurityapp.service.UserService;

@RestController
@RequestMapping("/users")
public class UserController {
	
	@Autowired
	public UserService us;
	
	//localhost:8080/users/
	@GetMapping("/")
	public List<User> getAllUser(){
			
		return this.us.getAllUsers();
	}
	
	//localhost:8080/users/sunny
	@GetMapping("/{username}")
	public User getUser(@PathVariable("username") String username) {
		
		return this.us.getSingleUser(username);
		
	}
	
	//localhost:8080/users/create
	@PostMapping("/create")
	public  User addUser(@RequestBody User u) {
		
		return this.us.addUser(u);
	}
	
}
