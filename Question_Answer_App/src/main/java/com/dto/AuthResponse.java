package com.dto;

public class AuthResponse {

	private String token;

	public AuthResponse(String token) {
		super();
		this.token = token;
	}

	public String getToken() {
		return token;
	}

	public AuthResponse() {
		super();
		// TODO Auto-generated constructor stub
	}

	public void setToken(String token) {
		this.token = token;
	}
	
}
