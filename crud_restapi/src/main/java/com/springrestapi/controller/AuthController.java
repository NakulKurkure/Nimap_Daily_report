package com.springrestapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;


import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springrestapi.entity.User;


import com.springrestapi.payload.JwtAuthRequest;

import com.springrestapi.payload.JwtAuthResponse;
import com.springrestapi.repo.UserRepo;
import com.springrestapi.security.JwtTokenUtil;
import com.springrestapi.security.UserDetailService;

@RestController
@RequestMapping("/auth")
public class AuthController {

	@Autowired
	private JwtTokenUtil jwtTokenUtil;

	@Autowired
	private UserDetailService userDetailsService;

//	declare IN .security package //AuthenticationManager is Authenticate or not
	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private UserRepo userRepo;
	
	
	
	//UserName and password firstly
	@PostMapping("/login")
	//JwtAuthResponse class inside Token
	//inside Username and password
	public ResponseEntity<?> createToken(@RequestBody JwtAuthRequest request) throws Exception
	{
		
		//Get Authenticate or not
	
		try
		{
			
			User user=userRepo.findByUsername(request.getUsername());
			System.out.println("HEHHEHE  " +user);
			//convert password to hash
		
			System.out.println("HEEHEH " + this.userDetailsService.comparePassword(request.getPassword(), user.getPassword()));

			if (this.userDetailsService.comparePassword(request.getPassword(), user.getPassword())) {
				//get Token
				String token=jwtTokenUtil.generateToken(user);

//				//Send Token
				JwtAuthResponse response=new JwtAuthResponse();
//				//Set Token
				response.setToken(token);

				return new ResponseEntity<>(response,HttpStatus.ACCEPTED);
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
	
	//So we can Authenticate
	private void authenticate(String username, String password) throws Exception {
		// TODO Auto-generated method stub
		//
		
		UsernamePasswordAuthenticationToken authenticationToken=new UsernamePasswordAuthenticationToken(username,password);


		//Authenticate or not then exception
		
			this.authenticationManager.authenticate(authenticationToken);
		
		
		
	}
//	
	
}
