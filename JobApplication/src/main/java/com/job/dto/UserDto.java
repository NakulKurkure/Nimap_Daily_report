package com.job.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class UserDto {
//
	@NotNull(message = "Required")
	@NotBlank(message="Required")
	@NotEmpty(message="Required")

	private String email;
	
	@NotNull(message = "Required")
	@NotBlank(message="Required")
	@NotEmpty(message="Required")
	
	private String password;
//	
	@NotNull
	@NotBlank
	@NotEmpty
	private String userName;

	public UserDto(String email, String password, String userName) {
		super();
		this.email = email;
		this.password = password;
		this.userName = userName;
	}

	public UserDto() {
		super();
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	
	
}
