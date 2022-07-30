package com.springrestapi.payload;


public class JwtAuthRequest {

	//Consider Email as a Username
	private String userName;
	private String password;
	public String getUsername() {
		return userName;
	}
	public JwtAuthRequest(String username, String password) {
		super();
		this.userName = username;
		this.password = password;
	}
	public void setUsername(String username) {
		this.userName = username;
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
