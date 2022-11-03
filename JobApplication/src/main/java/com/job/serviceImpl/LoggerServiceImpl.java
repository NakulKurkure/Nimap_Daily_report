package com.job.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.job.entity.Logger;
import com.job.entity.User;
import com.job.repository.LoggerRepository;
import com.job.serviceInterface.LoggerServiceInterface;

@Service
public class LoggerServiceImpl implements LoggerServiceInterface{

	@Autowired
	private LoggerRepository loggerRepository;
	
	@Override
	public void createLogger(Logger logger, User user) {
		
		loggerRepository.save(logger);
		
	}

}
