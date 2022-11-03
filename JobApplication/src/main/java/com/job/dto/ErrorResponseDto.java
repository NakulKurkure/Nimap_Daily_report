package com.job.dto;

public class ErrorResponseDto {

	private String message;
	
	private String msgKey;

	public String getMessage() {
		return message;
	}

	public ErrorResponseDto(String message, String msgKey) {
		super();
		this.message = message;
		this.msgKey = msgKey;
	}

	public ErrorResponseDto() {
		super();
		// TODO Auto-generated constructor stub
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
	
	
	
}
