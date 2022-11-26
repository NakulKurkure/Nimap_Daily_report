package com.job.serviceInterface;

import org.springframework.data.domain.Page;

import com.job.dto.UserRoleRequestDto;

public interface UserRoleServiceInterface {

	void addUserRole(UserRoleRequestDto userRoleRequestDto);

	void updateUserRole(UserRoleRequestDto userRoleRequestDto);

	void deleteUserRole(UserRoleRequestDto userRoleRequestDto);

	Page<ILIstUserDto> getAllUserRoles(String search, String pageNumber, String pageSize, String userId, String roleId);


}