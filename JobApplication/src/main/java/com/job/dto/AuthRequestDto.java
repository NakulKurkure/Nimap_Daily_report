package com.job.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class AuthRequestDto {

	@NotNull(message = "Required")
	@NotBlank(message="Required")
	@NotEmpty(message="Required")
	private String email;
	
	@NotNull(message = "Required")
	@NotBlank(message="Required")
	@NotEmpty(message="Required")
	private String password;

	public AuthRequestDto() {
		super();
		
	}

	public String getEmail() {
		return email;
	}

	public AuthRequestDto(String email, String password) {
		super();
		this.email = email;
		this.password = password;
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
	
}
