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
	@AssociationOverride(name = "primaryKey.user",
		joinColumns = @JoinColumn(name = "user_id")),
	@AssociationOverride(name = "primaryKey.role",
		joinColumns = @JoinColumn(name = "role_id")) })
public class UserRole implements Serializable {
	
	private static final long serialVersionUID = -8830721051442680107L;

	//composite-id key
	@EmbeddedId
	private UserRoleId primaryKey = new UserRoleId();

	//additional fields
	private Date createdDate;
	
	public UserRoleId getPrimaryKey()
	{
		return primaryKey;
	}
	public void setPrimaryKey(UserRoleId primaryKey)
	{
		this.primaryKey = primaryKey;
	}
	
	@Transient
	public User getUser()
	{
		return this.getPrimaryKey().getUser();
	}
	public void setUser(User user)
	{
		this.getPrimaryKey().setUser(user);
	}
	
	@Transient
	public Role getRole()
	{
		return this.getPrimaryKey().getRole();
	}
	public void setRole(Role role)
	{
		this.getPrimaryKey().setRole(role);
	}

	@Column(name = "created_date")
	@Temporal(TemporalType.DATE)
 	public Date getCreatedDate()
	{
		return createdDate;
	}
	public void setCreatedDate(Date createdDate)
	{
		this.createdDate = createdDate;
	}
	
	public static long getSerialVersionUid() {
		return serialVersionUID;
	}
	
	@Override
	public boolean equals(Object obj)
	{
		if(this == obj)
			return true;
		
		if(obj == null || this.getClass() != obj.getClass())
			return false;
		
		UserRole that = (UserRole) obj;
		
		if(this.getPrimaryKey() != null ? !this.getPrimaryKey().equals(that.getPrimaryKey())
			: that.getPrimaryKey() != null)
				return false;
		
		return true;
	}
	
	@Override
	public int hashCode()
	{
		return(this.getPrimaryKey() != null ? this.getPrimaryKey().hashCode() : 0);
	}

}
