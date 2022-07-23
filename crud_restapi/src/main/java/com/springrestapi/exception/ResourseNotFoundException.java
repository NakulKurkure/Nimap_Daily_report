package com.springrestapi.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value=HttpStatus.NOT_FOUND)
public class ResourseNotFoundException extends RuntimeException{

	private static final long serialVersionUID=1L;
	
	public ResourseNotFoundException(String message) {
		// TODO Auto-generated method stub
		
		super(message);
	}

}
