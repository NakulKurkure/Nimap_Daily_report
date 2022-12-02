package com.job.serviceInterface;

import java.util.ArrayList;

import org.springframework.data.domain.Page;

import com.job.dto.RolePermissionRequestDto;

public interface RolePermissionServiceInterface {

	void addRolePermission1(RolePermissionRequestDto rolePermissionRequestDto);

	void deleteRolePermission(RolePermissionRequestDto rolePermissionRequestDto);

	Page<IListRoleDto> getAllRolePermission(String search, String pageNumber, String pageSize);

	ArrayList<String> getPermissionByUserId(Long userId);

	void updateRolePermission(RolePermissionRequestDto rolePermissionRequestDto);

//	ArrayList<String> getPermissionByUserId(Long id);

//	ArrayList<String> getPermissionByPkUserId(Long userId);

//	Page<IListRoleDto> getAllRolePermission(String search, String pageNumber, String pageSize);

}
