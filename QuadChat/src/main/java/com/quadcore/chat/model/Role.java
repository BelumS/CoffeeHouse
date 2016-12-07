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

//Models a User's Role information
@Entity
@Table(name = "Roles")
public class Role implements Serializable {
	
	private static final long serialVersionUID = -8241375639038479386L;
	private Long roleId;
	private String roleName;	
	private Set<UserRole> userRoles = new HashSet<UserRole>();

	//Public methods
	public Role(){}
	public Role(String roleName){
		this.roleName = roleName;
	}
	public Role(String roleName, Set<UserRole> userRoles)
	{
		this.roleName = roleName;
		this.userRoles = userRoles;
	}
	
	//Getters and Setters
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "role_id")
	public Long getRoleId(){
		return this.roleId;
	}
	public void setRoleId(Long roleId){
		this.roleId = roleId;
	}
	
	@Column(name = "role_name", nullable = false, length = 45)
	public String getRoleName(){
		return this.roleName;
	}
	public void setRoleName(String roleName){
		this.roleName = roleName;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "primaryKey.user")
	public Set<UserRole> getUserRoles()
	{
		return this.userRoles;
	}
	public void setUserRoles(Set<UserRole> userRoles)
	{
		this.userRoles = userRoles;
	}
	
	public static long getSerialVersionUid() {
		return serialVersionUID;
	}
}
