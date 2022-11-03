package com.job.dto;

public class SuccessResponseDto {

	private String message;
	
	private String msgKey;
	
	

	

	public String getMessage() {
		return message;
	}

	public SuccessResponseDto(String message, String msgKey) {
		super();
		this.message = message;
		this.msgKey = msgKey;
		
	}

	public SuccessResponseDto() {
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
