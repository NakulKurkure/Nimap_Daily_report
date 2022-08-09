package com.springrestapi.controller;



import java.util.Calendar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;

//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.springrestapi.dto.LoggerDto;
import com.springrestapi.dto.UserDto;
import com.springrestapi.entity.User;
import com.springrestapi.errordto.SuccessResponseDto;
import com.springrestapi.payload.JwtAuthRequest;

import com.springrestapi.payload.JwtAuthResponse;
import com.springrestapi.repo.UserRepo;
import com.springrestapi.security.JwtTokenUtil;
import com.springrestapi.security.UserDetailService;
import com.springrestapi.service.LoggerServiceInterface;
import com.springrestapi.service.UserService;

@RestController
@RequestMapping("/auth")
public class AuthController {

	@Autowired
	private JwtTokenUtil jwtTokenUtil;

	@Autowired
	private UserService userService; 
	
	@Autowired
	private UserDetailService userDetailsService;

//	declare IN .security package //AuthenticationManager is Authenticate or not
	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private UserRepo userRepo;
	
	@Autowired
	private LoggerServiceInterface loggerServiceInterface;
	
	

	@PostMapping("/register")
	public ResponseEntity<?> add(@RequestBody UserDto entityDto)
	{
		UserDto entitydto=this.userService.add(entityDto);

		return new ResponseEntity<>(new SuccessResponseDto("success", "success", entitydto),HttpStatus.ACCEPTED);
//		return this.entity_service.add(entitydto);

	}
	
	
	
	
	//UserName and password firstly
	@PostMapping("/login")
	//JwtAuthResponse class inside Token
	//inside Username and password
	public ResponseEntity<?> createToken(@RequestBody JwtAuthRequest request) throws Exception
	{
		
		//Get Authenticate or not
		System.out.println("HEHHEHE  " +request.getUsername());

		try
		{
			
			System.out.println("ssss  " +request.getUsername());
			User user=userRepo.findByUsername(request.getUsername());
			System.out.println("HEHHEHE  " +user);
			System.out.println("sppppp  " +request.getUsername());
			System.out.println("HEHHEHE  " +user);
			//convert password to hash
		
			System.out.println("HEEHEH " + this.userDetailsService.comparePassword(request.getPassword(), user.getPassword()));

			if (this.userDetailsService.comparePassword(request.getPassword(), user.getPassword())) {
				//get Token
				String token=jwtTokenUtil.generateToken(user);

//				System.out.print(token);
//			//take LoggerDto and set Token
				LoggerDto logger = new LoggerDto();
				logger.setToken(token);
				Calendar calendar= Calendar.getInstance();
				calendar.add(calendar.MINUTE, 30);
				logger.setExpireAt(calendar.getTime());
				loggerServiceInterface.createLogger(logger, user);
				System.out.print(loggerServiceInterface);
				
//				//Send Token
				JwtAuthResponse response=new JwtAuthResponse();
//				//Set Token
				response.setToken(token);

//				return new ResponseEntity<>(response,HttpStatus.ACCEPTED);
				
				return new ResponseEntity<>(new SuccessResponseDto("token generated", "success", response),HttpStatus.ACCEPTED);
			}
			
			
//			

		//
			return new ResponseEntity<>("User name passord invalid",HttpStatus.ACCEPTED);
		
	}catch(Exception e)
	{
		return new ResponseEntity<>(e,HttpStatus.NOT_FOUND);
	}
//
		
	}
	
	
//	@RequestHeader annotation binds request header values to method parameters.
	@GetMapping("/logout")
	public ResponseEntity<?> logOutUsers(@RequestHeader String token)
	{
		loggerServiceInterface.logout(token);
		return new ResponseEntity<>(new SuccessResponseDto("Logout Successfully", "Success", 0),HttpStatus.ACCEPTED);
	}
	
}
