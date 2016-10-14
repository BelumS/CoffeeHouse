package com.quadcore.chat.service;

import com.quadcore.chat.model.User;

public interface UserService {
	
	void addUser(User user);
	void changeUsername(User user, String username);
	void changePassword(User user, String password);
	void changeEmail(User user, String email);
	void deleteUser(User user);
}
