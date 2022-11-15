package com.job.security;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;

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
	
	@Autowired
	private CacheOperation cacheOperation;
	
	@Autowired
	private RolePermissionServiceInterface rolePermissionServiceInterface;
	
	
	
	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		
		System.out.println("email"+email);
		
		
		User user=userRepository.findByEmailContainingIgnoreCase(email);
		
		System.out.println("email"+user);
		
		return new org.springframework.security.core.userdetails.User(user.getEmail(),user.getPassword(),getAuthority1(user));
	}
	

	
	@SuppressWarnings("unchecked")
	private ArrayList<SimpleGrantedAuthority> getAuthority1(User user) {

		ArrayList<SimpleGrantedAuthority> authorities = new ArrayList<>();
	System.out.println("hi");
		

			ArrayList<SimpleGrantedAuthority> authorities1 = new ArrayList<>();
			System.out.println("authorities");
			ArrayList<String> permissions = this.rolePermissionServiceInterface.getPermissionByUserId(user.getUserId());
			permissions.forEach(permission -> {
				
				authorities1.add(new SimpleGrantedAuthority("ROLE_" + permission));

			});
			authorities = authorities1;
			this.cacheOperation.addInCache(user.getUserId() + "permission", user.getUserId()+ "permission", authorities1);

			authorities = (ArrayList<SimpleGrantedAuthority>) this.cacheOperation.getFromCache(user.getUserId() + "permission", user.getUserId() + "permission");

		return authorities;

	}


	public UserDetailService() {
		super();
		
	}

	public boolean comparePassword(String password, String password2) {
		return passwordEncoder.matches(password, password2);
		
	}

}
