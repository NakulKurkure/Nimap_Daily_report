package com.springrestapi.entity;

import javax.persistence.AssociationOverride;
import javax.persistence.AssociationOverrides;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.Table;

@Entity
@Table(name="user_role")
@AssociationOverrides({@AssociationOverride(name="pk_user",joinColumns = @JoinColumn(name="user_id")),@AssociationOverride(name="pk_role",joinColumns = @JoinColumn(name="role_id"))})
public class UserRoleEntity {

	UserRoleId userRoleId=new UserRoleId();
	
	public UserRoleEntity(boolean isActive) {
		super();
		this.isActive = isActive;
	}

	private boolean isActive=true;

	public boolean isActive() {
		return isActive;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}

	public UserRoleEntity() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
}

