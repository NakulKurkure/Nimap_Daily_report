package com.springrestapi.exception;

public class UserNotFoundException {

	private String message;
	


	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public UserNotFoundException(String message) {
		super();
		this.message = message;
	}

	public UserNotFoundException() {
		super();
		// TODO Auto-generated constructor stub
	}

	
}
