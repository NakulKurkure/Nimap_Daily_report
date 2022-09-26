package com.serviceInterface;

import com.dto.LoggerDto;
import com.entity.UserEntity;

public interface LoggerServiceInterface {

	void createLogger(LoggerDto loggerDto, UserEntity user);

	
}
