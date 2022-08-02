package com.springrestapi.security;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.springrestapi.entity.User;
import com.springrestapi.repo.UserRepo;

@Service
//Authentication starts from UserDetailService
public class UserDetailService implements UserDetailsService{


	private UserRepo userRepo;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	//authenticate user
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
	

		//loading user from database by Username
		User user=this.userRepo.findByUsername(username);
    
        return user;

}

	public Boolean comparePassword(String password, String hashPassword) {

		return passwordEncoder.matches(password, hashPassword);

	}

}
