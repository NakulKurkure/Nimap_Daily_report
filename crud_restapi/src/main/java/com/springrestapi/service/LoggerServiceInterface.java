package com.springrestapi.service;

import com.springrestapi.dto.LoggerDto;
import com.springrestapi.entity.LoggerEntity;
//import com.springrestapi.entity.User;
import com.springrestapi.entity.User;


public interface LoggerServiceInterface {

	
	LoggerEntity getLoggerDetails(String token);
	
	void createLogger(LoggerDto loggerDto, User user);
	
	void logout(String token);
}
