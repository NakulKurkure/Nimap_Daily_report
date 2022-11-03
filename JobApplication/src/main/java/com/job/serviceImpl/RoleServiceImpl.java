package com.job.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.job.dto.RoleDataDto;
import com.job.dto.RoleDto;
import com.job.entity.Role;
import com.job.exception.ResourceNotFoundException;
import com.job.repository.RoleRepository;
import com.job.serviceInterface.IRoleListDto;
import com.job.serviceInterface.RoleServiceInterface;
@Service
public class RoleServiceImpl implements RoleServiceInterface{

	@Autowired
	private RoleRepository roleRepository;
	
	@Override
	public void addRole(RoleDto roleDto) {
		
		Role role=new Role();
		role.setRoleName(roleDto.getRoleName());
		role.setDescription(roleDto.getDescription());
		
		roleRepository.save(role);
		
	}

	@Override
	public void updateRoleById(RoleDto roleDto, Long id) {
		
		Role role=roleRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Not Found RoleId"));
		
		role.setRoleName(roleDto.getRoleName());
		role.setDescription(roleDto.getDescription());
		
		roleRepository.save(role);
		
	}

	@Override
	public RoleDataDto getRole(Long id) {
		
		Role role=roleRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Not Found RoleId"));
		
		RoleDataDto roleDto=new RoleDataDto();
		roleDto.setRoleId(role.getRoleId());
		roleDto.setRoleName(role.getRoleName());
		roleDto.setDescription(role.getDescription());
		return roleDto;
	}

	@Override
	public void deleteRoleById(Long id) {
		
		Role role=roleRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Not Found RoleId"));

		roleRepository.deleteById(id);
		
	}

	@Override
	public Page<IRoleListDto> getAllRoles(String search, String pageNumber, String pageSize) {
		Pageable pagable=new com.job.util.Pagination().getPagination(pageNumber, pageSize);
		
		
		if((search=="")||(search==null)||(search.length()==0))
		{
			return roleRepository.findByOrderByRoleIdDesc(pagable,IRoleListDto.class);
		}
		else
		{
			return  roleRepository.findByRoleName(search,pagable,IRoleListDto.class);
		}
	}

}
