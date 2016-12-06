package com.quadcore.chat.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.quadcore.chat.model.User;
import com.quadcore.chat.repository.UserRepository;

@Controller
public class UserController {
	
	//Private fields
	@Autowired
	private UserRepository userRepository;
	
	//Create a new user and save it in the database
	@GetMapping("/create")
	@ResponseBody
	public String create(String username, String email)
	{
		String userId = "";
		
		try {
			User user = new User(username, email, "password", true);
			userRepository.save(user);
			userId = String.valueOf(user.getUserId());
			
		}catch(Exception e) {
			return "Error creating the user: " + e.toString();
		}
		
		return "User successfully created with id = " + userId;
	}
	
	//Delete the user having passed the ID
	@GetMapping("/delete")
	@ResponseBody
	public String delete(Long id)
	{
		try {
			User user = new User(id);
			userRepository.delete(user);
		} catch(Exception ex) {
			return "Error deleting the user: " + ex.toString();
		}
		
		return "User successfully deleted!";
	}
	
	//Return the ID for the user having passed the email.
	@GetMapping("/get-by-email")
	@ResponseBody
	public String getByEmail(String email)
	{
		String userId = "";
		
		try {
			User user = userRepository.findByEmail(email);
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
			User user = userRepository.findOne(id);
			user.setUsername(username);
			user.setEmail(email);
			userRepository.save(user);
			
		} catch(Exception e) {
			return "Error updating the user: " + e.toString();
		}
		
		return "User successfully updated!";
	}
			

}
