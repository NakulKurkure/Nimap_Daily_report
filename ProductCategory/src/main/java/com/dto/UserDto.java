package com.dto;

import com.entity.GenderEnum;

public class UserDto {


	public UserDto(String userName, String email, String password, GenderEnum gender) {
		super();
		this.userName = userName;
		this.email = email;
		this.password = password;
		this.gender = gender;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	private String userName;
	
	public String getUserName() {
		return userName;
	}

	public UserDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}



	public GenderEnum getGender() {
		return gender;
	}

	public void setGender(GenderEnum gender) {
		this.gender = gender;
	}

	private String email;
	
	private String password;
	
	private GenderEnum gender;
	
}
