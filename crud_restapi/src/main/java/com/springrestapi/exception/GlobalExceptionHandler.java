package com.springrestapi.exception;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

@RestControllerAdvice
public class GlobalExceptionHandler {

	
	//handle specific Exception//classes and/orhandler methods
	@ExceptionHandler(ResourseNotFoundException.class)
	public ResponseEntity<?> handleResourseNotFoundException(ResourseNotFoundException exception,WebRequest request)
	{
		Errordetails errordetail=new Errordetails(new Date(),exception.getMessage(),request.getDescription(false));
		return new ResponseEntity<> (errordetail,HttpStatus.NOT_FOUND);

	}

	
	//delete
	@ExceptionHandler(EmptyResultDataAccessException.class)
	public ResponseEntity<?> handleEmptyResultDataAccessException(EmptyResultDataAccessException exception,WebRequest request)
	{
		Errordetails errordetail=new Errordetails(new Date(),exception.getMessage(),request.getDescription(false));
		return new ResponseEntity<> (errordetail,HttpStatus.NOT_FOUND);

	}

	@ExceptionHandler(HttpRequestMethodNotSupportedException.class)
	public ResponseEntity<?> handleHttpRequestMethodNotSupportedException(HttpRequestMethodNotSupportedException exception,WebRequest request)
	{
		Errordetails errordetail=new Errordetails(new Date(),exception.getMessage(),request.getDescription(false));
		return new ResponseEntity<> (errordetail,HttpStatus.NOT_FOUND);

	}


	//PUT (localhost:8080/entity/4055555)
	@ExceptionHandler(HttpMessageNotReadableException.class)
	public ResponseEntity<?> handleHttpMessageNotReadableException(HttpMessageNotReadableException exception,WebRequest request)
	{
		Errordetails errordetail=new Errordetails(new Date(),exception.getMessage(),request.getDescription(false));
		return new ResponseEntity<> (errordetail,HttpStatus.NOT_FOUND);

	}


}
