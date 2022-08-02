package com.springrestapi.dto;

import java.util.Date;

public class LoggerDto {

	private String token;
	
	private int userId;
	
	private Date expireAt;

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public Date getExpireAt() {
		return expireAt;
	}

	public void setExpireAt(Date expireAt) {
		this.expireAt = expireAt;
	}

	public LoggerDto(String token, int userId, Date expireAt) {
		super();
		this.token = token;
		this.userId = userId;
		this.expireAt = expireAt;
	}

	public LoggerDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
