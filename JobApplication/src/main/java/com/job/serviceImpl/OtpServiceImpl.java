package com.job.serviceImpl;

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
	
	
	
	public OtpEntity saveOtp(ForgotPasswordRequestDto otpDto, User user, OtpEntity entities) throws Exception {

		try
		{
		com.job.entity.OtpEntity otpentity = this.otpRepository.findByEmailContainingIgnoreCase(otpDto.getEmail());
System.out.println("OTP"+otpentity);
		if (otpentity != null) {

			throw new ResourceNotFoundException("Something went wrong");
		}

		else {
			
			this.otpRepository.save(entities);
			return entities;
		}
	} catch (Exception e) {

		throw new Exception("Something went wrong !!!!");
	}

	}
//
//
//
//	public OtpEntity saveOtp(ForgotPasswordRequestDto otpDto, User user, OtpEntity entities) {
//		// TODO Auto-generated method stub
//		
//		
//		return entities;
//	}


}
