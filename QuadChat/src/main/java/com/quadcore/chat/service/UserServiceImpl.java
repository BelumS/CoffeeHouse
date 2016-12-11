/*package com.quadcore.chat.service;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.quadcore.chat.model.User;
import com.quadcore.chat.model.UserRole;
import com.quadcore.chat.repository.RoleRepository;
import com.quadcore.chat.repository.UserRepository;

public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	//@Autowired
	//private RoleRepository roleRepository;
	
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;

	@Override
	@Transactional
	public User save(User user) {
		
		//roleRepository.findOne(1001L);
		
		user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
		//user.addUserRole(role);
		
		return userRepository.save(user);
	}

	@Override
	public boolean findByLogin(String username, String password) 
	{
		User user = userRepository.findByUsername(username);
		
		if(user != null && user.getPassword().equals(password))
			return true;
		
		return false;
	}

	@Override
	public boolean findByUsername(String username) 
	{
		User user = userRepository.findByUsername(username);
		
		if(user != null)
		{
			return true;
		}
		return false;
	}
	
	@Override
	public boolean findByEmail(String email) 
	{
		User user = userRepository.findByEmail(email);
		
		if(user != null)
		{
			return true;
		}
		return false;
	}

}*/