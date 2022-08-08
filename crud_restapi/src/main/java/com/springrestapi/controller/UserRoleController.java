package com.springrestapi.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springrestapi.entity.RoleEntity;
import com.springrestapi.entity.User;
import com.springrestapi.errordto.SuccessResponseDto;
import com.springrestapi.payload.UserRoleRequest;
import com.springrestapi.repo.RoleRepo;
import com.springrestapi.repo.UserRepo;
import com.springrestapi.service.UserRoleServiceInterface;

@RestController
@RequestMapping("/assignrole")
public class UserRoleController {

	@Autowired
	private UserRoleServiceInterface userRoleServiceInterface;

	@PostMapping
	public ResponseEntity<?> add(@RequestBody UserRoleRequest userRoleRequest)
	{
//		try
//		{
//			
//		
//		Optional<User> user=userRepo.findById(userRoleRequest.getUserId());
//		
//		Optional<RoleEntity> roleEntity=roleRepo.findById(userRoleRequest.getRoleId());
//		
//		this.userRoleServiceInterface.add(user,roleEntity);
//		}catch(Exception e)
//		{
//			System.out.print("Invalid UserId and RoleId.....");
//		}
//		
		
		userRoleServiceInterface.add(userRoleRequest);
		
		
		return new ResponseEntity<>(new SuccessResponseDto("Success", "Success", userRoleRequest),HttpStatus.ACCEPTED);
	}
	
	
	
	
//	@Autowired
//	private UserRoleServiceInterface userRoleServiceInterface;
//	
//	@PostMapping
//	public UserRoleEntity add(@RequestBody UserRoleEntity userRoleEntity) {
//		
//		
//		return this.userRoleServiceInterface.add(userRoleEntity);
//		
//	}
//	
//	public UserRoleEntity update(@RequestBody UserRoleEntity userRoleEntity,@PathVariable int id)
//	{
//		userRoleEntity.setUserId(id);
//	}
//	
//	
//	@DeleteMapping("/{id}")
//	public void delete(@PathVariable int id)
//	{
//		this.userRoleServiceInterface.delete(id);
//	}
//	
//	
	
}
