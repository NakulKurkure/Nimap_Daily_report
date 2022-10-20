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
		
		user.setEmail(userDto.getEmail());
		user.setGender(userDto.getGender());
		user.setUserName(userDto.getUserName());
		user.setPassword(passwordEncoder.encode(userDto.getPassword()));
		
		
		
		List<Long> role= userDto.getRoleId();
		
		ArrayList<Role> roles=new ArrayList<Role>();
		User user1=new User();
		for(int i=0;i<role.size();i++)
		{
		System.out.println("Role"+roles);
		
		System.out.println("Roles"+role);
		user1.setUserId(role.get(i));
		
		System.out.println("UserId"+user1.getUserId());	
		
		userDto.setRoleId(role);
	
		roles.addAll(roles);
		
		userRepository.save(user1);
		
		}
		
		
		
	}

	@Override
	public void updateUserById(UserDto userDto, Long id) {
	
		User user=userRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Not Found UserId..."));
	
		user.setEmail(userDto.getEmail());
		user.setGender(userDto.getGender());
		user.setUserName(userDto.getUserName());
		user.setPassword(passwordEncoder.encode(userDto.getPassword()));
		
		userRepository.save(user);
		
	}

	@Override
	public UserDataDto getByUserId(Long id) {
		
		User user=userRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Not Found UserId..."));
		
		UserDataDto userDataDto =new UserDataDto();
		userDataDto.setUserName(user.getUserName());
		userDataDto.setGender(user.getGender());
		userDataDto.setEmail(user.getEmail());
		
		return userDataDto;
	}

	@Override
	public void deleteUserById(Long id) {

		User user=userRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Not Found UserId..."));
		
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
