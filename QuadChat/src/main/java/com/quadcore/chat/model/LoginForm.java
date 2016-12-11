package com.quadcore.chat.model;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.quadcore.chat.model.User;

//Login Form model, holds the validation rules for the form fields
public class LoginForm {
	
	//Private Fields
	//private User user;
	
	@NotNull
	@Size(min=5, max = 45, message ="Username should be at least 5 characters")
	private String username;
	
	@NotNull
	@Size(min=15, max = 60, message="Password must be at least 15 characters")
	private String password;
	
	//Getters and Setters
	public String getUsername()
	{
		return username;
	}
	public void setUsername(String username)
	{
		this.username = username;
	}
	
	public String getPassword()
	{
		return password;
	}
	public void setPassword(String password)
	{
		this.password = password;
	}
}
