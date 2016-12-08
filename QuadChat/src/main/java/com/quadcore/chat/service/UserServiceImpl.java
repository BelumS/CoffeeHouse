package com.quadcore.chat.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.quadcore.chat.model.User;
import com.quadcore.chat.repository.UserRepository;

@Service("userService")
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
		user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
		//user.setUserRoles((Set<UserRole>) roleRepository.findAll());
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

}
