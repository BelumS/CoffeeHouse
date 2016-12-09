package com.quadcore.chat.model;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

//Models a User's information
@Entity
@Table(name = "Users")
public class User implements Serializable {

	private static final long serialVersionUID = -1224394021146256127L;
	
	private Long userId;
	private String username;
	private String email;
	private String password;
	private String passwordConfirm;
	private boolean enabled = true;
	private Date createdDate;
	private Set<UserRole> userRoles = new HashSet<UserRole>(0);

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
	public User(String username, String email, String password, boolean enabled, Set<UserRole> userRoles)
	{
		this.username = username;
		this.email = email;
		this.password = password;
		this.enabled = enabled;
		this.userRoles = userRoles;
	}
	
	//Getters and Setters
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
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
	public String getUsername()
	{
		return username;
	}
	public void setUsername(String username)
	{
		this.username = username;
	}
	
	@Column(name = "user_email", unique = true, nullable = false, length = 50)
 	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	@Column(name = "user_password", nullable = false, length = 60)
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	@Transient
	public String getPasswordConfirm() {
		return passwordConfirm;
	}
	public void setPasswordConfirm(String passwordConfirm) {
		this.passwordConfirm = passwordConfirm;
	}
	
	@Column(name = "user_enabled", nullable = false)
	public boolean isEnabled() {
		return enabled;
	}
	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}
	
	@Temporal(TemporalType.DATE)
	@Column(name = "user_created_date", nullable = false)
	public Date getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "user", cascade=CascadeType.ALL)
	public Set<UserRole> getUserRoles() {
		return userRoles;
	}
	public void setUserRoles(Set<UserRole> userRoles) {
		this.userRoles = userRoles;
	}
	
	public static long getSerialVersionUid() {
		return serialVersionUID;
	}
	
	/*@Override
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
	}*/

}
