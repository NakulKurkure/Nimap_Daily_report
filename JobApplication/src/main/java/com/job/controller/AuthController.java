package com.job.controller;

import java.util.Calendar;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.job.dto.AuthRequestDto;
import com.job.dto.AuthResponseDto;
import com.job.dto.AuthSuccessDto;
import com.job.dto.ErrorResponseDto;
import com.job.dto.SuccessResponseDto;
import com.job.dto.UserDto;
import com.job.entity.Logger;
import com.job.entity.User;
import com.job.repository.UserRepository;
import com.job.security.JwtTokenUtil;
import com.job.security.UserDetailService;
import com.job.serviceInterface.LoggerServiceInterface;
import com.job.serviceInterface.UserServiceInterface;
import com.job.validation.PasswordValidation;

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
	

	@PostMapping
	@RequestMapping("/register")
	public ResponseEntity<?> addUsers(@Valid @RequestBody UserDto userDto)
	{
		String email=userDto.getEmail();
		String password=userDto.getPassword();
		
		User user=userRepository.findByEmailContainingIgnoreCase(email);
			
		if(PasswordValidation.isValidforEmail(email))
			{
			
				if(PasswordValidation.isValid(password))
					{
					
					if(user==null) {
						
						userServiceInterface.addUser(userDto);
					
						return new ResponseEntity<>(new SuccessResponseDto("Success", "Successfully Added User"),HttpStatus.CREATED);	
						
					}else
					{
						return new ResponseEntity<>(new ErrorResponseDto("Alredy present in Database..", "Enter New Email.."),HttpStatus.NOT_FOUND);
						
					}
				
			
				}else
				{
					
					return new ResponseEntity<>(new ErrorResponseDto("Please Enter Proper format of Password..", "Password should be 8 to 30 characters in One Uppercase,One lowercase,One digit and One Unique Symbol..."),HttpStatus.NOT_FOUND);
				}
			}
			else
			{
				return new ResponseEntity<>(new ErrorResponseDto("Please Enter Proper format of Email .", "Email should be 8 to 30 characters in One Uppercase,One lowercase,One digit and One Unique Symbol..."),HttpStatus.BAD_REQUEST);
			}
			
		
		}
	
	
	@PostMapping("/login")
	public ResponseEntity<?> loginUser(@RequestBody AuthRequestDto authRequestDto)
	{
		String email=authRequestDto.getEmail();
		
		String password=authRequestDto.getPassword();
				
		if(PasswordValidation.isValidforEmail(email))
		{
			
			if(PasswordValidation.isValid(password))
			{
				
			
			try
			{
				
			System.out.println("In 2"+authRequestDto.getEmail());
			User user=userRepository.findByEmailContainingIgnoreCase(authRequestDto.getEmail());

			if(this.userDetailService.comparePassword(authRequestDto.getPassword(), user.getPassword()))
			{
				System.out.println("In 3"+user.getPassword());
				User users=this.userRepository.findByEmailContainingIgnoreCase(authRequestDto.getEmail());

				UserDetails userDetails=this.userDetailService.loadUserByUsername(authRequestDto.getEmail());
				System.out.println("userDetails"+userDetails);
				String token=this.jwtTokenUtil.generateToken(userDetails);
				System.out.println("Token"+token);
				AuthResponseDto authResponse=new AuthResponseDto();
				
				Logger logger=new Logger();
				Calendar calendar=Calendar.getInstance();
				calendar.add(calendar.MINUTE,5);
				logger.setToken(token);
				logger.setExpireAt(calendar.getTime());
				logger.setUserId(user);
				
				loggerServiceInterface.createLogger(logger,user);
				
				authResponse.setToken(token);

				return new ResponseEntity<>(new AuthSuccessDto("Login Successfully", "Successfully",authResponse),HttpStatus.ACCEPTED);
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
				return new ResponseEntity<>(new SuccessResponseDto("Password should have Minimum 8 and maximum 50 characters, at least one uppercase letter, one lowercase letter, one number and one special character and No White Spaces.", "Please Enter Valid Password.."),HttpStatus.BAD_REQUEST);

			}
			}else
			{
				return new ResponseEntity<>(new SuccessResponseDto("Email should have Minimum 8 and maximum 50 characters, at least one uppercase letter, one lowercase letter, one number and one special character and No White Spaces.", "Please Enter Valid Email Id.."),HttpStatus.BAD_REQUEST);
			}

			
			
		}
		
		
		
	}
	
	
	
