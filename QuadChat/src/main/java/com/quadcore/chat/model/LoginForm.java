package com.quadcore.chat.model;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Holds the validation rules for the Login form fields
 * <p>
 * @author BelumEx
 * @since 12/8/16
 * @version 1.0
 * @category Spring MVC - Model
 * @see com.quadcore.chat.controller.LoginController
 * @see src/main/resources/templates/login.html
 *
 */
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
