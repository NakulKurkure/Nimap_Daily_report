package com.springrestapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springrestapi.payload.JwtAuthRequest;
//import com.springrestapi.payload.JwtAuthRequest;
import com.springrestapi.payload.JwtAuthResponse;
import com.springrestapi.security.JwtTokenUtil;

@RestController
@RequestMapping("/auth")
public class AuthController {

	@Autowired
	private JwtTokenUtil jwtTokenUtil;

	@Autowired
	private UserDetailsService userDetailsService;

//	declare IN .security package //AuthenticationManager is Authenticate or not
	@Autowired
	private AuthenticationManager authenticationManager;

	//UserName and password firstly
	@PostMapping("/login")
	//JwtAuthResponse class inside Token
	//inside Username and password
	public ResponseEntity<JwtAuthResponse> createToken(@RequestBody JwtAuthRequest request) throws Exception
	{
		//Get Authenticate or not
		//in AuthenticationManager method
		this.authenticate(request.getUsername(),request.getPassword());
		//Inside userDetailsService class method
		UserDetails userDetail=this.userDetailsService.loadUserByUsername(request.getUsername());
		//get Token
		String token=this.jwtTokenUtil.generateToken(userDetail);
		//Send Token
		JwtAuthResponse response=new JwtAuthResponse();
		//Set Token
		response.setToken(token);

		//
				return new ResponseEntity<>(response,HttpStatus.OK);


	}

	//So we can Authenticate
	private void authenticate(String username, String password) throws Exception {
		// TODO Auto-generated method stub
		//
		UsernamePasswordAuthenticationToken authenticationToken=new UsernamePasswordAuthenticationToken(username,password);


		//Authenticate or not then exception
		this.authenticationManager.authenticate(authenticationToken);

	throw new Exception("Invalid Username and PAssword");


	}
}
