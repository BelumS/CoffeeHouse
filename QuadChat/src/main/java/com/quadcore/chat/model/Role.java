package com.quadcore.chat.model;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

//Models a User's Role information
@Entity
@Table(name = "Role")
public class Role implements Serializable{
	
	private static final long serialVersionUID = 5709875279990150133L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "role_id")
	private Long roleId;
	
	@Column(name = "role_name", nullable = false)
	private String roleName;
	
	@ManyToMany(mappedBy = "userRoles")
	private Set<User> users;

	/*//Public methods
	public Role(){}
	public Role(String roleName){
		this.roleName = roleName;
	}
	public Role(String roleName, Set<User> users){
		this.roleName = roleName;
		this.users = users;
	}*/
	
	//Getters and Setters
	public Long getRoleId(){
		return this.roleId;
	}
	public void setRoleId(Long roleId){
		this.roleId = roleId;
	}
	
	public String getRoleName(){
		return this.roleName;
	}
	public void setRoleName(String roleName){
		this.roleName = roleName;
	}

	public Set<User> getUsers()
	{
		return this.users;
	}
	public void setUsers(Set<User> users)
	{
		this.users = users;
	}
}
