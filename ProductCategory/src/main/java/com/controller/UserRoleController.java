package com.controller;

import javax.persistence.Column;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.entity.User;

@RestController
@RequestMapping("/userrole")
public class UserRoleController {

	
	@PostMapping
	public ResponseEntity<?> addUserRole(@RequestBody User user)
	{
		
		
		
		return null;
		
		
		
	}
	
	
}
