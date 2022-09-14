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

import com.app.entities.UserEntity;
import com.springrestapi.entity.User;
import com.springrestapi.exception.UserNotFoundException;
import com.springrestapi.repo.UserRepo;
import com.springrestapi.service.RolePermissionServiceInterface;
import com.springrestapi.serviceImpl.CacheOperation;

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
	
	@Autowired
	private CacheOperation cacheOperation;
	
	
	public UserDetailService() {
		super();
		// TODO Auto-generated constructor stub
	}




	//authenticate user
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
	
		User user;
		
		//loading user from database by Username

		if (!cacheOperation.isKeyExist(username, username)) {

			user = userRepo.findByUsername(username);
			cacheOperation.addInCache(username, username, user);

		} else {

			user = (User)cacheOperation.getFromCache(username, username);

		}

		if (user == null) {

			throw new UsernameNotFoundException("User not found with Email: " + username);

		}

		
//		User user=userRepo.findByUsername(username);
		
        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(),getAuthority1(user));
        
}

	
	

	public Boolean comparePassword(String password, String hashPassword) {

		return passwordEncoder.matches(password, hashPassword);

	}
	
	@SuppressWarnings("unchecked")
	private ArrayList<SimpleGrantedAuthority> getAuthority1(User user)
	{
		
		
		ArrayList<SimpleGrantedAuthority> authorities=new ArrayList<>();
		
		if(!cacheOperation.isKeyExist(user.getId()+"permission", user.getId()+"permission"))
		{
			ArrayList<SimpleGrantedAuthority> authorities1=new ArrayList<>();
			ArrayList<?> permission=rolePermissionServiceInterface.getPermissionByUserId(user.getId());
			permission.forEach(permission1->
			{
				authorities1.add(new SimpleGrantedAuthority("ROLE_"+permission1));
			});
			authorities=authorities1;
			cacheOperation.addInCache(user.getId()+"permission", user.getId()+"permission",authorities1);
			
		}else
		{
			authorities=(ArrayList<SimpleGrantedAuthority>) cacheOperation.getFromCache(user.getId()+"permission",user.getId()+"permission");
		}
		return authorities;
		
	}
//	
//	@SuppressWarnings("unchecked")
//	private ArrayList<SimpleGrantedAuthority> getAuthority(UserEntity userEntity){
//		
//    	ArrayList<SimpleGrantedAuthority> authorities = new ArrayList<>();
//
//    	if (!cache.isKeyExist(userEntity.getId() + "permission", userEntity.getId() + "permission")) {
//    	//if((userEntity.getId() + "permission") != null) {
//    		System.out.println(userEntity.getId()+ "permission");
//    		ArrayList<SimpleGrantedAuthority> authorities1=new ArrayList<>();
//    	
//    		ArrayList<String> permissions=roleService.getPermissionByUserId(userEntity.getId());
//    	
//    		permissions.forEach(permission -> {
//
//    			authorities1.add(new SimpleGrantedAuthority("ROLE_"+permission));
//    	   		
//    	});		
//    		authorities=authorities1;  
//    		cache.addInCache(userEntity.getId() + "permission", userEntity.getId() + "permission", authorities1);
//    	}
//    	else {
//			authorities = (ArrayList<SimpleGrantedAuthority>) cache.getFromCache(userEntity.getId() + "permission", userEntity.getId() + "permission");
//
//		}	
//    	return authorities;
//   }
//}
	

}
