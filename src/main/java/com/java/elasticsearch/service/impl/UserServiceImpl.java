package com.java.elasticsearch.service.impl;

import org.springframework.stereotype.Service;

import com.java.elasticsearch.beans.User;
import com.java.elasticsearch.service.IUserService;

@Service
public class UserServiceImpl implements IUserService {

	@Override
	public User createUser(User user) {
		user.setMessage("User successfully created");
		return user;
	}

	@Override
	public User getUserById(int userId) {
		User user = new User();
		user.setId(userId);
		user.setName("neeru" + userId);
		user.setMessage("Get user successfully");
		return user;
	}

}
