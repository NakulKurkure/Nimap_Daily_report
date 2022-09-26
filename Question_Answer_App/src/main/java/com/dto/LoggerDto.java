package com.dto;

import java.util.Date;

public class LoggerDto {

	private String token;
	
	private Date expire_At;
	
	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public LoggerDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public LoggerDto(String token, Date expire_At, Long userId) {
		super();
		this.token = token;
		this.expire_At = expire_At;
		this.userId = userId;
	}

	public Date getExpire_At() {
		return expire_At;
	}

	public void setExpire_At(Date expire_At) {
		this.expire_At = expire_At;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	private Long userId;
}
