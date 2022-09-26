package com.serviceimpl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.dto.UserDataDto;
import com.dto.UserDto;
import com.entity.UserEntity;
import com.exception.ResourceNotFoundException;
import com.repository.UserRepository;
import com.serviceInterface.IUserListDto;
import com.serviceInterface.UserServiceInterface;
import com.util.Pagination;

@Service
public class UserServiceImpl implements UserServiceInterface{

	

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Override
	public void addUser(UserDto userDto) {
		
		UserEntity userEntity1=new UserEntity();;
		userEntity1.setEmail(userDto.getEmail());
		userEntity1.setGender(userDto.getGender());
		userEntity1.setUsername(userDto.getUsername());
		userEntity1.setPassword(passwordEncoder.encode(userDto.getPassword()));
		
		userRepository.save(userEntity1);
		
	
		
	}

	@Override
	public UserDataDto getUserId(Long id) {
		
		UserEntity userEntity=userRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Not Found User Id"));
		System.out.println("In 1"+id);
		
		UserDataDto userDataDto=new UserDataDto();
		userDataDto.setUsername(userEntity.getUsername());
		userDataDto.setGender(userEntity.getGender());
		userDataDto.setEmail(userEntity.getEmail());
		
		return userDataDto;
	}

	@Override
	public UserDto updateUser(UserDto userDto, Long id) {
		
		UserEntity userEntity=userRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Not Found User Id"));
		
		
		userEntity.setEmail(userDto.getEmail());
		userEntity.setGender(userDto.getGender());
		userEntity.setUsername(userDto.getUsername());
		String password=passwordEncoder.encode(userDto.getPassword());
		userEntity.setPassword(password);
		
		userRepository.save(userEntity);
		return userDto;
	}

	@Override
	public void deleteUserId(Long id) {


		UserEntity userEntity=userRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("Not Found User Id"));
	
		userRepository.deleteById(id);
	}

	@Override
	public Page<IUserListDto> getAllUsers(String search, String pageNumber, String pageSize) {
		// TODO Auto-generated method stub
		
		Pageable pagable=new Pagination().getPagination(pageNumber, pageSize);
		if((search=="")||(search==null)||(search.length()==0))
		{
			return userRepository.findByOrderById(pagable,IUserListDto.class);
		}
		else
		{
			return  userRepository.findByUsername(search,pagable,IUserListDto.class);
		}
		
	}

	
	

}
