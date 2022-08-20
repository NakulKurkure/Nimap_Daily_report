package com.springrestapi.security;



import java.util.ArrayList;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.springrestapi.entity.User;
import com.springrestapi.repo.UserRepo;
import com.springrestapi.service.RolePermissionServiceInterface;

@Service
//Authentication starts from UserDetailService
//
public class UserDetailService implements UserDetailsService {

	@Autowired
	private UserRepo userRepo;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Autowired
	private RolePermissionServiceInterface rolePermissionServiceInterface;
	
	
	//authenticate user
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
	

		//loading user from database by Username
		User user=userRepo.findByUsername(username);
    
        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(),getAuthority1(user));

}

	
	

	public Boolean comparePassword(String password, String hashPassword) {

		return passwordEncoder.matches(password, hashPassword);

	}
	
	private ArrayList<SimpleGrantedAuthority> getAuthority1(User user)
	{
		
		ArrayList<SimpleGrantedAuthority> authorities=new ArrayList<>();
		
		ArrayList<?> permission=rolePermissionServiceInterface.getPermissionByUserId(user.getId());
		
		permission.forEach(permission1->
		{
			authorities.add(new SimpleGrantedAuthority("ROLE_"+permission1));
		});
		return authorities;
		
	}
	

}
