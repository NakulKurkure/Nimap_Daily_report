package com.job.dto;

public class AuthRequestDto {

	private String email;
	
	private String password;

	public AuthRequestDto() {
		super();
		
	}

	public String getEmail() {
		return email;
	}

	public AuthRequestDto(String email, String password) {
		super();
		this.email = email;
		this.password = password;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
}
