package com.quadcore.chat.model;

//Models a UserInfo
public class UserInfo {
	
	private String username;
	private String password;
	private String email;
	
	public UserInfo(){}
	
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
	
	public String getEmail()
	{
		return email;
	}
	public void setEmail(String email)
	{
		this.email = email;
	}

}
