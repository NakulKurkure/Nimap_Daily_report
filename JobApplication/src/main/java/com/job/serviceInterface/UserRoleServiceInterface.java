package com.job.serviceInterface;


import org.springframework.data.domain.Page;

import com.job.dto.UserRoleRequestDto;

public interface UserRoleServiceInterface {

	void addUserRole(UserRoleRequestDto userRoleRequestDto);

	void updateUserRole(UserRoleRequestDto userRoleRequestDto);

	void deleteUserRole(UserRoleRequestDto userRoleRequestDto);

//	Page<IListUserRoleDto> getAllUserRole(String search, String pageNumber, String pageSize);

//	Page<IUserListDto> getAllUserRole(String search, String pageNumber, String pageSize);

//	List<IUserListDto> GetAllUserRole(UserRoleRequestDto userRoleRequestDto);

//	Page<IUserListDto> getAllUserRole(String search, String pageNumber, String pageSize);

}
