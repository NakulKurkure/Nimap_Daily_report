package com.serviceInterface;

import org.springframework.data.domain.Page;

import com.dto.RoleDto;
import com.entity.Role;

public interface RoleServiceInterface {

	void addRole(RoleDto roleDto);

	RoleDto getByRoleId(Long id);

	RoleDto updateRoleById(RoleDto roleDto, Long id);

	void deleteRoleById(Long id);

	Page<IRoleListDto> getAllRoles(String search, String pageNumber, String pageSize);

}
