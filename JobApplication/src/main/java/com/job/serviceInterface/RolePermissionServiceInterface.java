package com.job.serviceInterface;

import java.util.ArrayList;

import org.springframework.data.domain.Page;

import com.job.dto.RolePermissionRequestDto;

public interface RolePermissionServiceInterface {

	void addRolePermission(RolePermissionRequestDto rolePermissionRequestDto);

	void updateRolePermission(RolePermissionRequestDto rolePermissionRequestDto);

	void deleteRolePermission(RolePermissionRequestDto rolePermissionRequestDto);

//	ArrayList<String> getPermissionByPkUserId(Long userId);

//	Page<IListRoleDto> getAllRolePermission(String search, String pageNumber, String pageSize);

}
