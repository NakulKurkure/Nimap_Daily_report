package com.springrestapi.serviceImpl;

import java.lang.module.ResolutionException;
import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.app.exceptionsHandling.ResourceNotFoundException;
import com.springrestapi.entity.RoleEntity;
import com.springrestapi.entity.User;
import com.springrestapi.entity.UserRoleEntity;
import com.springrestapi.entity.UserRoleId;
import com.springrestapi.exception.ResourseNotFoundException;
import com.springrestapi.payload.UserRoleRequest;
import com.springrestapi.repo.RoleRepo;
import com.springrestapi.repo.UserRepo;
import com.springrestapi.repo.UserRoleRepo;
//import com.springrestapi.repo.UserRoleRepo;
import com.springrestapi.service.UserRoleServiceInterface;

@Service
public class UserRoleServiceImpl implements UserRoleServiceInterface{

	@Autowired
	private UserRoleRepo userRoleRepo;
	
	@Autowired
	private UserRepo userRepo;

	@Autowired
	private RoleRepo roleRepo;
	
	
	@Override
	public void add(UserRoleRequest userRoleRequest) {
		// TODO Auto-generated method stub
		
//		System.out.print("Hello");
		
			try {
			
//				System.out.print("Hello");
		ArrayList<UserRoleEntity> userRoles = new ArrayList<>();
		
		User userId=this.userRepo.findById(userRoleRequest.getUserId()).orElseThrow(()->new ResourseNotFoundException("Not found"));
//		System.out.println("gjdd"+userId.getId());
		
		RoleEntity roleEntityId=this.roleRepo.findById(userRoleRequest.getRoleId()).orElseThrow(()-> new ResourseNotFoundException("Not Found RollId"));
//		System.out.print(roleEntityId.getId());
//		
		
		UserRoleEntity userRoleEntity=new UserRoleEntity();
		UserRoleId userRoleId=new UserRoleId(userId,roleEntityId);
		userRoleEntity.setPk(userRoleId);
		
		userRoles.add(userRoleEntity);
		//save in database
		userRoleRepo.saveAll(userRoles);
			}catch(Exception e)
			{
				System.out.print("Invalid RollId and UserId....");
//				throw new ResourceNotFoundException("Not Found");
				
			}
		
	
		
		
	}
	

}
