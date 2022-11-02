package com.serviceImpl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.management.relation.RoleResult;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.SystemEnvironmentPropertySource;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.ResourceAccessException;

import com.dto.UserDataDto;
import com.dto.UserDto;
import com.entity.Role;
import com.entity.User;
import com.exception.ResourceNotFoundException;
import com.repository.RoleRepository;
import com.repository.UserRepository;
import com.serviceInterface.IUserListDto;
import com.serviceInterface.UserServiceInterface;
import com.util.Pagination;

@Service
public class UserServiceImpl implements UserServiceInterface{

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private RoleRepository roleRepository;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Override
	public void addUser(UserDto userDto) {
		User user=new User();
		//iterate and Save
		ArrayList<Role> roles=new ArrayList<Role>();
		System.out.println("Role"+userDto.getRoleId().size());
		for(int i=0;i<userDto.getRoleId().size();i++)
		{
			
		System.out.println("Role"+roles);
		
		Long roleId= userDto.getRoleId().get(i);
		System.out.println("RoleId"+roleId);
		Role role1= roleRepository.findById(roleId).orElseThrow(()-> new ResourceNotFoundException("Not Found RoleId"));		
		System.out.println("RoleId"+roleId);
		
		System.out.println("Role1"+role1);
		
		System.out.println("Roles"+roles);
		
		user.setEmail(userDto.getEmail());
		user.setGender(userDto.getGender());
		user.setUserName(userDto.getUserName());
		user.setPassword(passwordEncoder.encode(userDto.getPassword()));
		
		
		System.out.println("user"+user);
		
		roles.add(role1);
		user.setRole(roles);
		userRepository.save(user);

		
		}
	
	}
			
	@Override
	public void updateUserById(UserDto userDto, Long id) {
	
		User user=userRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Not Found UserId..."));
		
		ArrayList<Role> roles=new ArrayList<>();
		
		for(int i=0;i<userDto.getRoleId().size();i++)
		{
			
		Long roleId=userDto.getRoleId().get(i);
		
		Role role=roleRepository.findById(roleId).orElseThrow(()-> new ResourceNotFoundException("Not Found RoleId.."));
		
		
		user.setEmail(userDto.getEmail());
		user.setGender(userDto.getGender());
		user.setUserName(userDto.getUserName());
		user.setPassword(passwordEncoder.encode(userDto.getPassword()));
			
		roles.add(role);
		
		user.setRole(roles);
		userRepository.save(user);
		}
	
	}
	
	@Override
	public List<IUserListDto> getByUserId(Long id) {
		
		userRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Not Found UserId..."));
		
		List<IUserListDto> users=userRepository.findByUserId(id,IUserListDto.class);
		
		return (List<IUserListDto>) users;
	}
	
	@Override
	public void deleteUserById(Long id) {

		userRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Not Found UserId..."));
		
		userRepository.deleteById(id);
		
	}

	@Override
	public Page<IUserListDto> getAllUsers(String search, String pageNumber, String pageSize) {
	
		Pageable pagable=new Pagination().getPagination(pageNumber, pageSize);
		if((search=="")||(search==null)||(search.length()==0))
		{
			return userRepository.findByOrderByUserIdDesc(pagable,IUserListDto.class);
		}
		else
		{
			return  userRepository.findByUserName(search,pagable,IUserListDto.class);
		}

	}

}
