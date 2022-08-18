package com.springrestapi.service;

import org.springframework.data.domain.Page;

import com.springrestapi.dto.PermissionDto;
import com.springrestapi.entity.PermissionEntity;

public interface PermissionServiceInterface {

 PermissionDto addPermission(PermissionDto permissionDto);
		// TODO Auto-generated method stub
	
PermissionDto updatePermission(PermissionDto permissionDto,Integer id);

void delete(Integer id);

PermissionEntity getById(Integer id);

//Page<?> getProducts(String search, Integer pageNum, Integer pageSize);

Page<?> getProducts(String search, String pageNum, String pageSize);
	
}
