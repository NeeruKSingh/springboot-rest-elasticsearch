package com.java.elasticsearch.service.impl;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.java.elasticsearch.helper.ElasticsearchHelper;
import com.java.elasticsearch.req.beans.Source;
import com.java.elasticsearch.req.beans.User;
import com.java.elasticsearch.service.IUserService;

@Service
public class UserServiceImpl implements IUserService {

	@Autowired
	private ElasticsearchHelper esHelper;

	@Override
	public User createUser(User user) {
		user.setId(UUID.randomUUID().toString());
		Source source = Source.getSource(user);
		esHelper.addDocument((Source) source);
		user.setMessage("User successfully created");
		return user;
	}

	@Override
	public User getUserById(String userId) {
		return esHelper.getUserById(userId);
	}

}
