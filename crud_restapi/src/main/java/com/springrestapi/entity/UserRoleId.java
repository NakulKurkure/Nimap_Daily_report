package com.springrestapi.entity;

import java.io.Serializable;
import java.util.Optional;

import javax.persistence.Embeddable;
import javax.persistence.ManyToOne;

@Embeddable
public class UserRoleId implements Serializable{

	

	public User getUsers() {
		return users;
	}

	public UserRoleId(User userId, RoleEntity roleEntityId) {
		super();
		this.users = userId;
		this.roles = roleEntityId;
	}

	public void setUsers(User users) {
		this.users = users;
	}

	public RoleEntity getRoles() {
		return roles;
	}

	public void setRoles(RoleEntity roles) {
		this.roles = roles;
	}

	private static final long serialVersionUID = 1L;

	@ManyToOne
	private User users;
	
	public UserRoleId() {
		super();
		// TODO Auto-generated constructor stub
	}

	@ManyToOne
	private RoleEntity roles;
	
	

	
	
	
}
