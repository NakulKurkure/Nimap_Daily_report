package com.springrestapi.service;

import java.util.Optional;

import org.springframework.http.ResponseEntity;

import com.springrestapi.entity.RoleEntity;
import com.springrestapi.entity.User;

public interface UserRoleServiceInterface{

	ResponseEntity<?> assignRole(Optional<User> user, Optional<RoleEntity> roleEntity);

	
	
}
