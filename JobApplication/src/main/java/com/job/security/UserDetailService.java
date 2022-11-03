package com.job.security;

import java.util.ArrayList;

import javax.persistence.Basic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import com.job.entity.User;
import com.job.repository.UserRepository;

@Component
public class UserDetailService implements UserDetailsService{

	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Autowired
	private UserRepository userRepository;
	
	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		
		System.out.println("email"+email);
		User user=userRepository.findByEmailContainingIgnoreCase(email);
		
		System.out.println("email"+user);
		return new org.springframework.security.core.userdetails.User(user.getEmail(),user.getPassword(),new ArrayList<>());
	}
	
	public UserDetailService() {
		super();
		
	}

	public boolean comparePassword(String password, String password2) {
		return passwordEncoder.matches(password, password2);
		
	}

}
