package com.serviceimpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dto.UserRoleRequestDto;
import com.entity.RoleEntity;
import com.entity.UserEntity;
import com.entity.UserRoleEntity;
import com.entity.UserRoleId;
import com.exception.ResourceNotFoundException;
import com.repository.RoleRepository;
import com.repository.UserRepository;
import com.repository.UserRoleRepository;
import com.serviceInterface.UserRoleServiceInterface;

@Service
public class UserRoleServiceImpl implements UserRoleServiceInterface{

	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private RoleRepository roleRepository;
	
	@Autowired
	private UserRoleRepository userRoleRepository;
	
	@Override
	public void addUserRole(UserRoleRequestDto userRoleRequestDto) {
		// TODO Auto-generated method stub
		
		try
		{
			
		
		ArrayList<com.entity.UserRoleEntity> userRoles = new ArrayList<>();


		UserEntity userId=this.userRepository.findById(userRoleRequestDto.getUserId()).orElseThrow(()-> new ResourceNotFoundException("Not Found UserId"));

		RoleEntity roleEntityId=this.roleRepository.findById(userRoleRequestDto.getRoleId()).orElseThrow(()-> new ResourceNotFoundException("Not Found RoleId"));

		com.entity.UserRoleEntity userRoleEntity=new UserRoleEntity();
		UserRoleId userRoleId=new UserRoleId(userId,roleEntityId);
		userRoleEntity.setPk(userRoleId);

		userRoles.add(userRoleEntity);
		//save in database
		userRoleRepository.saveAll(userRoles);



	}
	catch(Exception e)
	{
		System.out.println("Invalid RollId and UserId....");
		e.printStackTrace();
		throw new ResourceNotFoundException("NOt Found..");


	}

	}

	@Override
	public void updateUserRole(UserRoleRequestDto userRoleRequestDto) {

		ArrayList<UserRoleEntity> userRoles = new ArrayList<>();
		UserEntity userId=this.userRepository.findById(userRoleRequestDto.getUserId()).orElseThrow(()-> new ResourceNotFoundException("not Found"));		
		RoleEntity roleEntityId=this.roleRepository.findById(userRoleRequestDto.getRoleId()).orElseThrow(()-> new ResourceNotFoundException("not Found Id"));

		UserRoleEntity userRoleEntity=new UserRoleEntity();
		UserRoleId userRoleId=new UserRoleId(userId,roleEntityId);
		userRoleEntity.setPk(userRoleId);

		userRoles.add(userRoleEntity);
		
		this.userRoleRepository.updateUserRole(userId.getId(),roleEntityId.getId());
		
		
		
	}

	@Override
	public void deleteUserRoles(UserRoleRequestDto userRoleRequest) {
		UserEntity user =this.userRepository.findById(userRoleRequest.getUserId()).get();
		RoleEntity entity =this.roleRepository.findById(userRoleRequest.getRoleId()).get();
		UserRoleId userRoleId=new UserRoleId(user, entity);
		UserRoleEntity roleEntity=new UserRoleEntity();
		roleEntity.setPk(userRoleId);
		this.userRoleRepository.delete(roleEntity);
		
		
	}

	@Override
	public List<UserRoleEntity> getAll() {
		// TODO Auto-generated method stub
		List<UserRoleEntity> role= this.userRoleRepository.findAll();
		return role;
	}

}
