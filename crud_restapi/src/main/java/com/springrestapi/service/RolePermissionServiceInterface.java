package com.springrestapi.service;

import java.util.List;

import com.springrestapi.entity.RolePermissionEntity;
import com.springrestapi.payload.RolePermissionRequest;

public interface RolePermissionServiceInterface {

	void add(RolePermissionRequest rolePermissionRequest);

	List<RolePermissionEntity> getAll();

	void updateRolePermission(RolePermissionRequest rolePermissionRequest);

	void deleteRolePermission(RolePermissionRequest rolePermissionRequest);

}
