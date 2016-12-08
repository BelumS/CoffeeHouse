package com.quadcore.chat.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.quadcore.chat.model.User;

@Repository
public interface UserRepository extends CrudRepository<User, Long>{
	
	//boolean authenticate(String username, String password); //login authentication functionality
	//public User findById(long id);
	User findByUsername(String username);
	User findByEmail(String email);
}
