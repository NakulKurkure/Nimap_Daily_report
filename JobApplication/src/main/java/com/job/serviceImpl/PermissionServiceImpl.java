package com.job.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.job.dto.PermissionDto;
import com.job.entity.Permission;
import com.job.exception.ResourceNotFoundException;
import com.job.repository.PermissionRepository;
import com.job.serviceInterface.IPermissionListDto;
import com.job.serviceInterface.PermissionServiceInterface;


@Service
public class PermissionServiceImpl implements PermissionServiceInterface{

	@Autowired
	private PermissionRepository permissionRepository;
	
	@Override
	public void addPermission(PermissionDto dto) {
		

		Permission permissionEntity = new Permission();
		permissionEntity.setActionName(dto.getActionName());
		permissionEntity.setBaseUrl(dto.getBaseUrl());
		permissionEntity.setDescription(dto.getDescription());
		permissionEntity.setMethod(dto.getMethod());
		permissionEntity.setPath(dto.getPath());
		permissionRepository.save(permissionEntity);
	}

	@Override
	public PermissionDto getPermissionById(Long id) {
		
		
		Permission permissionEntity= this.permissionRepository.findById(id).orElseThrow(()-> new com.job.exception.ResourceNotFoundException("Not Found Permission Id"));

		PermissionDto permissionDto=new PermissionDto();
		permissionDto.setActionName(permissionEntity.getActionName());
		permissionDto.setBaseUrl(permissionEntity.getBaseUrl());
		permissionDto.setDescription(permissionEntity.getDescription());
		permissionDto.setMethod(permissionEntity.getMethod());
		permissionDto.setPath(permissionEntity.getPath());

		return permissionDto;
		
	}

	@Override
	public void updatePermission(PermissionDto dto, Long id) {
		
		Permission permissionEntity= this.permissionRepository.findById(id).orElseThrow(()-> new com.job.exception.ResourceNotFoundException("Not Found Permission Id"));

		permissionEntity.setActionName(dto.getActionName());
		permissionEntity.setBaseUrl(dto.getBaseUrl());
		permissionEntity.setDescription(dto.getDescription());
		permissionEntity.setMethod(dto.getMethod());
		permissionEntity.setPath(dto.getPath());
		
		//
		permissionRepository.save(permissionEntity);
		
	}

	@Override
	public void deletePermissionById(Long id) {
	
	 permissionRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Not Found Permission Id"));
		
	 permissionRepository.deleteById(id);
		
	}

	@Override
	public Page<IPermissionListDto> getAllUsers(String search, String pageNumber, String pageSize) {
		Pageable pagable=new com.job.util.Pagination().getPagination(pageNumber, pageSize);
		if((search=="")||(search==null)||(search.length()==0))
		{
			return permissionRepository.findByOrderByPermissionId(pagable,IPermissionListDto.class);
		}
		else
		{
			return  permissionRepository.findByActionName(search,pagable,IPermissionListDto.class);
		}
	
	}

}
