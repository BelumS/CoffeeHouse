package com.quadcore.chat.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.quadcore.chat.model.User;

@Repository
@Transactional
public interface UserRepository extends JpaRepository<User, Long>{
	
	//boolean authenticate(String username, String password); //login authentication functionality
	//public User findById(long id);
	public User findByUsername(String username);
	public User findByEmail(String email);
}
