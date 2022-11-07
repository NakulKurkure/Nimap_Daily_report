package com.job.dto;

public class ForgotPasswordDto {

	private String email;
	
	private Long otp;
	
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
