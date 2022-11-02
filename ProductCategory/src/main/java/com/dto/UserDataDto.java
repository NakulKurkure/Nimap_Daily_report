package com.dto;

import java.util.ArrayList;

import com.entity.GenderEnum;

public class UserDataDto {

	public UserDataDto() {
		super();
	}

	private String email;
	
	private GenderEnum gender;
	
//	private ArrayList<Long>
	
	public UserDataDto(String email, GenderEnum gender, String userName) {
		super();
		this.email = email;
		this.gender = gender;
		this.userName = userName;
	}

	private String userName;

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

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}
}
