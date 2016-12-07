package com.quadcore.chat.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Embeddable;
import javax.persistence.ManyToOne;

@Embeddable
public class UserRoleId implements Serializable{
	
	private static final long serialVersionUID = -7168208525495266355L;
	private User user;
	private Role role;
	
	@ManyToOne(cascade = CascadeType.ALL)
	public User getUser()
	{
		return this.user;
	}
	public void setUser(User user)
	{
		this.user = user;
	}
	
	@ManyToOne(cascade = CascadeType.ALL)
	public Role getRole()
	{
		return this.role;
	}
	public void setRole(Role role)
	{
		this.role = role;
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
		
		UserRoleId stuff = (UserRoleId) obj;
		
		if(user != null ? !user.equals(stuff.user) : stuff.user != null)
			return false;
		
		if(role != null ? !role.equals(stuff.role) : stuff.role != null)
			return false;
		
		return true;
	}
	
	@Override
	public int hashCode()
	{
		int result;
		result = (user != null ? user.hashCode() : 0);
		result = 31 * result + (role != null ? role.hashCode() : 0);
		return result;
	}
	

}
