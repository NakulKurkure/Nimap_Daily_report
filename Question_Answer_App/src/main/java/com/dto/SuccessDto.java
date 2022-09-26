package com.dto;

public class SuccessDto {

	
	public SuccessDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	private String message;
	private String msgKey;
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getMsgKey() {
		return msgKey;
	}
	public SuccessDto(String message, String msgKey) {
		super();
		this.message = message;
		this.msgKey = msgKey;
	}
	public void setMsgKey(String msgKey) {
		this.msgKey = msgKey;
	}
}
