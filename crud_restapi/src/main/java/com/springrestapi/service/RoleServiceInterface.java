package com.springrestapi.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.springrestapi.dto.RoleDto;
import com.springrestapi.entity.RoleEntity;

public interface RoleServiceInterface {

	RoleDto addrole(RoleDto roleDto);

	RoleEntity getById(Integer id);

	RoleDto update(RoleDto roleDto, Integer id);

	void delete(Integer id);

//	Page<?> getProducts(String pageNum, String pageSize);

	Page<?> getProducts(String serach, String pageNum, String pageSize);

}
