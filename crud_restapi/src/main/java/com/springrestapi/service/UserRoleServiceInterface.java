package com.springrestapi.service;


import java.util.List;

import com.springrestapi.entity.UserRoleEntity;
import com.springrestapi.payload.UserRoleRequest;

public interface UserRoleServiceInterface{



	void add(UserRoleRequest userRoleRequest);

	void editUserRole(UserRoleRequest userRoleRequest);

 List<UserRoleEntity> getAll();

void deleteUserRoles(UserRoleRequest userRoleRequest);



	
	
}
