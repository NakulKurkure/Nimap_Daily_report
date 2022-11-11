package com.job.security;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Basic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import com.job.entity.User;
import com.job.repository.UserRepository;
import com.job.serviceImpl.CacheOperation;
import com.job.serviceInterface.RolePermissionServiceInterface;


@Component
public class UserDetailService implements UserDetailsService{

	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Autowired
	private UserRepository userRepository;
	
//	@Autowired
	private CacheOperation cacheOperation;
	
	@Autowired
	private RolePermissionServiceInterface rolePermissionServiceInterface;
	
	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		
		System.out.println("email"+email);
		
		
		User user=userRepository.findByEmailContainingIgnoreCase(email);
		
		System.out.println("email"+user);
		return new org.springframework.security.core.userdetails.User(user.getEmail(),user.getPassword(),new ArrayList<>());
	}
	
	
		
//		ArrayList<SimpleGrantedAuthority> getAuthority1(User users) {
//
//			ArrayList<SimpleGrantedAuthority> authorities = new ArrayList<>();
//
//			ArrayList<String> permissions = this.rolePermissionServiceInterface.getPermissionByPkUserId(users.getUserId());
//			permissions.forEach(e -> {
//				authorities.add(new SimpleGrantedAuthority("ROLE_" + e));
//
//			});
//			return authorities;
//		}
//	

	public UserDetailService() {
		super();
		
	}

	public boolean comparePassword(String password, String password2) {
		return passwordEncoder.matches(password, password2);
		
	}

}
