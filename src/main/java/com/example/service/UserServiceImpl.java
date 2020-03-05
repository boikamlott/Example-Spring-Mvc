package com.example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.dao.UserDao;
import com.example.model.Login;
import com.example.model.User;

public class UserServiceImpl implements UserService {
	@Autowired
	UserDao userDao;
	
	public User validateUser(Login login) {
		return userDao.validateUser(login);
	}

	public int register(User user) {
		return userDao.register(user);
	}
}
