package com.springrestapi.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.exceptionsHandling.ResourceNotFoundException;
import com.springrestapi.entity.RoleEntity;
import com.springrestapi.entity.User;
import com.springrestapi.entity.UserRoleEntity;
import com.springrestapi.entity.UserRoleId;
import com.springrestapi.errordto.SuccessResponseDto;
import com.springrestapi.exception.Errordetails;
import com.springrestapi.payload.UserRoleRequest;
import com.springrestapi.repo.RoleRepo;
import com.springrestapi.repo.UserRepo;
import com.springrestapi.service.UserRoleServiceInterface;

@RestController
@RequestMapping("/assign")
public class UserRoleController {

	private UserRepo userRepo;
	private UserRoleId userRoleId;

	@Autowired
	private UserRoleServiceInterface userRoleServiceInterface;

	private RoleRepo roleRepo;
	private RoleEntity roleEntity;
	@Autowired
	private UserRoleEntity userRoleEntity;
	
	@PostMapping("/role")
	public ResponseEntity<?> assignRole(@RequestBody UserRoleRequest userRoleRequest )
	{
	
		try
		{
			
			Optional<User> user=userRepo.findById(userRoleRequest.getUserId());
			
//			System.out.print(user);
			Optional<RoleEntity> roleEntity=roleRepo.findById(userRoleRequest.getRoleId());			
//			System.out.print(roleEntity);
			return this.userRoleServiceInterface.assignRole(user,roleEntity);
		
		}catch(Exception e)
		{
			System.out.println("Invalid UserId and RoleId");
			
		}
		
		return new ResponseEntity<>(new SuccessResponseDto("Success", "Success", userRoleRequest),HttpStatus.ACCEPTED);
		
		
	}
	
}
