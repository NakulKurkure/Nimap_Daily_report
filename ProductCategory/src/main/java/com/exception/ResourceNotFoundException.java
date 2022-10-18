package com.exception;

public class ResourceNotFoundException extends RuntimeException{

	private String message;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public ResourceNotFoundException(String message) {
		super();
		this.message = message;
	}



}
