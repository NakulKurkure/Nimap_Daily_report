package com.job.dto;

public class AuthResponseDto {

	private String token;

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public AuthResponseDto() {
		super();
		
	}

	public AuthResponseDto(String token) {
		super();
		this.token = token;
	}
}
