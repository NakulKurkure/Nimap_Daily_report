package com.dto;

public class AuthResponseDto {

	private String message;
	private String msgKey;
	public String getMessage() {
		return message;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

	public AuthResponseDto(String message, String msgKey, Object data) {
		super();
		this.message = message;
		this.msgKey = msgKey;
		this.data = data;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getMsgKey() {
		return msgKey;
	}

	public void setMsgKey(String msgKey) {
		this.msgKey = msgKey;
	}

	private Object data;

	public AuthResponseDto() {
		super();
		// TODO Auto-generated constructor stub
	}


	
	
}
