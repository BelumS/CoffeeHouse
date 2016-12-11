package com.quadcore.chat.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

//Models a User table from the database
@Entity
@Table(name = "Users")
public class User {

	//Private fields
	private Long userId;
	private String username;
	private String password;
	private String confirmPassword;
	private String email;
	private Set<UserRole> userRole = new HashSet<UserRole>();
	
	//Public methods
	public User(){}
	public User(Long userId)
	{
		this.userId = userId;
	}
	public User(String username, String password, String email)
	{
		this.username = username;
		this.password = password;
		this.email = email;
	}
	
	public void addUserRole(UserRole role)
	{
		this.userRole.add(role);
	}
	
	@Override
	public String toString()
	{
		String result = String.format("User[user_id=%d%n username='%s'%n email=%s%n password=%s]", 
				userId, username, email, password);
		
		if(userRole != null)
		{
			for(UserRole role : userRole)
			{
				result += String.format("User Role[role_id=%d, role_name='%s']%n", 
						role.getRole().getRoleId(), role.getRole().getRoleName());
			}
		}
		return result;
	}
	
	//Getters and Setters
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "user_id", nullable = false)
	public Long getUserId()
	{
		return userId;
	}
	public void setUserId(Long userId)
	{
		this.userId = userId;
	}

	@Column(name = "username", unique = true, nullable = false, length = 45)
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}

	@Column(name = "password", nullable = false, length = 60)
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

	//Hibernate will not persist this in the database, used only for 
	//Registration Form validation
	@Transient
	public String getConfirmPassword()
	{
		return confirmPassword;
	}
	public void setConfirmPassword(String confirmPassword)
	{
		this.confirmPassword = confirmPassword;
	}
	
	@Column(name = "user_email", unique = true, nullable = false, length = 60)
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) 
	{
		this.email = email;
	}
	
	@OneToMany(mappedBy = "PK.user", cascade = CascadeType.ALL)
	public Set<UserRole> getUserRoles()
	{
		return userRole;
	}
	public void setUserRoles(Set<UserRole> userRole)
	{
		this.userRole = userRole;
	}

}
