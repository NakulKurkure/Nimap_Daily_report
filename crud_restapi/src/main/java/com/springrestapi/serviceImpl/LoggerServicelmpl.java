package com.springrestapi.serviceImpl;



import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.springrestapi.dto.LoggerDto;
import com.springrestapi.entity.LoggerEntity;
import com.springrestapi.entity.User;
import com.springrestapi.repo.LoggerRepo;

import com.springrestapi.service.LoggerServiceInterface;


@Service
public class LoggerServicelmpl implements LoggerServiceInterface{

	@Autowired
	private LoggerRepo loggerRepo;
	
//	@Autowired
	private LoggerEntity loggerEntity;
	
	@Override
	public void createLogger(LoggerDto loggerDto, User user) {
		
		
			LoggerEntity logger = new LoggerEntity();
			logger.setUserId(user);
			logger.setToken(loggerDto.getToken());
			logger.setExpireAt(loggerDto.getExpireAt());
			loggerRepo.save(logger);

		
	
	}


	@Transactional
	@Override
	public void logout(String token) {
		// TODO Auto-generated method stub
		
		String userToken=token.substring(7);
		this.loggerRepo.removeByToken(userToken);
		
	}


//	@Override
	public LoggerEntity getLoggerDetails(String token) {
		
		LoggerEntity loggerEntity;
		
		loggerEntity=loggerRepo.findByToken(token);
		
		return loggerEntity;
	}

}
