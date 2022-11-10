package com.job.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.job.dto.UserRoleRequestDto;
import com.job.entity.User;
import com.job.entity.UserRole;
import com.job.exception.ResourceNotFoundException;
import com.job.repository.RoleRepository;
import com.job.repository.UserRepository;
import com.job.repository.UserRoleRepository;
import com.job.serviceInterface.IUserJobListDto;
import com.job.serviceInterface.IUserListDto;
import com.job.serviceInterface.UserRoleServiceInterface;
import com.job.util.Pagination;

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
		
		try
		{
	

		
		ArrayList<UserRole> userRoles = new ArrayList<>();


		User userId=this.userRepository.findById(userRoleRequestDto.getUserId()).orElseThrow(()-> new com.job.exception.ResourceNotFoundException("Not Found UserId"));

		com.job.entity.Role roleId=roleRepository.findById(userRoleRequestDto.getRoleId()).orElseThrow(()-> new com.job.exception.ResourceNotFoundException("Not Found roleId"));
		
		UserRole userRole=new UserRole();
		com.job.entity.UserRoleId userRoleId=new com.job.entity.UserRoleId(userId,roleId);
		userRole.setPk(userRoleId);

		userRoles.add(userRole);
		//save in database
		userRoleRepository.saveAll(userRoles);
		
	}catch(Exception e)
	{
	
		throw new ResourceNotFoundException("Not Found UserId and RoleId"); 
	}

	}

	@Override
	public void updateUserRole(UserRoleRequestDto userRoleRequestDto) {
		
		ArrayList<UserRole> userRoles = new ArrayList<>();


		User userId=this.userRepository.findById(userRoleRequestDto.getUserId()).orElseThrow(()-> new com.job.exception.ResourceNotFoundException("Not Found UserId"));

		com.job.entity.Role roleId=roleRepository.findById(userRoleRequestDto.getRoleId()).orElseThrow(()-> new com.job.exception.ResourceNotFoundException("Not Found roleId"));
		
		UserRole userRole=new UserRole();
		com.job.entity.UserRoleId userRoleId=new com.job.entity.UserRoleId(userId,roleId);
		userRole.setPk(userRoleId);

		userRoles.add(userRole);
		
		userRoleRepository.updateUserRole(userId,roleId);
		
	}

	@Override
	public void deleteUserRole(UserRoleRequestDto userRoleRequestDto) {
		
		User userId=this.userRepository.findById(userRoleRequestDto.getUserId()).orElseThrow(()-> new com.job.exception.ResourceNotFoundException("Not Found UserId"));

		com.job.entity.Role roleId=roleRepository.findById(userRoleRequestDto.getRoleId()).orElseThrow(()-> new com.job.exception.ResourceNotFoundException("Not Found roleId"));
		
		UserRole userRole=new UserRole();
		com.job.entity.UserRoleId userRoleId=new com.job.entity.UserRoleId(userId,roleId);
		userRole.setPk(userRoleId);

		userRoleRepository.deleteUserRole(userId,roleId);
		
	}

//	@Override
//	public Page<IUserListDto> getAllUserRole(String search, String pageNumber, String pageSize) {
//		
//		Pageable pagable=new Pagination().getPagination(pageNumber, pageSize);
//		if((search=="")||(search==null)||(search.length()==0))
//		{
//			return userRoleRepository.findByOrderById(pagable,IUserListDto.class);
//		}
//		
//		return null;
//	
//	}

	

}
