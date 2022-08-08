package com.springrestapi.serviceImpl;

import java.lang.module.ResolutionException;
import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springrestapi.entity.RoleEntity;
import com.springrestapi.entity.User;
import com.springrestapi.entity.UserRoleEntity;
import com.springrestapi.entity.UserRoleId;
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
		
		try
		{
			
		ArrayList<UserRoleEntity> userRoles = new ArrayList<>();
		Optional<User> userId=this.userRepo.findById(userRoleRequest.getUserId());
		Optional<RoleEntity> roleEntityId=roleRepo.findById(userRoleRequest.getRoleId());
		
		//assign role to User
		
//		UserRoleEntity userRoleEntity=new UserRoleEntity();
		
		User user=new User();
		user.setId(userRoleRequest.getUserId());//4
		RoleEntity roleEntity=new RoleEntity();
		roleEntity.setId(userRoleRequest.getRoleId());//5
		
		
		UserRoleId userRoleId=new UserRoleId(user,roleEntity);
//		userRoleEntity.setPk(userRoleId);
//		userRoles.add(userRoleEntity);
		
		this.userRoleRepo.saveAll(userRoles);
		
		
		}catch(Exception e)
		{
			System.out.print("Invalid RollId and UserId....");
			throw new ResolutionException("invalid");
		}
	
		
		
	}
	

}
