package com.job.serviceImpl;

import java.util.Calendar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.job.dto.ForgotPasswordRequestDto;
import com.job.dto.OtpDto;
import com.job.entity.OtpEntity;
import com.job.entity.User;
import com.job.exception.ResourceNotFoundException;
import com.job.repository.OtpRepository;
import com.job.repository.UserRepository;
import com.job.serviceInterface.OtpInterface;


@Service
public class OtpServiceImpl implements OtpInterface{

	@Autowired
	private OtpRepository otpRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	
	
	
	public OtpEntity saveOtp(ForgotPasswordRequestDto otpDto, User user1,OtpEntity entities) throws Exception {
			
			this.otpRepository.save(entities);
			return entities;

	}



	}



