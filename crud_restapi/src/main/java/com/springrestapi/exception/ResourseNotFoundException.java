package com.springrestapi.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

//Marks a method or exception class with the status code and reason that should be returned.  
@ResponseStatus(value=HttpStatus.NOT_FOUND)
//ResourseNotFoundException is custom exception 
public class ResourseNotFoundException extends RuntimeException{

	private static final long serialVersionUID=1L;
	
	public ResourseNotFoundException(String message) {
		// TODO Auto-generated method stub
		
		super(message);
	}

}
