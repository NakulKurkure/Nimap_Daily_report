package com.springrestapi.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.springrestapi.entity.User;
import com.springrestapi.exception.ResourseNotFoundException;
import com.springrestapi.repo.UserRepo;

@Service
//Authentication starts from UserDetailService
public class UserDetailService implements UserDetailsService{

	@Autowired
	private UserRepo userRepo;
	@Override
	//authenticate user
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
/////////////////////////
		//loading user from database by Username
		User user=this.userRepo.getUserByEmail(username).orElseThrow(()->new ResourseNotFoundException("Not Found.."+"yesss.."));

		
		
		System.out.print("yes");
		return user;


	}



}
