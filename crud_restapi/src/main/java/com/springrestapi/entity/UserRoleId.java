package com.springrestapi.entity;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.ManyToOne;

@Embeddable
public class UserRoleId implements Serializable{

	private static final long serialVersionUID = 1L;

	@ManyToOne
	private User users;
	
	@ManyToOne
	private RoleEntity roles;
	
	
	public UserRoleId(User user, RoleEntity roles) {
		super();
		this.users = user;
		this.roles = roles;
	}


	public User getUser() {
		return users;
	}


	public void setUser(User user) {
		this.users = user;
	}


	public RoleEntity getRoleEntity() {
		return roles;
	}


	public void setRoleEntity(RoleEntity roles) {
		this.roles = roles;
	}


	public UserRoleId() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	
	
}
