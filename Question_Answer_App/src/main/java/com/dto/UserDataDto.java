package com.dto;

import org.springframework.lang.NonNull;

import com.entity.GenderEnum;

public class UserDataDto {

	@NonNull
	private String username;
	@NonNull
	private String email;
	@NonNull
	private GenderEnum gender;
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
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
	public UserDataDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	public UserDataDto(String username, String email, GenderEnum gender) {
		super();
		this.username = username;
		this.email = email;
		this.gender = gender;
	}
	
	
	
}
