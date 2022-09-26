//package com.serviceimpl;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.stereotype.Service;
//
//import com.dto.UserDto;
//import com.repository.UserRepository;
//import com.serviceInterface.AuthServiceInterface;
//import com.userentity.UserEntity;
//
//@Service
//public class AuthServiceImpl implements AuthServiceInterface{
//
//	
//	@Autowired
//	private UserRepository userRepository;
//	
//	@Autowired
//	private PasswordEncoder passwordEncoder;
//	
//	@Override
//	public void addUser(UserDto userDto) {
//		
//		UserEntity userEntity1=new UserEntity();;
//		userEntity1.setEmail(userDto.getEmail());
//		userEntity1.setGender(userDto.getGender());
//		userEntity1.setUsername(userDto.getUsername());
//		userEntity1.setPassword(passwordEncoder.encode(userDto.getPassword()));
//		
//		userRepository.save(userEntity1);
//		
//	
//		
//	}
//	
//
//
//	
//	
//}
