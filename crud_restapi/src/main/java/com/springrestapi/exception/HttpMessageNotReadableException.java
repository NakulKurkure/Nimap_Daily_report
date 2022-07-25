package com.springrestapi.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value=HttpStatus.NOT_FOUND)
public class HttpMessageNotReadableException extends RuntimeException{

	private static final long serialVersionUID=1L;
	public HttpMessageNotReadableException(String message) {
	super(message);
		// TODO Auto-generated constructor stub
	}

}
