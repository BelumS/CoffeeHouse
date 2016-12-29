package com.quadcore.chat.service;

import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.quadcore.chat.model.User;
import com.quadcore.chat.model.UserRole;
import com.quadcore.chat.repository.RoleRepository;
import com.quadcore.chat.repository.UserRepository;
import com.quadcore.chat.repository.UserRoleRepository;

/**
 * An implementation of the UserRepository
 * <p>
 * @author Quadcore
 * @since 12/12/16
 * @version 2.0
 * @category Service
 * @see com.quadcore.chat.repository.UserRepository
 *
 */
@Service
@Transactional
public class UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private RoleRepository roleRepository;
	
	@Autowired
	private UserRoleRepository userRoleRepository;
	
	public List<User> findAll() 
	{
		return userRepository.findAll();
	}
	
	public User findOne(long id) 
	{
		return userRepository.findOne(id);
	}
	
	public void save(User user) 
	{	
		UserRole userRole = new UserRole();
		userRole.getPK().setRole(roleRepository.findByRoleName("ROLE_USER"));
		
		BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
		user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
		user.setActivated(true);
		user.setCreatedDate(new Date());
		userRepository.save(user);
		
		userRole.getPK().setUser(user);
		userRoleRepository.save(userRole);
	}
	
	public void delete(User user)
	{
		userRepository.delete(user);
	}

	public boolean findByLogin(String username, String password) 
	{
		User user = userRepository.findByUsername(username);
		
		if(user != null && user.getPassword().equals(password))
			return true;
		
		return false;
	}

	public boolean findByUsername(String username) 
	{
		User user = userRepository.findByUsername(username);
		
		if(user != null)
		{
			return true;
		}
		return false;
	}
	
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