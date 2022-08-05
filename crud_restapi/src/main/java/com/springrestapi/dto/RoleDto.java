package com.springrestapi.dto;

public class RoleDto {

	
	private String roleName;

	public RoleDto(String roleName) {
		super();
		this.roleName = roleName;
	}

	public RoleDto() {
		super();
		
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	

}
