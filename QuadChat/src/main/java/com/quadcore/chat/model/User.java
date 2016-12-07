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
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

//Models a User's information
@Entity
@Table(name = "Users", uniqueConstraints = {
@UniqueConstraint(columnNames = "username"),
@UniqueConstraint(columnNames = "user_email")})
public class User implements Serializable {

	private static final long serialVersionUID = -1224394021146256127L;
	
	private Long userId;
	private String username;
	private String email;
	private String password;
	private Integer enabled;
	private Set<UserRole> userRoles = new HashSet<UserRole>();

	//Public methods
	public User(){}
	public User(Long userId)
	{
		this.userId = userId;
	}
	public User(String username, String email, String password, Integer enabled)
	{
		this.username = username;
		this.email = email;
		this.password = password;
		this.enabled = enabled;
	}
	public User(String username, String email, String password, Integer enabled, Set<UserRole> userRoles)
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
	public Integer isEnabled()
	{
		return enabled;
	}
	public void setEnabled(Integer enabled)
	{
		this.enabled = enabled;
	}

	//Creates the User_Roles Table, with the attached foreign keys
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "primaryKey.role", cascade = CascadeType.ALL)
	public Set<UserRole> getUserRoles()
	{
		return this.userRoles;
	}
	public void setUserRoles(Set<UserRole> userRoles)
	{
		this.userRoles = userRoles;
	}
/*	public void addUserRoles(UserRole role)
	{
		this.userRoles.add(role);
	}*/
	
	public static long getSerialVersionUid() {
		return serialVersionUID;
	}
	
	@Override
	public String toString()
	{
		String result = String.format("User[user_id=%d%n username='%s'%n email=%s%n password=%s%n enabled=]", 
				userId, username, email, password, enabled);
		
		if(userRoles != null)
		{
			for(UserRole userRole : userRoles)
			{
				result += String.format("User Roles[role_id=%d, role_name='%s']%n", 
						userRole.getRole().getRoleId(), userRole.getRole().getRoleName());
			}
		}
		return result;
	}

}
