package com.job.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class ForgotPasswordDto {

	@NotNull(message = "Required")
	@NotBlank(message="Required")
	@NotEmpty(message="Required")
	private String email;
	
	private Long otp;
	
	@NotNull(message = "Required")
	@NotBlank(message="Required")
	@NotEmpty(message="Required")
	private String password;
	
	public ForgotPasswordDto() {
		super();
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public ForgotPasswordDto(String email, Long otp, String password, String confirmPassword) {
		super();
		this.email = email;
		this.otp = otp;
		this.password = password;
		this.confirmPassword = confirmPassword;
	}

	public Long getOtp() {
		return otp;
	}

	public void setOtp(Long otp) {
		this.otp = otp;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getConfirmPassword() {
		return confirmPassword;
	}

	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}

	private String confirmPassword;
	
	
}
