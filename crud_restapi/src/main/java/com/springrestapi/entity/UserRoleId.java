package com.springrestapi.entity;

public class UserRoleId {

	private User user;
	
	public UserRoleId() {
		super();
		// TODO Auto-generated constructor stub
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public RoleEntity getRoleEntity() {
		return roleEntity;
	}

	public void setRoleEntity(RoleEntity roleEntity) {
		this.roleEntity = roleEntity;
	}

	public UserRoleId(User user, RoleEntity roleEntity) {
		super();
		this.user = user;
		this.roleEntity = roleEntity;
	}

	private RoleEntity roleEntity;
	
	
	
}
