package com.job.entity;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.ManyToOne;

@Embeddable
public class RolePermissionId implements Serializable{
	

	private static final long serialVersionUID = 1L;

	@ManyToOne
	private Role role;

	@ManyToOne
	private Permission permission;

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public RolePermissionId(Role role, Permission permission) {
		super();
		this.role = role;
		this.permission = permission;
	}

	public RolePermissionId() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Permission getPermission() {
		return permission;
	}

	public void setPermission(Permission permission) {
		this.permission = permission;
	}

	

}
