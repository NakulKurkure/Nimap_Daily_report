package com.springrestapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.springrestapi.dto.RoleDto;

import com.springrestapi.errordto.SuccessResponseDto;
import com.springrestapi.repo.RoleRepo;
import com.springrestapi.service.RoleServiceInterface;


@RestController
@RequestMapping("/role")

public class RoleController {

	@Autowired
	private RoleServiceInterface roleServiceInterface;
	
	@Autowired
	private RoleRepo roleRepo;
	
	
	@PostMapping
	public ResponseEntity<?> addrole(@RequestBody RoleDto roleDto)
	{
		RoleDto roleDto1=this.roleServiceInterface.addrole(roleDto);
		return new ResponseEntity<>(new SuccessResponseDto("Success", "Success", roleDto1),HttpStatus.ACCEPTED);
		
		
	}
	
	@GetMapping
	public ResponseEntity<?> getAll(@RequestParam (defaultValue = "") String serach,
			@RequestParam (defaultValue = "1" ) String pageNum, @RequestParam (defaultValue = "5") String pageSize)
	{
		Page<?> entity= this.roleServiceInterface.getProducts(serach,pageNum,pageSize);
		if(entity.getTotalElements()!=0)
		{
			return new ResponseEntity<>(entity.getContent(),HttpStatus.ACCEPTED);
		}
		return new ResponseEntity<>("fail",HttpStatus.NOT_FOUND);
	}
	
	
	@GetMapping("/{id}")
	public ResponseEntity<?> getById(@PathVariable Integer id)
	{
		return new ResponseEntity<>(new SuccessResponseDto("Success","Success",roleServiceInterface.getById(id)),HttpStatus.OK);
	}
	
	@PutMapping
	public ResponseEntity<?> update(@RequestBody RoleDto roleDto,@PathVariable Integer id)
	{
		
		 RoleDto roleDto1=this.roleServiceInterface.update(roleDto,id);
		 return new ResponseEntity<>(new SuccessResponseDto("Success","Success", roleDto1),HttpStatus.ACCEPTED);
	}
	
	@DeleteMapping("/{id}")
	public void delete(@PathVariable Integer id)
	
	{
		this.roleServiceInterface.delete(id);
	}
}
