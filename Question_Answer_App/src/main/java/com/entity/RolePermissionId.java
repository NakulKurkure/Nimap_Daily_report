package com.entity;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.ManyToOne;

@Embeddable
public class RolePermissionId implements Serializable{


	private static final long serialVersionUID = 1L;

	@ManyToOne
	private RoleEntity roles;
	
	@ManyToOne
	private PermissionEntity permissions;

	public RoleEntity getRoles() {
		return roles;
	}

	public RolePermissionId(RoleEntity roles, PermissionEntity permissions) {
		super();
		this.roles = roles;
		this.permissions = permissions;
	}

	public RolePermissionId() {
		super();
		// TODO Auto-generated constructor stub
	}

	public void setRoles(RoleEntity roles) {
		this.roles = roles;
	}

	public PermissionEntity getPermissions() {
		return permissions;
	}

	public void setPermissions(PermissionEntity permissions) {
		this.permissions = permissions;
	}
}
