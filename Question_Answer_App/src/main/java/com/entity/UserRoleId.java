package com.entity;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.ManyToOne;

@Embeddable
public class UserRoleId implements Serializable{

	private static final long serialVersionUID = 1L;

	@ManyToOne
	private UserEntity users;
	
	@ManyToOne
	private RoleEntity roles;

	public UserRoleId(UserEntity users, RoleEntity roles) {
		super();
		this.users = users;
		this.roles = roles;
	}

	public UserEntity getUsers() {
		return users;
	}

	public UserRoleId() {
		super();
		// TODO Auto-generated constructor stub
	}

	public void setUsers(UserEntity users) {
		this.users = users;
	}

	public RoleEntity getRoles() {
		return roles;
	}

	public void setRoles(RoleEntity roles) {
		this.roles = roles;
	}
}
