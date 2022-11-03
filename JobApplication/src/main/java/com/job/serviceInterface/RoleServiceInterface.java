package com.job.serviceInterface;

import org.springframework.data.domain.Page;

import com.job.dto.RoleDataDto;
import com.job.dto.RoleDto;

public interface RoleServiceInterface {

	void addRole(RoleDto roleDto);

	void updateRoleById(RoleDto roleDto, Long id);

	RoleDataDto getRole(Long id);

	void deleteRoleById(Long id);

	Page<IRoleListDto> getAllRoles(String search, String pageNumber, String pageSize);

}
