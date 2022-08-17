package com.springrestapi.serviceImpl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springrestapi.dto.PermissionDto;
import com.springrestapi.entity.PermissionEntity;
import com.springrestapi.repo.PermissionRepo;
import com.springrestapi.service.PermissionServiceInterface;

@Service
public class PermissionServiceImpl implements PermissionServiceInterface{

	@Autowired
	private ModelMapper modelMapper;
	
	@Autowired
	private PermissionDto permissionDto;
	
	@Autowired
	private PermissionRepo permissionRepo;
	@Override
	public PermissionDto addPermission(PermissionDto permissionDto) {
		
		PermissionEntity permissionEntity=this.dtoToUser(permissionDto);
		PermissionEntity permissionEntity2=this.permissionRepo.save(permissionEntity);
		return this.userToDto(permissionEntity2);
	}

	

	private PermissionEntity dtoToUser(PermissionDto permissionDto) {
		
		PermissionEntity permissionEntity= this.modelMapper.map(permissionDto,PermissionEntity.class);
		return permissionEntity;
	}
	
	private PermissionDto userToDto(PermissionEntity permissionEntity) {
		
		PermissionDto permissiondto=this.modelMapper.map(permissionEntity, PermissionDto.class);
		
		return permissiondto;
	}

	
	
}
