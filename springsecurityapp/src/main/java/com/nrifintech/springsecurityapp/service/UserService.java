package com.nrifintech.springsecurityapp.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.nrifintech.springsecurityapp.model.User;

@Service
public class UserService {

	List<User> list = new ArrayList<>();
	
	public UserService() {
		
		list.add(new User("sunny","sunny","sunny@gmail.com"));	
		list.add(new User("mack","mack","mack@gmail.com"));	
	}
	
	//get all the users
	public List<User> getAllUsers(){
		
		return this.list;
	}
	
	//get single user
	public User getSingleUser(String uname) {
		
		return this.list.stream().filter((user)->user.getUsername().equals(uname)).findAny().orElse(null);	
	}
	
	//add a user
	public User addUser(User user) {
		
		this.list.add(user);
		return user;
		
	}
	
}
