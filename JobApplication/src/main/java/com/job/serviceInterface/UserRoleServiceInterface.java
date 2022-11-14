package com.job.serviceInterface;

import org.springframework.data.domain.Page;

import com.job.dto.UserRoleRequestDto;

public interface UserRoleServiceInterface {

	void addUserRole(UserRoleRequestDto userRoleRequestDto);

	void updateUserRole(UserRoleRequestDto userRoleRequestDto);

	void deleteUserRole(UserRoleRequestDto userRoleRequestDto);

	Page<ILIstUserDto> getAllUserRole(String search, String pageNumber, String pageSize);

//	Page<ILIstUserDto> getAllUserRole(String search, String pageNumber, String pageSize);
}