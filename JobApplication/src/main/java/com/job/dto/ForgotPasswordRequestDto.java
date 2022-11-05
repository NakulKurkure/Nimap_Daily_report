package com.job.dto;

public class ForgotPasswordRequestDto {

	private String email;

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public ForgotPasswordRequestDto(String email) {
		super();
		this.email = email;
	}

	public ForgotPasswordRequestDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
