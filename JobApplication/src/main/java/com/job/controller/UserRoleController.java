package com.job.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.job.dto.ErrorResponseDto;
import com.job.dto.SuccessResponseDto;
import com.job.dto.UserRoleRequestDto;
import com.job.serviceInterface.UserRoleServiceInterface;

@RestController
@RequestMapping("/api/userrole")
public class UserRoleController {

	@Autowired
	private UserRoleServiceInterface userRoleServiceInterface;
	
	@PostMapping
	public ResponseEntity<?> addUserRole(@RequestBody UserRoleRequestDto userRoleRequestDto)
	{
		
	
			userRoleServiceInterface.addUserRole(userRoleRequestDto);
			
			return new ResponseEntity<>(new SuccessResponseDto("Success..", "SuccessFully Added UserRoles.."),HttpStatus.CREATED);	
		}
		
		
	
	
	@PutMapping
	public ResponseEntity<?> updateUserRole(@RequestBody UserRoleRequestDto userRoleRequestDto)
	{
		
		try
		{
		
		userRoleServiceInterface.updateUserRole(userRoleRequestDto);
		
		return new ResponseEntity<>(new SuccessResponseDto("Success..", "SuccessFully Updated UserRoles..."),HttpStatus.ACCEPTED);
		}catch(Exception e)
		{
			return new ResponseEntity<>(new ErrorResponseDto("Invalid..", "Invalid UserId and Role Id..."),HttpStatus.BAD_REQUEST);

		}
	}
	
	@DeleteMapping
	public ResponseEntity<?> deleteUserRole(@RequestBody UserRoleRequestDto userRoleRequestDto)
	{
		
		try
		{
		
		userRoleServiceInterface.deleteUserRole(userRoleRequestDto);
		
		return new ResponseEntity<>(new SuccessResponseDto("Success..", "SuccessFully Deleted UserRoles..."),HttpStatus.ACCEPTED);
		}catch(Exception e)
		{
			return new ResponseEntity<>(new ErrorResponseDto("Invalid..", "Invalid UserId and Role Id..."),HttpStatus.BAD_REQUEST);

		}
	}
	
//	
//	@GetMapping
//	public ResponseEntity<?> GetAllUserRole(@RequestBody UserRoleRequestDto userRoleRequestDto)
//	{
//		
//		try
//		{
//		
//		userRoleServiceInterface.GetAllUserRole(userRoleRequestDto);
//		
//		return new ResponseEntity<>(new SuccessResponseDto("Success..", "SuccessFully Updated UserRoles..."),HttpStatus.ACCEPTED);
//		}catch(Exception e)
//		{
//			return new ResponseEntity<>(new ErrorResponseDto("Invalid..", "Invalid UserId and Role Id..."),HttpStatus.BAD_REQUEST);
//
//		}
//	}
	
	
	
	
	
}
