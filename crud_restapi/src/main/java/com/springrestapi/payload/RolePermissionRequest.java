package com.springrestapi.payload;

public class RolePermissionRequest {

	
	private int roleId;
	private int permissionId;
	public int getRoleId() {
		return roleId;
	}
	public RolePermissionRequest(int roleId, int permissionId) {
		super();
		this.roleId = roleId;
		this.permissionId = permissionId;
	}
	public RolePermissionRequest() {
		super();
		// TODO Auto-generated constructor stub
	}
	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}
	public int getPermissionId() {
		return permissionId;
	}
	public void setPermissionId(int permissionId) {
		this.permissionId = permissionId;
	}
	
	
}
