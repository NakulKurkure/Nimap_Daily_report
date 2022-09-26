package com.dto;

public class AuthResponseDto {

	private String message;
	private String msgKey;
	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public AuthResponseDto(String message, String msgKey, Object token) {
		super();
		this.message = message;
		this.msgKey = msgKey;
		this.token = token;
	}

	public String getMsgKey() {
		return msgKey;
	}

	public void setMsgKey(String msgKey) {
		this.msgKey = msgKey;
	}

	private Object token;

	public AuthResponseDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public AuthResponseDto(Object token) {
		super();
		this.token = token;
	}

	public Object getToken() {
		return token;
	}

	public void setToken(Object token) {
		this.token = token;
	}

	
	
}
