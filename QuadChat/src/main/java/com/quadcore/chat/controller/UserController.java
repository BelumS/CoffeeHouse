package com.quadcore.chat.controller;


 //Reserved for Admin Controller, and Register Controller

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.quadcore.chat.model.User;
import com.quadcore.chat.service.UserService;

/**
 * 
 * @author Quadcore
 * @category The Controller that determines an Admin's behavior
 * @version 1.0
 */
@Controller
public class UserController {
	
	//Private fields
	@Autowired
	private UserService userService;
	
	//Create a new user and save it in the database
	@GetMapping("/admin/create")
	@ResponseBody
	public String create(String username, String email)
	{
		String userId = "";
		
		try {
			User user = new User(username, email, "password");
			userService.save(user);
			userId = String.valueOf(user.getUserId());
			
		}catch(Exception e) {
			return "Error creating the user: " + e.toString();
		}
		
		return "User successfully created with id = " + userId;
	}
	
	//Delete the user having passed the ID
	@GetMapping("/admin/delete")
	@ResponseBody
	public String delete(Long id)
	{
		try {
			User user = new User(id);
			userService.delete(user);
		
		} catch(Exception ex) {
			return "Error deleting the user: " + ex.toString();
		}
		
		return "User successfully deleted!";
	}
	
	//Return the ID for the user having passed the email.
	@GetMapping("/admin/get-by-email")
	@ResponseBody
	public String getByEmail(String email)
	{
		String userId = "";
		User user = new User();
		
		try {
			//User user = userRepository.findByEmail(email);
			userId = String.valueOf(user.getUserId());
		}catch(Exception e) {
			return "User not found: " + e.toString();
		}
		
		return "The user id is: " + userId;
	}
	
	//Update the username, and email of the User in the database, having passed the ID
	@GetMapping
	@ResponseBody
	public String update(Long id, String username, String email)
	{
		try {
			User user = userService.findOne(id);
			user.setUsername(username);
			user.setEmail(email);
			userService.save(user);
			
		} catch(Exception e) {
			return "Error updating the user: " + e.toString();
		}
		
		return "User successfully updated!";
	}
}