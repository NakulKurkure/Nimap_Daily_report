package com.springrestapi.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value=HttpStatus.NOT_FOUND)
public class EmptyResultDataAccessException extends Exception {

	private static final long serialVersionUID=1L;
	
	
	
	public EmptyResultDataAccessException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}


	

	
	
}
