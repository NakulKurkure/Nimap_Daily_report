package com.dto;
//First, for accessing the variables outside a class without getters/setters, we have to mark those as public,
public class SuccessDto {

	private String message;
	
	private String messageKey;
	
	

	
	public String getMessage() {
		return message;
	}

	public SuccessDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public SuccessDto(String message, String messageKey) {
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
