package com.serviceInterface;

import org.springframework.data.domain.Page;

import com.dto.PermissionDto;
import com.entity.PermissionEntity;

public interface PermissionServiceInterface {

	void addPermission(PermissionDto dto);

	PermissionDto getPermissionById(Long id);
	

	PermissionDto updatePermission(PermissionDto dto, Long id);

	void deletePermissionById(Long id);

	Page<IPermissionListDto> getAllUsers(String search, String pageNumber, String pageSize);
}
