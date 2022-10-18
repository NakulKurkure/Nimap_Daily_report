package com.dto;

public class ErrorDetailsDto {

	private String message;
	
	public ErrorDetailsDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	private String messageKey;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public ErrorDetailsDto(String message, String messageKey) {
		super();
		this.message = message;
		this.messageKey = messageKey;
	}

	public String getMessageKey() {
		return messageKey;
	}

	public void setMessageKey(String messageKey) {
		this.messageKey = messageKey;
	}
}
