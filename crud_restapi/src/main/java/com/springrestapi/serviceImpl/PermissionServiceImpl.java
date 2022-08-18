package com.springrestapi.serviceImpl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.app.exceptionsHandling.ResourceNotFoundException;
import com.springrestapi.dto.PermissionDto;
import com.springrestapi.entity.PermissionEntity;
import com.springrestapi.entity.RoleEntity;
import com.springrestapi.page.pagination;
import com.springrestapi.repo.PermissionRepo;
import com.springrestapi.service.PermissionServiceInterface;

@Service
public class PermissionServiceImpl implements PermissionServiceInterface{

	@Autowired
	private ModelMapper modelMapper;
	
	
//	@Autowired
//	private PermissionDto permissionDto;
	
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



	@Override
	public PermissionDto updatePermission(PermissionDto permissionDto,Integer id) {
		
		PermissionEntity permissionEntity=this.permissionRepo.findById(id).get();
		permissionEntity.setActionName(permissionDto.getActionName());
		permissionEntity.setBaseUrl(permissionDto.getBaseUrl());
		permissionEntity.setPath(permissionDto.getPath());
		permissionEntity.setMethod(permissionDto.getMethod());
		
		PermissionEntity entity=this.permissionRepo.save(permissionEntity);
		
		return this.modelMapper.map(entity, PermissionDto.class);
	}



	@Override
	public void delete(Integer id) {

		this.permissionRepo.deleteById(id);
	}



	@Override
	public PermissionEntity getById(Integer id) {
		// TODO Auto-generated method stub
		return this.permissionRepo.findById(id).get();
	}

	

	@Override
	public Page<?> getProducts(String search, String pageNum, String pageSize) {
		// TODO Auto-generated method stub
		Pageable pageable =new pagination().getPagination(pageNum, pageSize);
		if((search=="" )||(search==null)||(search.length()==0) )
			
		{
			return this.permissionRepo.findAll(pageable);
		}
		else
		{
			return this.permissionRepo.findByActionName(search,pageable,PermissionEntity.class);
		}
		
		
	}
	
	
}
