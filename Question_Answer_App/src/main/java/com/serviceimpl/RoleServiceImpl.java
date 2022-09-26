package com.serviceimpl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.dto.RoleDto;
import com.entity.RoleEntity;
import com.exception.ResourceNotFoundException;
import com.repository.RoleRepository;
import com.serviceInterface.IRoleListDto;
import com.serviceInterface.RoleServiceInterface;
import com.util.Pagination;

@Service
public class RoleServiceImpl implements RoleServiceInterface{

	@Autowired
	private RoleRepository roleRepository;
	
	@Override
	public void addRole(RoleDto roleDto) {
		
	RoleEntity roleEntity=new RoleEntity();
	roleEntity.setRoleName(roleDto.getRoleName());
	roleEntity.setDescription(roleDto.getDescription());
	
	roleRepository.save(roleEntity);
	
		
	}

	@Override
	public RoleDto getById(Long id) {
		
		RoleEntity roleEntity=roleRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Not Found UserId."));
		
		RoleDto roleDto=new RoleDto();
		roleDto.setRoleName(roleEntity.getRoleName());
		roleDto.setDescription(roleEntity.getDescription());
		
		
		return roleDto;
	}

	@Override
	public RoleDto updateRole(RoleDto roleDto, Long id) {
		
		RoleEntity roleEntity=roleRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Not Found UserId."));
		
		
		roleEntity.setDescription(roleDto.getDescription());
		roleEntity.setRoleName(roleDto.getRoleName());
		
		roleRepository.save(roleEntity);
		
		return roleDto;
		
		
	}

	@Override
	public void deleteRole(Long id) {
		
		RoleEntity roleEntity=roleRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Not Found UserId."));
		
		roleRepository.deleteById(id);
	}


	@Override
	public Page<IRoleListDto> getAllRoles(String search, String pageNumber, String pageSize) {
		Pageable pagable=new Pagination().getPagination(pageNumber, pageSize);
		
		if((search=="")||(search==null)||search.length()==0)
		{
			return roleRepository.findByOrderById(pagable,IRoleListDto.class);
		}
		else
		{
			return roleRepository.findByRoleName(search,pagable,IRoleListDto.class);
		}
	
		
		
	}
	
	

}
