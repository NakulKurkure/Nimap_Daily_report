package com.springrestapi.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.ResponseEntity;

import com.springrestapi.entity.RolePermissionEntity;
import com.springrestapi.payload.RolePermissionRequest;

public interface RolePermissionServiceInterface {

	void add(RolePermissionRequest rolePermissionRequest);

	List<RolePermissionEntity> getAll();

	void updateRolePermission(RolePermissionRequest rolePermissionRequest);

	void deleteRolePermission(RolePermissionRequest rolePermissionRequest);

	ArrayList<String> getPermissionByUserId(int id);

}
