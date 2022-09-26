package com.dto;

public class UserRoleRequestDto {

	private Long userId;
	
	private Long roleId;

	public UserRoleRequestDto(Long userId, Long roleId) {
		super();
		this.userId = userId;
		this.roleId = roleId;
	}

	public Long getUserId() {
		return userId;
	}

	public UserRoleRequestDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public Long getRoleId() {
		return roleId;
	}

	public void setRoleId(Long roleId) {
		this.roleId = roleId;
	}
}
