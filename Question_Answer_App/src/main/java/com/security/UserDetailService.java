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
import com.util.CacheOperations;
@Service
public class UserDetailService implements UserDetailsService{

	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private CacheOperations cacheOperations;

	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		System.out.println("In the eree"+email);
	
		UserEntity userEntity = null;
		if(!cacheOperations.isKeyExist(email, email))
		{
			
			UserEntity userEntity1=userRepository.findByEmailContainingIgnoreCase(email);
			
			cacheOperations.addInCache(email, email, userEntity1);
			System.out.println("From Database");
			
		}else
		{
			userEntity=(UserEntity) cacheOperations.getFromCache(email, email);
			System.out.println("From Cache");
		}
		
		if(userEntity==null)
		{
			throw new ResourceNotFoundException("Not Found EmailId");
		}
		
		
		System.out.println("In the"+userRepository.findByEmailContainingIgnoreCase(email));
			
			System.out.println("In the ppp"+email);

			return new org.springframework.security.core.userdetails.User(userEntity.getEmail(),userEntity.getPassword(),new ArrayList<>());
		
	}
	
	
	
	public UserDetailService() {
		super();
	}



	public Boolean comparePassword(String password, String hashPassword) {

		return passwordEncoder.matches(password, hashPassword);

	}


}
