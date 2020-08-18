package com.java.elasticsearch.service;

import com.java.elasticsearch.req.beans.User;


public interface IUserService {

	public User createUser(User user);

	public User getUserById(String userId);
}
