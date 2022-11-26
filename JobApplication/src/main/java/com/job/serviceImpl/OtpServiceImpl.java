package com.job.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.job.dto.ForgotPasswordRequestDto;
import com.job.entity.OtpEntity;
import com.job.entity.User;
import com.job.repository.OtpRepository;
import com.job.serviceInterface.OtpInterface;


@Service
public class OtpServiceImpl implements OtpInterface{

	@Autowired
	private OtpRepository otpRepository;

	
	
	public OtpEntity saveOtp(ForgotPasswordRequestDto otpDto, User user1,OtpEntity entities) throws Exception {
			
			this.otpRepository.save(entities);
			return entities;

	}



	}



