package com.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dto.UserDto;
import com.entity.User;
import com.repository.UserRepository;
import com.serviceInterface.UserServiceInterface;

@Service
public class UserServiceImpl implements UserServiceInterface{

	@Autowired
	private UserRepository userRepository;
	
	@Override
	public void addUser(UserDto userDto) {
		
		User user=new User();
		
		user.setEmail(userDto.getEmail());
		user.setGender(userDto.getGender());
		user.setUserName(userDto.getUserName());
		userRepository.save(user);
		
	}

}
