package com.job.serviceInterface;

import com.job.dto.UserRoleRequestDto;

public interface UserRoleServiceInterface {

	void addUserRole(UserRoleRequestDto userRoleRequestDto);

	void updateUserRole(UserRoleRequestDto userRoleRequestDto);

	void deleteUserRole(UserRoleRequestDto userRoleRequestDto);

}
