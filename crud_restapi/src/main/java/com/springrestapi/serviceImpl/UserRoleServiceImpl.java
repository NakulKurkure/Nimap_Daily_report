package com.springrestapi.serviceImpl;

import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.springrestapi.entity.RoleEntity;
import com.springrestapi.entity.User;
import com.springrestapi.service.UserRoleServiceInterface;

@Service
public class UserRoleServiceImpl implements UserRoleServiceInterface{

	@Override
	public ResponseEntity<?> assignRole(Optional<User> user, Optional<RoleEntity> roleEntity) {
		
		
		
		return null;
	}

}
