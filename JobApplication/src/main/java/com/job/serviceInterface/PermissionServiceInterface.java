package com.job.serviceInterface;

import org.springframework.data.domain.Page;

import com.job.dto.PermissionDto;

public interface PermissionServiceInterface {

	void addPermission(PermissionDto dto);

	PermissionDto getPermissionById(Long id);

	void updatePermission(PermissionDto dto, Long id);

	void deletePermissionById(Long id);

//	Page<IPermissionListDto> getAllUsers(String search, String pageNumber, String pageSize);

	Page<IPermissionListDto> getAllpermission(String search, String pageNumber, String pageSize);

//	Page<IPermissionListDto> getAllUsers(String search, String pageNumber, String pageSize);

	
}
