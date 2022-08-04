package com.springrestapi.payload;


public class JwtAuthRequest {

	//Consider Email as a Username
	private String username;
	private String password;
	public String getUsername() {
		return username;
	}
	public JwtAuthRequest(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public JwtAuthRequest() {
		super();
		// TODO Auto-generated constructor stub
	}

}
