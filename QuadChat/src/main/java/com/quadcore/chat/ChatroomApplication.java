package com.quadcore.chat;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.quadcore.chat.model.Role;
import com.quadcore.chat.model.User;
import com.quadcore.chat.model.UserRole;
import com.quadcore.chat.repository.RoleRepository;

/**
 * The class the bootstraps the Spring Boot Application
 * <p>
 * @author Quadcore
 * @version 1.0
 * @since 10/4/16
 * @see SpringApplication
 * 
 */
@SpringBootApplication(scanBasePackages = "com.quadcore.chat") //combination of @Configuration, @EnableAutoConfiguration, @EnableWebMvc, and @ComponentScan
public class ChatroomApplication {
	

	public static void main(String[] args) 
	{
		SpringApplication.run(ChatroomApplication.class, args);
	
		/*System.out.println("Let's inspect the beans provided by Spring Boot:");
		
		String[] beanNames = context.getBeanDefinitionNames();
		Arrays.sort(beanNames);
		
		for(String beanName : beanNames)
		{
			System.out.println(beanName);
		}
		//private RoleRepository roleRepository;
		
		User user = new User("Belum", "password", "belum@gmail.com");
		user.setActivated(true);
		user.setUserId(2L);
		user.setCreatedDate(new Date());
		//System.out.println("User Activated: " + user.isActivated() + 
			//	"\n" + user + "\nCreated: " + user.getCreatedDate());
		//System.out.println();
		
		//Set<Role> roles = new HashSet<Role>();
		//roles.add(new Role());
		//roles.add(new Role("ROLE_ADMIN"));
		Role roleUser = new Role("ROLE_USER");
		roleUser.setRoleId(1001L);
		
		Role roleAdmin = new Role("ROLE_ADMIN");
		roleAdmin.setRoleId(1002L);
		//System.out.println(roleUser + "\n" + roleAdmin);
		
		UserRole userRole = new UserRole();
		userRole.setUser(user);
		userRole.setRole(roleUser);
		userRole.setRole(roleAdmin);
		
		//Set<UserRole> userRoles = new HashSet<UserRole>();
		//userRoles.add(userRole);
		
		user.addUserRole(userRole);
		
		System.out.println("User: " + userRole.getUser());
		
		*///Now test creating a Set of Users, Roles, and UserRoles -- 12/26/16 @ 11:34am
		
		
	}
}
