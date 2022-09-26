package com.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.dto.PermissionDto;
import com.entity.PermissionEntity;
import com.exception.ResourceNotFoundException;
import com.repository.PermissionRepository;
import com.serviceInterface.IPermissionListDto;
import com.serviceInterface.IUserListDto;
import com.serviceInterface.PermissionServiceInterface;
import com.util.Pagination;

@Service
public class PermissionServiceImpl implements PermissionServiceInterface{

	@Autowired
	private PermissionRepository permissionRepository;
	
	@Override
	public void addPermission(PermissionDto dto) {
		// TODO Auto-generated method stub
		
		PermissionEntity permissionEntity = new PermissionEntity();
		permissionEntity.setActionName(dto.getActionName());
		permissionEntity.setBaseUrl(dto.getBaseUrl());
		permissionEntity.setDescription(dto.getDescription());
		permissionEntity.setMethod(dto.getMethod());
		permissionEntity.setPath(dto.getPath());
		permissionRepository.save(permissionEntity);
		
	}

	public PermissionDto getPermissionById(Long id)
	{
		PermissionEntity permissionEntity= this.permissionRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Not Found Id"));
		
		PermissionDto permissionDto=new PermissionDto();
		permissionDto.setActionName(permissionEntity.getActionName());
		permissionDto.setBaseUrl(permissionEntity.getBaseUrl());
		permissionDto.setDescription(permissionEntity.getDescription());
		permissionDto.setMethod(permissionEntity.getMethod());
		permissionDto.setPath(permissionEntity.getPath());
		
		
		
		
		return permissionDto;
	}

	@Override
	public PermissionDto updatePermission( PermissionDto dto,Long id) {
		// TODO Auto-generated method stub
		PermissionEntity permissionEntity= this.permissionRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Not Found Id"));
		
		permissionEntity.setActionName(dto.getActionName());
		permissionEntity.setBaseUrl(dto.getBaseUrl());
		permissionEntity.setDescription(dto.getDescription());
		permissionEntity.setMethod(dto.getMethod());
		permissionEntity.setPath(dto.getPath());
		
		permissionRepository.save(permissionEntity);
		
		return dto;
	}

	@Override
	public void deletePermissionById(Long id) {
		
		PermissionEntity permissionEntity= this.permissionRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Not Found Id"));

		permissionRepository.deleteById(id);
		
	}

	@Override
	public Page<IPermissionListDto> getAllUsers(String search, String pageNumber, String pageSize) {
		
		Pageable pagable=new Pagination().getPagination(pageNumber, pageSize);
		if((search=="")||(search==null)||(search.length()==0))
		{
			return permissionRepository.findByOrderById(pagable,IPermissionListDto.class);
		}
		else
		{
			return  permissionRepository.findByActionName(search,pagable,IPermissionListDto.class);
		}
	
	}
	
	
	
	
}
