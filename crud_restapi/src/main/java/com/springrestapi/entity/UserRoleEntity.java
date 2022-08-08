package com.springrestapi.entity;

import javax.persistence.AssociationOverride;
import javax.persistence.AssociationOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

import javax.persistence.JoinColumn;
import javax.persistence.Table;


@Entity
@Table(name="user_role")
@AssociationOverrides({@AssociationOverride(name="pk.users",joinColumns = @JoinColumn(name="user_id")),@AssociationOverride(name="pk.roles",joinColumns = @JoinColumn(name="role_id"))})
public class UserRoleEntity {

	@EmbeddedId
	private UserRoleId pk=new UserRoleId();
	
	public UserRoleEntity(UserRoleId pk) {
		super();
		this.pk = pk;
	}

	
	public UserRoleId getPk() {
		return pk;
	}



	public void setPk(UserRoleId pk) {
		this.pk = pk;
	}



	public UserRoleEntity() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	
	
}

