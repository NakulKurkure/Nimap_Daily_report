package com.job.dto;

public class RoleDataDto {

	private Long roleId;
	
	public Long getRoleId() {
		return roleId;
	}

	public void setRoleId(Long roleId) {
		this.roleId = roleId;
	}

	public RoleDataDto() {
		super();
	}

	public String getRoleName() {
		return roleName;
	}

	public RoleDataDto(Long roleId, String roleName, String description) {
		super();
		this.roleId = roleId;
		this.roleName = roleName;
		this.description = description;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	private String roleName;
	
	private String description;
}
