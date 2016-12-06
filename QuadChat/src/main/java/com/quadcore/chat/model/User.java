package com.quadcore.chat.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.JoinColumn;
import javax.persistence.Table;


//Models a User's information
@Entity
@Table(name = "Users")
public class User {
	
	private Long userId;
	private String username;
	private String email;
	private String password;
	private boolean enabled;
	private Set<Role> userRoles;

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
	public User(String username, String email, String password, boolean enabled, Set<Role> userRoles)
	{
		this.username = username;
		this.email = email;
		this.password = password;
		this.enabled = enabled;
		this.userRoles = userRoles;
	}
	
	//Getters and setters
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "user_id")
	public Long getUserId()
	{
		return userId;
	}
	public void setUserId(Long userId)
	{
		this.userId = userId;
	}
	
	@Column(name = "username", unique = true, nullable = false, length = 36)
	public String getUsername()
	{
		return username;
	}
	public void setUsername(String username)
	{
		this.username = username;
	}
	
	@Column(name="user_email", unique = true, nullable = false, length = 50)
	public String getEmail()
	{
		return email;
	}
	public void setEmail(String email)
	{
		this.email = email;
	}
			
	@Column(name = "password", nullable = false, length = 20)
	public String getPassword()
	{
		return password;
	}
	public void setPassword(String password)
	{
		this.password = password;
	}
	
	@Column(name = "enabled")
	public boolean isEnabled()
	{
		return enabled;
	}
	public void setEnabled(boolean enabled)
	{
		this.enabled = enabled;
	}

	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "User_Roles", joinColumns = { @JoinColumn(name = "user_id")}, inverseJoinColumns = { @JoinColumn(name = "role_id")})
	public Set<Role> getUserRoles()
	{
		return this.userRoles;
	}
	public void setUserRoles(Set<Role> userRoles)
	{
		this.userRoles = userRoles;
	}
}
