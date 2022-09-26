package com.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dto.LoggerDto;
import com.entity.LoggerEntity;
import com.entity.UserEntity;
import com.repository.LoggerRepository;
import com.serviceInterface.LoggerServiceInterface;

@Service
public class LoggerServiceImpl implements LoggerServiceInterface{

	@Autowired
	private LoggerRepository loggerRepository;
	
	@Override
	public void createLogger(LoggerDto loggerDto, UserEntity user) {
		// TODO Auto-generated method stub
	
		LoggerEntity loggerEntity =new LoggerEntity();
		loggerEntity.setUserId(user);
		loggerEntity.setToken(loggerDto.getToken());
		loggerEntity.setExpire_At(loggerDto.getExpire_At());
		loggerRepository.save(loggerEntity);
	}

}
