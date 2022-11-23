package com.job.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class RoleDto {

	@NotNull(message = "Required")
	@NotBlank(message="Required")
	@NotEmpty(message="Required")
	private String roleName;
	
	@NotNull(message = "Required")
	@NotBlank(message="Required")
	@NotEmpty(message="Required")
	private String description;

	public String getRoleName() {
		return roleName;
	}

	public RoleDto(String roleName, String description) {
		super();
		this.roleName = roleName;
		this.description = description;
	}

	public RoleDto() {
		super();
		
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


	
	
	
}

