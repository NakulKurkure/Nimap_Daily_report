package com.springrestapi.payload;

import java.io.Serializable;

public class JwtAuthResponse{


	private String token;

	public String getToken() {
		return token;
	}

	

	public void setToken(String token) {
		this.token = token;
	}

	public JwtAuthResponse(String token) {
		super();
		this.token = token;
	}

	public JwtAuthResponse() {
		super();
		// TODO Auto-generated constructor stub
	}
}
