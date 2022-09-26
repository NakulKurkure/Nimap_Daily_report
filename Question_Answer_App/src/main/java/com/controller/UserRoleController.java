package com.controller;

import java.util.List;

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

import com.dto.ErrorResponseDto;
import com.dto.SuccessResponseDto;
import com.dto.UserRoleRequestDto;
import com.entity.UserRoleEntity;
import com.serviceInterface.UserRoleServiceInterface;

@RestController
@RequestMapping("/userrole")
public class UserRoleController {

	@Autowired
	private UserRoleServiceInterface userRoleServiceInterface;
	
	
	@PostMapping
	public ResponseEntity<?> addUserRole(@RequestBody UserRoleRequestDto userRoleRequestDto)
	{
		try
		{
			
		
		userRoleServiceInterface.addUserRole(userRoleRequestDto);
		return new ResponseEntity<>(new SuccessResponseDto("Success", "Success", userRoleRequestDto),HttpStatus.OK);
		}catch(Exception e)
		{
			return new ResponseEntity<>("Not Found UserId and RoleId..",HttpStatus.BAD_REQUEST);
		}
	}
	
	@PutMapping
	public ResponseEntity<?> updateUserRole (@RequestBody UserRoleRequestDto userRoleRequestDto)
	{
		try
		{
			
			this.userRoleServiceInterface.updateUserRole(userRoleRequestDto);
			return new ResponseEntity<>(new SuccessResponseDto("Successfully Updated..", "Updated..", userRoleRequestDto),HttpStatus.OK);
		}catch(Exception e)
		{
			return new ResponseEntity<>("Not Found UserId and RoleId..",HttpStatus.NOT_FOUND);
		}
		
	}
	
	@DeleteMapping
	public ResponseEntity<?> deleteUserRole(@RequestBody UserRoleRequestDto userRoleRequest)
	{
		
		try
		{
			
			this.userRoleServiceInterface.deleteUserRoles(userRoleRequest);
			return new ResponseEntity<>(new SuccessResponseDto("Successfully Deleted User Roles..", "Success"),HttpStatus.OK);
		}catch(Exception e)
		{
			System.out.print("Not Found...");
			return new ResponseEntity<>(new ErrorResponseDto("Not Found UserId and RoleId", "Successfully Deleted User Roles.."), HttpStatus.NOT_FOUND);
		}
	
		
	}
	
	@GetMapping
	public List<UserRoleEntity>getAllUserRole()
	{
		
		return this.userRoleServiceInterface.getAll();
		
	}
	
	
	
	
	
	
	
}
