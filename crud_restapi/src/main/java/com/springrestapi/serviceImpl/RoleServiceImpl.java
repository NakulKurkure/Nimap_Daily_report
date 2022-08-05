package com.springrestapi.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.app.exceptionsHandling.ResourceNotFoundException;
import com.springrestapi.dto.RoleDto;
import com.springrestapi.entity.RoleEntity;
import com.springrestapi.exception.Errordetails;
import com.springrestapi.exception.ResourseNotFoundException;
import com.springrestapi.page.pagination;
import com.springrestapi.repo.RoleRepo;
import com.springrestapi.service.RoleServiceInterface;

@Service
public class RoleServiceImpl implements RoleServiceInterface{

	@Autowired
	private ModelMapper modelMapper;
	
	@Autowired
	private RoleRepo roleRepo;
	
	public RoleDto addrole(RoleDto roleDto) {
		// TODO Auto-generated method stub
		
		RoleEntity roleEntity=this.dtoToRole(roleDto);
		RoleEntity updateRole=this.roleRepo.save(roleEntity);
		return this.roleToDto(updateRole);
	}
	
	public RoleEntity getById(Integer id) {
		
		
		return this.roleRepo.findById(id).get();
	}

	
	public RoleEntity dtoToRole(RoleDto roleDto)
	{
		RoleEntity role=this.modelMapper.map(roleDto, RoleEntity.class);
		return role;
	}
	
	
	public RoleDto roleToDto(RoleEntity roleEntity)
	{
		RoleDto roleDto1=this.modelMapper.map(roleEntity,RoleDto.class);
		return roleDto1;
	}

	public RoleDto update(RoleDto roleDto, Integer id) {
		
		
		RoleEntity roleEntity=this.roleRepo.findById(id).orElseThrow(()->new ResourseNotFoundException("Not found"));
		roleEntity.setRoleName(roleDto.getRoleName());
		
		RoleEntity role=this.roleRepo.save(roleEntity);
		
		return this.modelMapper.map(role, RoleDto.class);
	}

	@Override
	public void delete(Integer id) {
		// TODO Auto-generated method stub
		
		this.roleRepo.deleteById(id);
		
	}


	public Page<?> getProducts(String search,String pageNum, String pageSize) {
		
	Pageable pageable=new pagination().getPagination(pageNum, pageSize);
	
	if((search=="" )||(search==null)||(search.length()==0) )
		
	{
		return this.roleRepo.findAll(pageable);
	}
	else
	{
		return this.roleRepo.findByRoleName(search,pageable,RoleEntity.class);
	}
		
		
	}




	
}
