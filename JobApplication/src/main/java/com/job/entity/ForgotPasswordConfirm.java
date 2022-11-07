package com.job.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class ForgotPasswordConfirm {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="email")
	private String email;
	
	public Long getId() {
		return id;
	}

	public ForgotPasswordConfirm() {
		super();
		
	}

	public void setId(Long id) {
		this.id = id;
	}

	public ForgotPasswordConfirm(Long id, String email, Long otp, String password, String confirmPassword) {
		super();
		this.id = id;
		this.email = email;
		this.otp = otp;
		this.password = password;
		this.confirmPassword = confirmPassword;
	}

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

	@Column(name="otp")
	private Long otp;
	
	@Column(name="password")
	private String password;
	
	@Column(name="confirm_password")
	private String confirmPassword;
	
	
	
	
}
