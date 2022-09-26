package com.serviceInterface;

import java.util.List;

import com.dto.RolePermissionRequestDto;
import com.entity.RolePermissionEntity;

public interface RolePermissionServiceInterface {

	void addRolePermission(RolePermissionRequestDto rolePermissionRequestDto);

	void updateRolePermission(RolePermissionRequestDto rolePermissionRequestDto);

	void deleteRolePermission(RolePermissionRequestDto rolePermissionRequestDto);

	List<RolePermissionEntity> getAll();

}
