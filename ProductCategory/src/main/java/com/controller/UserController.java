package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dto.SuccessDto;
import com.dto.UserDto;
import com.serviceInterface.UserServiceInterface;

@RestController
@RequestMapping("/api/user")
public class UserController {

	@Autowired
	private UserServiceInterface userServiceInterface;
	
	@PostMapping
	public ResponseEntity<?> addUser(@RequestBody UserDto userDto)
	{
		
		userServiceInterface.addUser(userDto);
		return new ResponseEntity<>(new SuccessDto("Success..", "SuccessFully Added User.."),HttpStatus.CREATED);
		
	}
	
}
