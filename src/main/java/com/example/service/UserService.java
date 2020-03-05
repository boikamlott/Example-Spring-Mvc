package com.example.service;

import org.springframework.stereotype.Component;

import com.example.model.Login;
import com.example.model.User;

public interface UserService {

	public int register(User user);
	
	public User validateUser(Login login);
}
