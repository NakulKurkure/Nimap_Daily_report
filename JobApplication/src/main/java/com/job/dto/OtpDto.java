package com.job.dto;

import java.util.Date;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class OtpDto {

	@NotBlank(message = "email is Required*emailRequired")
	@NotEmpty(message = "email is Required*emailRequired")
	@NotNull(message = "email is Required*emailRequired")
	private String email;
	
	public OtpDto(String email, Long otp, Date setExpiry) {
		super();
		this.email = email;
		this.otp = otp;
		this.setExpiry = setExpiry;
	}

	public OtpDto() {
		super();	
	}

	@NotBlank(message = "email is Required*emailRequired")
	@NotEmpty(message = "email is Required*emailRequired")
	@NotNull(message = "email is Required*emailRequired")
	private Long otp;
	
	private Date setExpiry;

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Long getOtp() {
		return otp;
	}

	public void setOtp(Long otp) {
		this.otp = otp;
	}

	public Date getSetExpiry() {
		return setExpiry;
	}

	public void setSetExpiry(Date setExpiry) {
		this.setExpiry = setExpiry;
	}
	
	
	
}
