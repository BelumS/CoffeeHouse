package com.quadcore.chat.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "User_Roles")
public class UserRole implements Serializable {
	
	private static final long serialVersionUID = -8830721051442680107L;
	private Long userRoleId;
	private User user;
	private String userRoleName;
	
	public UserRole(){}
	public UserRole(User user, String userRoleName)
	{
		this.user = user;
		this.userRoleName = userRoleName;
	}
	
	//getters and setters
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "user_role_id", nullable = false)
	public Long getUserRoleId() {
		return userRoleId;
	}
	public void setUserRoleId(Long userRoleId) {
		this.userRoleId = userRoleId;
	}
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_id", nullable = false)
	public User getUser() {
		return this.user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	
	@Column(name = "user_role_name", nullable = false, length = 45)
	public String getUserRoleName() {
		return userRoleName;
	}
	public void setUserRoleName(String userRoleName) {
		this.userRoleName = userRoleName;
	}

	public static long getSerialVersionUid() {
		return serialVersionUID;
	}
}
