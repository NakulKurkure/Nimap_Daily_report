package com.job.dto;

public class RolePermissionRequestDto {
	private Long roleId;
	private Long permissionId;
	public Long getRoleId() {
		return roleId;
	}
	public RolePermissionRequestDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	public void setRoleId(Long roleId) {
		this.roleId = roleId;
	}
	public Long getPermissionId() {
		return permissionId;
	}
	public RolePermissionRequestDto(Long roleId, Long permissionId) {
		super();
		this.roleId = roleId;
		this.permissionId = permissionId;
	}
	public void setPermissionId(Long permissionId) {
		this.permissionId = permissionId;
	}
}
