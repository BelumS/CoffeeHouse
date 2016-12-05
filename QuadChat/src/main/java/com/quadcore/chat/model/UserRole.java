/*package com.quadcore.chat.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "User_Roles")
public class UserRole {
	
	private Long user_id;
	private Long role_id;
	
	public UserRole(){
	}
	
	public UserRole(Long user_id, Long role_id){
		this.user_id = user_id;
		this.role_id = role_id;
	}
	
	@ManyToOne(fetch = FetchType.LAZY)
	@Column(name = "user_id", unique = true, nullable = false)
	public Long getUserId(){
		return this.user_id;
	}
	public void setUserId(Long user_id){
		this.user_id = user_id;
	}
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "role_id", nullable = false)
	public Long getRoleId(){
		return this.role_id;
	}
	public void setRoleId(Long role_id){
		this.role_id = role_id;
	}
	
	

}
*/