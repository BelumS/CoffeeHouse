package com.quadcore.chat.model;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

//Models a User's Role information
@Entity
@Table(name = "Role")
public class Role {
	
	private Long roleId;
	private String roleName;
	private Set<User> users;

	//Public methods
	public Role(){}
	public Role(Long roleId, String roleName){
		this.roleId = roleId;
		this.roleName = roleName;
	}
	public Role(Long roleId, String roleName, Set<User> users){
		this.roleId = roleId;
		this.roleName = roleName;
		this.users = users;
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
	
	@Column(name = "role_name", nullable = false)
	public String getRoleName(){
		return this.roleName;
	}
	public void setRoleName(String roleName){
		this.roleName = roleName;
	}

	@ManyToMany(mappedBy = "userRoles")
	public Set<User> getUsers()
	{
		return this.users;
	}
	public void setUsers(Set<User> users)
	{
		this.users = users;
	}
}
