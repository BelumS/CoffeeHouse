package com.quadcore.chat.model;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

//Login Form model, holds the validation rules for the form fields
public class LoginForm {
	
	@Size(min=2, max = 30, message ="Username should be at least 20 characters")
	private String username;
	
	@NotNull
	@Size(min=1, max = 20, message="Password must be less than 20 characters")
	private String password;
	
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
