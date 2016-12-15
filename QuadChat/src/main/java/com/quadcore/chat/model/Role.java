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

/**
 * Models the "Roles" table from the database
 * <p>
 * @author Quadcore
 * @since 11/22/16
 * @version 2.0
 * @category Spring MVC - Model
 * @category Hibernate/JPA - Entity
 * @see src/main/resources/coffeehouse-schema.sql
 *
 */
@Entity
@Table(name = "Roles")
public class Role {
	
	//Private Fields
	private Long roleId;
	private String roleName;
	private Set<UserRole> userRole = new HashSet<UserRole>();
	
	//Public methods
	public Role(){}
	public Role(String roleName)
	{
		this.roleName = roleName;
	}
	
	@Override
	public String toString()
	{
		return String.format("Role[role_id=%d%nrole_name= %s]", roleId, roleName);
	}
	
	//Getters and Setters
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "role_id", nullable = false)
	public Long getRoleId()
	{
		return roleId;
	}
	public void setRoleId(Long roleId)
	{
		this.roleId = roleId;
	}
	
	@Column(name = "role_name", nullable = false, length = 45)
	public String getRoleName()
	{
		return roleName;
	}
	public void setRoleName(String roleName)
	{
		this.roleName = roleName;
	}
	
	@OneToMany(mappedBy = "PK.role", cascade = CascadeType.ALL)
	public Set<UserRole> getUserRoles()
	{
		return userRole;
	}
	public void setUserRoles(Set<UserRole> userRole)
	{
		this.userRole = userRole;
	}
}
