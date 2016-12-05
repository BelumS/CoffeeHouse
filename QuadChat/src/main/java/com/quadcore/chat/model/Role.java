/*package com.quadcore.chat.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

//Models a User's information
@Entity
@Table(name = "Role")
public class Role {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long role_id;
	
	private String role_name;
	
	public Role(){
	}
	
	public Role(Long role_id, String role_name){
		this.role_id = role_id;
		this.role_name = role_name;
	}
	
	@Column(name = "role_id", unique = true, nullable = false)
	public Long getRole_id(){
		return this.role_id;
	}
	
	public void setRole_id(Long role_id){
		this.role_id = role_id;
	}
	
	@Column(name = "role_name", unique = false, nullable = false)
	public String getRole_name(){
		return this.role_name;
	}
	
	public void setRole_name(String role_name){
		this.role_name = role_name;
	}

}
*/