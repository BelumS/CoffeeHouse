package com.quadcore.chat.dao;

import org.springframework.data.repository.CrudRepository;

import com.quadcore.chat.model.User;

public interface UserDAO extends CrudRepository<User, Long>{
	
	boolean authenticate(String username, String password); //login authentication functionality
	//void addUser(User userInfo);// *reserved for ADMIN role
	//void changeUsername(User userInfo, String username); *cannot be done? || *reserved for ADMIN
	//void changePassword(User user, String password);
	//void changeEmail(User user, String email);
	//void deleteUser(User userInfo); *reserved for ADMIN role
	public User findById(long id);
	public User findByUsername(String username);
	public User findByEmail(String email);
}
