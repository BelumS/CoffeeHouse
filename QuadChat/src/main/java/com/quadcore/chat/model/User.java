package com.quadcore.chat.model;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.Columns;

//Models a User's information
@Entity
@Table(name = "Users")
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@NotNull
	private String username;
	
	@NotNull
	private String email;
	
	//@NotNull
	private String password;
	
	//@NotNull
	private boolean enabled;
	
	//private String passwordConfirm;
	//private Set<UserRole> roles;
	
	//Public methods
	public User(){}
	
	public User(Long id)
	{
		this.id = id;
	}
	
	public User(String username, String email)
	{
		this.username = username;
		this.email = email;
	}
	
	public User(String username, String email, String password)
	{
		this.username = username;
		this.email = email;
		this.password = password;
	}
	
	//Getters and setters
	public Long getId()
	{
		return id;
	}
	public void setId(Long id)
	{
		this.id = id;
	}
	
	public String getUsername()
	{
		return username;
	}
	public void setUsername(String username)
	{
		this.username = username;
	}
	
	public String getEmail()
	{
		return email;
	}
	public void setEmail(String email)
	{
		this.email = email;
	}
			
	public String getPassword()
	{
		return password;
	}
	public void setPassword(String password)
	{
		this.password = password;
	}
	
	public boolean isEnabled()
	{
		return enabled;
	}
	public void setEnabled(boolean enabled)
	{
		this.enabled = enabled;
	}

}
