package com.job.serviceInterface;

import com.job.dto.RolePermissionRequestDto;

public interface RolePermissionServiceInterface {

	void addRolePermission(RolePermissionRequestDto rolePermissionRequestDto);

	void updateRolePermission(RolePermissionRequestDto rolePermissionRequestDto);

	void deleteRolePermission(RolePermissionRequestDto rolePermissionRequestDto);

}
