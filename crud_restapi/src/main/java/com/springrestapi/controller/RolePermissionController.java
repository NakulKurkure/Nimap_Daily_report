package com.springrestapi.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.exceptionsHandling.ResourceNotFoundException;
import com.springrestapi.entity.RolePermissionEntity;
import com.springrestapi.errordto.SuccessResponseDto;
import com.springrestapi.exception.Errordetails;
import com.springrestapi.payload.RolePermissionRequest;
import com.springrestapi.service.RolePermissionServiceInterface;

@RestController
@RequestMapping("/rolepermission")
public class RolePermissionController {

	@Autowired
	private RolePermissionServiceInterface rolePermissionServiceInterface;
	
//	@PreAuthorize('hasRole("")')
	@PostMapping
	private ResponseEntity<?> add(@RequestBody RolePermissionRequest rolePermissionRequest)
	{
		try
		{
			this.rolePermissionServiceInterface.add(rolePermissionRequest);
			return new ResponseEntity<>(new SuccessResponseDto("Success", "Success", rolePermissionRequest),HttpStatus.OK);
		}catch(Exception e)
		{
			return new ResponseEntity<>("failed",HttpStatus.NOT_FOUND);
		}
		
		
	}
	
	@GetMapping("/get")
	public List<RolePermissionEntity> getAll()
	{
		return rolePermissionServiceInterface.getAll();
	}
	
	@PutMapping
	public ResponseEntity<?> update(@RequestBody RolePermissionRequest rolePermissionRequest)
	{
		try
		{
			this.rolePermissionServiceInterface.updateRolePermission(rolePermissionRequest);
			return new ResponseEntity<>(new SuccessResponseDto("Success", "Success", rolePermissionRequest),HttpStatus.ACCEPTED);	
		}catch(Exception e)
		{
			return new ResponseEntity<>(new com.springrestapi.errordto.ResourceNotFoundException("Not Found"),HttpStatus.NOT_FOUND);	
		}
		
	}
	@DeleteMapping
	public ResponseEntity<?> delete(@RequestBody RolePermissionRequest rolePermissionRequest)
	{
		try
		{
			this.rolePermissionServiceInterface.deleteRolePermission(rolePermissionRequest);
			return new ResponseEntity<>(new SuccessResponseDto("Success", "Success", rolePermissionRequest),HttpStatus.ACCEPTED);
				
		}catch(Exception e)
		{
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> getPermissionById(@PathVariable int id)
	{
		ArrayList<String>tt= this.rolePermissionServiceInterface.getPermissionByUserId(id);
		return new ResponseEntity<>(tt,HttpStatus.OK);
	}
	
}
