package com.controller;

import java.util.Calendar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dto.AuthRequest;
import com.dto.AuthResponse;
import com.dto.AuthResponseDto;
import com.dto.ErrorResponseDto;
import com.dto.LoggerDto;
import com.dto.SuccessResponseDto;
import com.dto.UserDto;
import com.entity.LoggerEntity;
import com.entity.UserEntity;
import com.repository.AuthRepository;
import com.repository.UserRepository;
import com.security.JwtTokenUtil;
import com.security.UserDetailService;
import com.serviceInterface.AuthServiceInterface;
import com.serviceInterface.LoggerServiceInterface;
import com.serviceInterface.UserServiceInterface;
import com.util.PasswordValidation;


@RestController
@RequestMapping("/api/auth")
public class AuthController {
	@Autowired
	private UserServiceInterface userServiceInterface;
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private UserDetailService userDetailService;
	
	@Autowired
	private JwtTokenUtil jwtTokenUtil;
	
	@Autowired
	private LoggerServiceInterface loggerServiceInterface;
	
	
	@PostMapping("/register")
	public ResponseEntity<?> register(@RequestBody UserDto user)
	{
		
		
		String email=user.getEmail();
		String password=user.getPassword();
		
		if(PasswordValidation.isValidforEmail(email)&& PasswordValidation.isValid(password))
		{
		
			
			
			UserEntity userEntity=userRepository.findByEmailContainingIgnoreCase(email);
			
			
				
			if(userEntity==null) {
				
				userServiceInterface.addUser(user);
				return new ResponseEntity<>(new AuthResponseDto("SuccessFully Registered.", "Registered..","Successfully Registered..."),HttpStatus.ACCEPTED);
			}else
			{
				return new ResponseEntity<>(new ErrorResponseDto("Email Alredy Exists..", "Alredy Exists.."),HttpStatus.NOT_FOUND);
			}
			
			
		}
		
		return new ResponseEntity<>(new ErrorResponseDto("Not Valid EmailID..", "Invalid EmailID.."),HttpStatus.BAD_REQUEST);
		
	}
	
	@PostMapping("/login")
	public ResponseEntity<?> createToken(@RequestBody AuthRequest request)
	{
		
		if(PasswordValidation.isValidforEmail(request.getEmail())&& PasswordValidation.isValid(request.getPassword()))
		{
			
		try
		{
			
			System.out.println("In 2"+request.getEmail());
		UserEntity user=userRepository.findByEmailContainingIgnoreCase(request.getEmail());
		
		if(userDetailService.comparePassword(request.getPassword(), user.getPassword()))
		{
			System.out.println("In 3"+user.getPassword());
			UserEntity users=userRepository.findByEmailContainingIgnoreCase(request.getEmail());
			
			UserDetails userDetails=this.userDetailService.loadUserByUsername(request.getEmail());
			String token=jwtTokenUtil.generateToken(userDetails);
			
			
			LoggerDto loggerDto=new LoggerDto();
			loggerDto.setToken(token);
			Calendar calender=Calendar.getInstance();
			calender.add(calender.MINUTE,30);
			loggerDto.setExpire_At(calender.getTime());
			loggerServiceInterface.createLogger(loggerDto,user);

			
			
			
			AuthResponse authResponse=new AuthResponse();
			
			authResponse.setToken(token);
			
			return new ResponseEntity<>(new SuccessResponseDto("Login Successfully", "Successfully",authResponse),HttpStatus.ACCEPTED);	
		}
		else
		{
			throw new Exception("Invalid Username and password..");
		}
		}
		catch(Exception e)
		{
			return new ResponseEntity<>(new ErrorResponseDto("Invalid email or Password..", "Invalid.."),HttpStatus.NO_CONTENT);
		}
		
		}else
		{
			return new ResponseEntity<>(new SuccessResponseDto("Password should have Minimum 8 and maximum 50 characters, at least one uppercase letter, one lowercase letter, one number and one special character and No White Spaces", "Password validation not done"),HttpStatus.OK);
		}
		
		
			
	
	}
	}

