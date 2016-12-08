package com.quadcore.chat.service;

import com.quadcore.chat.model.User;

public interface UserService {
	
	User save(User user);
	boolean findByLogin(String username, String password);
	boolean findByUsername(String username);
	boolean findByEmail(String email);
}
