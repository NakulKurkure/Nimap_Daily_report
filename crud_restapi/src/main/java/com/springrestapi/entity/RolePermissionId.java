package com.springrestapi.entity;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.ManyToOne;

//import org.hibernate.annotations.ManyToAny;
//object to JSON
@Embeddable
public class RolePermissionId implements Serializable{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@ManyToOne
	private RoleEntity roles;
	
	@ManyToOne
	private PermissionEntity permission;

	public RoleEntity getRoles() {
		return roles;
	}

	public void setRoles(RoleEntity roles) {
		this.roles = roles;
	}

	public PermissionEntity getPermission() {
		return permission;
	}

	public void setPermission(PermissionEntity permission) {
		this.permission = permission;
	}

	public RolePermissionId(RoleEntity roles, PermissionEntity permission) {
		super();
		this.roles = roles;
		this.permission = permission;
	}

	public RolePermissionId() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

}
