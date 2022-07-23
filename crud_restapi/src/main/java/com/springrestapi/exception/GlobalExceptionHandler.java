package com.springrestapi.exception;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class GlobalExceptionHandler {

	
	//handle specific Exception
	@ExceptionHandler(ResourseNotFoundException.class)
	public ResponseEntity<?> handleResourseNotFoundException(ResourseNotFoundException exception,WebRequest request)
	{
		Errordetails errordetail=new Errordetails(new Date(),exception.getMessage(),request.getDescription(false));
		return new ResponseEntity<> (errordetail,HttpStatus.NOT_FOUND);
		
	}
	//handle Global exception
}
