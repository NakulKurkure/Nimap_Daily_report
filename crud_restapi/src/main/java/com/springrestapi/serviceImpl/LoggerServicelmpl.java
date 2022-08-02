package com.springrestapi.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.springrestapi.dto.LoggerDto;
import com.springrestapi.entity.LoggerEntity;
import com.springrestapi.entity.User;
import com.springrestapi.repo.LoggerRepo;
import com.springrestapi.repo.UserRepo;
import com.springrestapi.service.LoggerServiceInterface;


@Service
public class LoggerServicelmpl implements LoggerServiceInterface{

	@Autowired
	private LoggerRepo loggerRepo;
	
	@Override
	public void createLogger(LoggerDto loggerDto, User user) {
		
		
			LoggerEntity logger = new LoggerEntity();
			logger.setUserId(user);
			logger.setToken(loggerDto.getToken());
			logger.setExpireAt(loggerDto.getExpireAt());
			loggerRepo.save(logger);

		
	
	}

}
