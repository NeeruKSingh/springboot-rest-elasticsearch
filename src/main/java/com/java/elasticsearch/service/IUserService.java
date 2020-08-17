package com.java.elasticsearch.service;

import com.java.elasticsearch.beans.User;


public interface IUserService {

	public User createUser(User user);

	public User getUserById(int userId);
}
