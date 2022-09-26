package com.security;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.entity.UserEntity;
import com.exception.ResourceNotFoundException;
import com.repository.AuthRepository;
import com.repository.UserRepository;
@Service
public class UserDetailService implements UserDetailsService{

	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Autowired
	private UserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		System.out.println("In the eree"+email);
	
		UserEntity userEntity=userRepository.findByEmailContainingIgnoreCase(email);
		System.out.println("In the"+userRepository.findByEmailContainingIgnoreCase(email));
			
			System.out.println("In the ppp"+email);

			return new org.springframework.security.core.userdetails.User(userEntity.getEmail(),userEntity.getPassword(),new ArrayList<>());
		
	}
	
	
	
	public UserDetailService() {
		super();
		// TODO Auto-generated constructor stub
	}



	public Boolean comparePassword(String password, String hashPassword) {

		return passwordEncoder.matches(password, hashPassword);

	}
//	

}
