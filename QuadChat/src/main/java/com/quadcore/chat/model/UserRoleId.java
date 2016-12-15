package com.quadcore.chat.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Embeddable;
import javax.persistence.ManyToOne;

/**
 * Represents the composite PK from the "User_Roles" table
 * <p>
 * @author Quadcore
 * @since 12/6/16
 * @version 1.0
 * @category Spring MVC - Model
 * @category Hibernate/JPA - Entity
 * @see src/main/resources/coffeehouse-schema.sql
 *
 */
@Embeddable
public class UserRoleId implements Serializable{

	private static final long serialVersionUID = -4409807141795397405L;
	//Private Fields
	private User user;
	private Role role;

	//Getters and Setters
	@ManyToOne(cascade = CascadeType.ALL)
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}

	@ManyToOne(cascade = CascadeType.ALL)
	public Role getRole() {
		return role;
	}
	public void setRole(Role role) {
		this.role = role;
	}

	public static long getSerialVersionUid() {
		return serialVersionUID;
	}
}

