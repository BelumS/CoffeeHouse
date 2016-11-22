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
	private long id;
	
	@NotNull
	private String username;
	
	@NotNull
	private String password;
	//private String passwordConfirm;
	//private Set<Role> roles;
	
	//Public methods
	public User(){}
	
	public User(long id)
	{
		this.id = id;
	}
	
	public User(String username, String password)
	{
		this.username = username;
		this.password = password;
	}
	
	//Getters and setters
	public long getId()
	{
		return id;
	}
	public void setId(long id)
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
	
	public String getPassword()
	{
		return password;
	}
	public void setPassword(String password)
	{
		this.password = password;
	}
	
	/*public String getPasswordConfirm()
	{
		return passwordConfirm;
	}
	public void setPasswordConfirm(String passwordConfirm)
	{
		this.passwordConfirm = passwordConfirm;
	}*/
	
	
}
