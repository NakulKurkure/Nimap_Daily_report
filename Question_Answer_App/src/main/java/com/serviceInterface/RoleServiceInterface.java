package com.serviceInterface;

import org.springframework.data.domain.Page;

import com.dto.RoleDto;
import com.entity.RoleEntity;

public interface RoleServiceInterface {

	void addRole(RoleDto roleDto);

	RoleDto getById(Long id);

	RoleDto updateRole(RoleDto roleDto, Long id);

	void deleteRole(Long id);

	Page<IRoleListDto> getAllRoles(String search, String pageNumber, String pageSize);

}
