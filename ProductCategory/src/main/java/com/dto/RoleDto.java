package com.dto;

public class RoleDto {

	private String roleName;
	
	private String description;

	public String getRoleName() {
		return roleName;
	}

	public RoleDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public String getDescription() {
		return description;
	}

	public RoleDto(String roleName, String description) {
		super();
		this.roleName = roleName;
		this.description = description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
}
