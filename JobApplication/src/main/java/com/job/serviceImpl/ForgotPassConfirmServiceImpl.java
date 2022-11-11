package com.job.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.config.annotation.authentication.configurers.ldap.LdapAuthenticationProviderConfigurer.PasswordCompareConfigurer;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.job.dto.ErrorResponseDto;
import com.job.dto.ForgotPasswordDto;
import com.job.entity.ForgotPasswordConfirm;
import com.job.entity.OtpEntity;
import com.job.exception.ResourceNotFoundException;
import com.job.repository.ForgotPassConfRepository;
import com.job.repository.OtpRepository;
import com.job.serviceInterface.ForgotPassConfirmInterface;

@Service
public class ForgotPassConfirmServiceImpl implements ForgotPassConfirmInterface{

	@Autowired
	private ForgotPassConfRepository forgotPassConfRepository;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Autowired
	private OtpRepository otpRepository;
	
	public void forgotPasswordConfirm(ForgotPasswordDto forgotPasswordDto) {
			
		System.out.println("In theOtp"+otpRepository.findByEmailContainingIgnoreCase(forgotPasswordDto.getEmail()));
		List<OtpEntity> otpEntity= this.otpRepository.findByEmailContainingIgnoreCase(forgotPasswordDto.getEmail());
		 System.out.println("Otp");
		OtpEntity otp= otpRepository.findByOtp(forgotPasswordDto.getOtp()).orElseThrow(()-> new ResourceNotFoundException("Enter Valid OTP.. "));
		System.out.println("OtpEntity"+otp);
		
		ForgotPasswordConfirm forgotPasswordConfirm=new ForgotPasswordConfirm();
		
		forgotPasswordConfirm.setEmail(forgotPasswordDto.getEmail());
		
		if(otp.getOtp().equals(forgotPasswordDto.getOtp()))
		{
			forgotPasswordConfirm.setOtp(otp.getOtp());
			
			if(forgotPasswordDto.getPassword().equals(forgotPasswordDto.getConfirmPassword()))
			{

				forgotPasswordConfirm.setPassword(passwordEncoder.encode(forgotPasswordDto.getPassword()));
				forgotPasswordConfirm.setConfirmPassword(passwordEncoder.encode(forgotPasswordDto.getConfirmPassword()));	
				forgotPassConfRepository.save(forgotPasswordConfirm);
			}
			
			else
			{
				throw new ResourceNotFoundException("Not Matching Password and Confirm Password");
				
			}
				
				}else
				{
				
				throw new ResourceNotFoundException("Not Matching Password and Confirm Password");

				}
		
		
		
		}

}
