package com.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.springframework.lang.NonNull;

import com.entity.GenderEnum;

public class UserDto {

	@NotNull(message = "email Name is Required.")
	@NotBlank(message = "email Name is Required.")
	@NotEmpty(message="email Name is Required.")
	private String email;
	

	@NotNull(message = "UserName is Required.")
	@NotBlank(message = "UserName is Required.")
	@NotEmpty(message="UserName is Required.")
	private String username;
	
	@NonNull
	private GenderEnum gender;
	
	public UserDto(String email, String username, GenderEnum gender, String password) {
		super();
		this.email = email;
		this.username = username;
		this.gender = gender;
		this.password = password;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}


	@NotNull(message = "Password is Required.")
	@NotBlank(message = "Password is Required.")
	@NotEmpty(message="password is Required.")
	private String password;
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getUsername() {
		return username;
	}
	public UserDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public GenderEnum getGender() {
		return gender;
	}
	public void setGender(GenderEnum gender) {
		this.gender = gender;
	}
}
