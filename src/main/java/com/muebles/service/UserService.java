package com.muebles.service;

import com.muebles.model.User;

public interface UserService {
	public User findUserByEmail(String email);
	public void saveUser(User user);
}
