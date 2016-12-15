package com.quadcore.chat.service;

import java.util.Date;
import javax.annotation.PostConstruct;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.quadcore.chat.model.Role;
import com.quadcore.chat.model.User;
import com.quadcore.chat.model.UserRole;
import com.quadcore.chat.repository.RoleRepository;
import com.quadcore.chat.repository.UserRepository;
import com.quadcore.chat.repository.UserRoleRepository;

/**
 * Programmatically creates an Admin account upon the database's Initialization
 * <p>
 * @author Quadcore
 * @since 12/12/16
 * @version 2.0
 * @category Service
 *
 */
@Service
@Transactional
public class InitDBService {
	
	//Setup repositories for bean DI
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private RoleRepository roleRepository;
	
	@Autowired
	private UserRoleRepository userRoleRepository;
	
	@PostConstruct
	public void init()
	{
		if(roleRepository.findByRoleName("ROLE_ADMIN") == null)
		{
			//Create a user role
			Role roleUser = new Role();
			roleUser.setRoleName("ROLE_USER");
			roleRepository.save(roleUser);
			
			//Create an admin role
			Role roleAdmin = new Role();
			roleAdmin.setRoleName("ROLE_ADMIN");
			roleRepository.save(roleAdmin);
			
			//Create an admin user
			User userAdmin = new User();
			userAdmin.setUsername("coffeeadmin");
			BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
			userAdmin.setPassword(encoder.encode("password"));
			userAdmin.setEmail("coffeeadmin@coffee.net");
			userAdmin.setActivated(true);
			userAdmin.setCreatedDate(new Date());
			userRepository.save(userAdmin);
			
			//Add above roles to the join table
			UserRole userRole = new UserRole();
			userRole.getPK().setUser(userAdmin);
			userRole.getPK().setRole(roleUser);
			userRole.getPK().setRole(roleAdmin);
			userRoleRepository.save(userRole);
		}
	}
}
