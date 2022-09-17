package com.springrestapi.exception;

public class FileStorageException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String message;

	public FileStorageException(String message) {
		super();
		this.message = message;
	}

	public FileStorageException() {
		super();
		// TODO Auto-generated constructor stub
	}
	

}
