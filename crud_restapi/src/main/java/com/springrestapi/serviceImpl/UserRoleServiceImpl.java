package com.springrestapi.serviceImpl;


import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

//import com.app.exceptionsHandling.ResourceNotFoundException;
import com.springrestapi.entity.RoleEntity;
import com.springrestapi.entity.User;
import com.springrestapi.entity.UserRoleEntity;
import com.springrestapi.entity.UserRoleId;
//import com.springrestapi.exception.Errordetails;
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
			
			try {
			

		ArrayList<UserRoleEntity> userRoles = new ArrayList<>();
		
		
		User userId=this.userRepo.findById(userRoleRequest.getUserId()).orElseThrow(()->new ResourseNotFoundException("Not found"));

		RoleEntity roleEntityId=this.roleRepo.findById(userRoleRequest.getRoleId()).orElseThrow(()-> new ResourseNotFoundException("Not Found RollId"));
		
		UserRoleEntity userRoleEntity=new UserRoleEntity();
		UserRoleId userRoleId=new UserRoleId(userId,roleEntityId);
		userRoleEntity.setPk(userRoleId);
		
		userRoles.add(userRoleEntity);
		//save in database
		userRoleRepo.saveAll(userRoles);
		
	
		
			}catch(Exception e)
			{
				System.out.println("Invalid RollId and UserId....");
				e.printStackTrace();
				throw new ResourseNotFoundException("Not found");
				
				
			}
			
	}


	@Override //U -17 r-18
	public void editRole(UserRoleRequest userRoleRequest) {
		// TODO Auto-generated method stub
		
		ArrayList<UserRoleEntity> userRoles = new ArrayList<>();
		try
		{
			
		
		User userId=this.userRepo.findById(userRoleRequest.getUserId()).orElseThrow(()-> new ResourseNotFoundException("not found"));		
		RoleEntity roleEntityId=roleRepo.findById(userRoleRequest.getRoleId()).orElseThrow(()-> new ResourseNotFoundException("Not Found RollId."));

		UserRoleEntity userRoleEntity=new UserRoleEntity();
		UserRoleId userRoleId=new UserRoleId(userId,roleEntityId);
		userRoleEntity.setPk(userRoleId);
		
		userRoles.add(userRoleEntity);
		userRoleRepo.saveAll(userRoles);
		}catch (Exception e) {
			throw new ResourseNotFoundException("Not updated Id.");
		}
				
	}


	@Override
	public Iterable<UserRoleEntity> getAll() {
	
		Iterable<UserRoleEntity> role= this.userRoleRepo.findAll();
		return role;
	
		
		}
	

}
