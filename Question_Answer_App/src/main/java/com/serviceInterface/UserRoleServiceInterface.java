package com.serviceInterface;

import java.util.List;

import com.dto.UserRoleRequestDto;
import com.entity.UserRoleEntity;

public interface UserRoleServiceInterface {

	void addUserRole(UserRoleRequestDto userRoleRequestDto);

	void updateUserRole(UserRoleRequestDto userRoleRequestDto);

	void deleteUserRoles(UserRoleRequestDto userRoleRequest);

	List<UserRoleEntity> getAll();

}
