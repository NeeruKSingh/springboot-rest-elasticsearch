package com.java.elasticsearch.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.java.elasticsearch.beans.User;
import com.java.elasticsearch.service.IUserService;

@RestController
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private IUserService userService;

	

	@PostMapping("")
	public User createUser(@RequestBody User user) {
		return userService.createUser(user);
	}
	
	
	@GetMapping("/userid/{userid}")
	public User getUserById(@PathVariable("userid") int userId) {
		return userService.getUserById(userId);
	}
	
	
}
