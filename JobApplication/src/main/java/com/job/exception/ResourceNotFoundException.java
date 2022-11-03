package com.job.exception;

public class ResourceNotFoundException extends RuntimeException{

	private static final long serialVersionUID = 1L;
	private String message;

	public String getMessage() {
		return message;
	}

	public ResourceNotFoundException(String message) {
		super();
		this.message = message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public ResourceNotFoundException() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
