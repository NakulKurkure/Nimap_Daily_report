package com.job.dto;

public class UserDataDto {

	private Long userId;
	
	public UserDataDto(Long userId, String email, String userName) {
		super();
		this.userId = userId;
		this.email = email;
		this.userName = userName;
	}

	public Long getUserId() {
		return userId;
	}

	public UserDataDto() {
		super();
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	private String email;
	
	private String userName;
	
	
}
