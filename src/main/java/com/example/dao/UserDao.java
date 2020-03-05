package com.example.dao;

import org.springframework.stereotype.Component;

import com.example.model.Login;
import com.example.model.User;

public interface UserDao {

	int register(User user);
	
	User validateUser(Login login);
}
