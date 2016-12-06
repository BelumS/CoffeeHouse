package com.quadcore.chat.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.JoinColumn;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;


//Models a User's information
@Entity
@Table(name = "Users", uniqueConstraints = {
		@UniqueConstraint(columnNames = "username"),
		@UniqueConstraint(columnNames = "user_email")})
public class User implements Serializable{
	
	private static final long serialVersionUID = -1781000424836183523L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "user_id")
	private Long userId;
	
	@Column(name = "username", unique = true, nullable = false, length = 36)
	private String username;
	
	@Column(name="user_email", unique = true, nullable = false, length = 50)
	private String email;
	
	@Column(name = "password", nullable = false, length = 20)
	private String password;
	
	@Column(name = "enabled")
	private boolean enabled;
	
	//Creates the User_Roles Table, with the attached foreign keys
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "User_Roles", 
				joinColumns = { @JoinColumn(name = "user_id", referencedColumnName = "user_id")}, 
				inverseJoinColumns = { @JoinColumn(name = "role_id", referencedColumnName = "role_id")})
	private Set<Role> userRoles = new HashSet<Role>(0);

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
	public Long getUserId()
	{
		return userId;
	}
	public void setUserId(Long userId)
	{
		this.userId = userId;
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

	public Set<Role> getUserRoles()
	{
		return this.userRoles;
	}
	public void setUserRoles(Set<Role> userRoles)
	{
		this.userRoles = userRoles;
	}
	
	@Override
	public String toString()
	{
		String result = String.format("User[user_id=%d%n username='%s'%n email=%s%n password=%s%n enabled=]", 
				userId, username, email, password, enabled);
		
		if(userRoles != null)
		{
			for(Role role : userRoles)
			{
				result += String.format("User Roles[role_id=%d, role_name='%s']%n", 
						role.getRoleId(), role.getRoleName());
			}
		}
		
		return result;
	}

	
}
