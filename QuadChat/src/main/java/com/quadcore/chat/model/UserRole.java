package com.quadcore.chat.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.AssociationOverride;
import javax.persistence.AssociationOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

@Entity
@Table(name = "User_Roles")
@AssociationOverrides({
	@AssociationOverride(name = "PK.user",
		joinColumns = @JoinColumn(name = "user_id")),
	@AssociationOverride(name = "PK.role",
		joinColumns = @JoinColumn(name = "role_id"))
})
public class UserRole implements Serializable {

	//Private Fields
	private static final long serialVersionUID = -8830721051442680107L;

	//composite-id PK
	private UserRoleId PK = new UserRoleId();
	
	//Getters and Setters
	@EmbeddedId
	public UserRoleId getPK()
	{
		return PK;
	}
	public void setPK(UserRoleId PK)
	{
		this.PK = PK;
	}
	
	@Transient
	public User getUser()
	{
		return this.getPK().getUser();
	}
	public void setUser(User user)
	{
		this.getPK().setUser(user);
	}
	
	@Transient
	public Role getRole()
	{
		return this.getPK().getRole();
	}
	public void setRole(Role role)
	{
		this.getPK().setRole(role);
	}
	
	public static long getSerialVersionUid() {
		return serialVersionUID;
	}
}
