package com.quadcore.chat.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

//Models a User's information
@Entity
@Table(name = "Users")
public class User {
	
	private Long userId;
	private String username;
	private String email;
	private String password;
	private boolean enabled;
	
	//private String passwordConfirm;
	//private Set<UserRole> roles;
	
	//Public methods
	public User(){}
	public User(Long userId)
	{
		this.userId = userId;
	}
	
	public User(String username, String email, String password, boolean enabled)
	{
		this.username = username;
		this.email = email;
		this.password = password;
		this.enabled = enabled;
	}
	
	//Getters and setters
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "user_id")
	public Long getId()
	{
		return userId;
	}
	public void setId(Long userId)
	{
		this.userId = userId;
	}
	
	@NotNull
	@Column(name = "username", unique = true, length = 36)
	public String getUsername()
	{
		return username;
	}
	public void setUsername(String username)
	{
		this.username = username;
	}
	
	@NotNull
	@Column(name="user_email", unique = true, length = 50)
	public String getEmail()
	{
		return email;
	}
	public void setEmail(String email)
	{
		this.email = email;
	}
			
	@NotNull
	@Column(name = "password", length = 20)
	public String getPassword()
	{
		return password;
	}
	public void setPassword(String password)
	{
		this.password = password;
	}
	
	@NotNull
	@Column(name = "enabled")
	public boolean isEnabled()
	{
		return enabled;
	}
	public void setEnabled(boolean enabled)
	{
		this.enabled = enabled;
	}

}
