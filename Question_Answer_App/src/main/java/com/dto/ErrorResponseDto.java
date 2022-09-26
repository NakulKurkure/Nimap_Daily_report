package com.dto;

public class ErrorResponseDto {

	private String message;
	private String msgkey;
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getMsgkey() {
		return msgkey;
	}
	public void setMsgkey(String msgkey) {
		this.msgkey = msgkey;
	}
	public ErrorResponseDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ErrorResponseDto(String message, String msgkey) {
		super();
		this.message = message;
		this.msgkey = msgkey;
	}
}
