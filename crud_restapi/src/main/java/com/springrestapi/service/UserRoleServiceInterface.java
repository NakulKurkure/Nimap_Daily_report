package com.springrestapi.service;


import java.util.List;

import com.springrestapi.entity.UserRoleEntity;
import com.springrestapi.payload.UserRoleRequest;

public interface UserRoleServiceInterface{

//	void add(UserRoleRequest userRoleRequest);

//	void add(Optional<User> user, Optional<RoleEntity> roleEntity);

	void add(UserRoleRequest userRoleRequest);

	void editRole(UserRoleRequest userRoleRequest);

 Iterable<UserRoleEntity> getAll();



//	void add(Optional<User> user, Optional<RoleEntity> roleEntity);

//	void add(Optional<User> user, Optional<RoleEntity> roleEntity);

//	ResponseEntity<?> assignRole(Optional<User> user, Optional<RoleEntity> roleEntity);

//	UserRoleEntity add(UserRoleEntity userRoleEntity);
//
//	void delete(int id);

	
	
}
