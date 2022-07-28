//package com.springrestapi.controller;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.authentication.DisabledException;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//import org.springframework.web.bind.annotation.RestControllerAdvice;
//
//import com.springrestapi.config.JwtTokenUtil;
//import com.springrestapi.payload.JwtAuthRequest;
//import com.springrestapi.payload.JwtAuthResponse;
//
//@RestController
//@RequestMapping("/api/v1/auth")
//public class AuthController {
//
//	@Autowired
//	private JwtTokenUtil jwtTokenUtil;
//	
//	@Autowired
//	private UserDetailsService userDetailsService;
//	
//	
//	@Autowired
//	private AuthenticationManager authenticationManager;
//	
//	@PostMapping("/login")
//	public ResponseEntity<JwtAuthResponse> createToken(@RequestBody JwtAuthRequest request)
//	{
//		this.authenticate(request.getUsername(),request.getPassword());
//		UserDetails userDetail=this.userDetailsService.loadUserByUsername(request.getUsername());
//		String token=this.jwtTokenUtil.generateToken(userDetail);
//		JwtAuthResponse response=new JwtAuthResponse();
//		response.setToken(token);
//		
//		
//				return new ResponseEntity<JwtAuthResponse>(response,HttpStatus.OK);
//				
//		
//	}
//
//	private void authenticate(String username, String password) {
//		// TODO Auto-generated method stub
//		UsernamePasswordAuthenticationToken authenticationToken=new UsernamePasswordAuthenticationToken(username,password);
//	try
//	{
//		this.authenticationManager.authenticate(authenticationToken);
//	}catch(DisabledException e)
//	{
//	System.out.print(e);
//	}
//		
//	}
//}
