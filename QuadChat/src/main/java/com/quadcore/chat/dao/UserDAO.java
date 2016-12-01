package com.quadcore.chat.dao;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;

import com.quadcore.chat.model.User;

@Transactional
public interface UserDAO extends CrudRepository<User, Long>{
	
	//boolean authenticate(String username, String password); //login authentication functionality
	//public User findById(long id);
	//public User findByUsername(String username);
	public User findByEmail(String email);
}
