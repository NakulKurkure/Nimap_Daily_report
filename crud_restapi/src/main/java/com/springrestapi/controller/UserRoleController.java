package com.springrestapi.controller;

import java.util.ArrayList;
import java.util.List;

//import java.util.List;
//import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
//import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//import com.springrestapi.entity.RoleEntity;
//import com.springrestapi.entity.User;
import com.springrestapi.entity.UserRoleEntity;
import com.springrestapi.errordto.SuccessResponseDto;
//import com.springrestapi.exception.Errordetails;
import com.springrestapi.payload.UserRoleRequest;
//import com.springrestapi.repo.RoleRepo;
//import com.springrestapi.repo.UserRepo;
import com.springrestapi.service.UserRoleServiceInterface;

@RestController
@RequestMapping("/assignrole")
public class UserRoleController {

	@Autowired
	private UserRoleServiceInterface userRoleServiceInterface;

	@PostMapping
	public ResponseEntity<?> add( @RequestBody UserRoleRequest userRoleRequest)
	{
		try
		{		
		userRoleServiceInterface.add(userRoleRequest);
		return new ResponseEntity<>(new SuccessResponseDto("Success", "Success", userRoleRequest),HttpStatus.OK);
		}catch(Exception e)
		{

			return new ResponseEntity<>("failed",HttpStatus.BAD_REQUEST);

			
		}
		
	}
	
	@GetMapping
	public List<UserRoleEntity> getAll()
	{
		
		return this.userRoleServiceInterface.getAll();
			
	}

	
	@PutMapping  //userId-17  roleId - 15
	public ResponseEntity<?> editRole(@RequestBody UserRoleRequest userRoleRequest)
	{
		try
		{
			
			this.userRoleServiceInterface.editUserRole(userRoleRequest);
			return new ResponseEntity<>(new SuccessResponseDto("Success", "Success", userRoleRequest),HttpStatus.ACCEPTED);
		}catch(Exception e)
		{
			return new ResponseEntity<>("Not Found",HttpStatus.NOT_FOUND);
		}
//		
		
		
	}
	
	
	@DeleteMapping
	public ResponseEntity<?> delete(@RequestBody UserRoleRequest userRoleRequest)
	{
		
		try
		{
			
			this.userRoleServiceInterface.deleteUserRoles(userRoleRequest);
			return new ResponseEntity<>(HttpStatus.OK);
		}catch(Exception e)
		{
			System.out.print("Not Found...");
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	
		
	}
	
	
	
}
