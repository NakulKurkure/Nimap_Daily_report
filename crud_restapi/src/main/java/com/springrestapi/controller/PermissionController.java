package com.springrestapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.springrestapi.dto.PermissionDto;
import com.springrestapi.errordto.SuccessResponseDto;
import com.springrestapi.service.PermissionServiceInterface;

@RestController
@RequestMapping("/permission")
public class PermissionController {

	@Autowired
	private PermissionServiceInterface permissionServiceInterface;
	
//	@PreAuthorize("hasRole('addpermission')")
	@PostMapping
	public ResponseEntity<?> addpermission(@RequestBody PermissionDto permissionDto)
	{
		
		PermissionDto permissionDto1=permissionServiceInterface.addPermission(permissionDto);
		return new ResponseEntity<>(new SuccessResponseDto("Success", "Success", permissionDto1),HttpStatus.ACCEPTED);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> getById(@PathVariable Integer id)
	{
		
		return new ResponseEntity<>(new SuccessResponseDto("Success","Success",permissionServiceInterface.getById(id)),HttpStatus.OK);
	}
	
	
	@PutMapping("/{id}")
	public ResponseEntity<?> updatepermission(@RequestBody PermissionDto permissionDto,@PathVariable Integer id)
	{
		PermissionDto permissionDto1=permissionServiceInterface.updatePermission(permissionDto,id);
		return new ResponseEntity<>(new SuccessResponseDto("Success", "Success", permissionDto1),HttpStatus.OK);
		
	}
	
	@DeleteMapping("/{id}")
	public void deletePermission(@PathVariable Integer id)
	{
		permissionServiceInterface.delete(id);
	}
	
	
	@GetMapping
	public ResponseEntity<?> getAll(@RequestParam (defaultValue = "")String search,
			@RequestParam(defaultValue = "1") String pageNum ,@RequestParam (defaultValue = "5")String pageSize)
	{
		Page<?> entity=permissionServiceInterface.getProducts(search,pageNum,pageSize);
		if(entity.getTotalElements()!=0)
		{
			return new ResponseEntity<>(entity.getContent(),HttpStatus.ACCEPTED);
		}else
		{
			return  new ResponseEntity<>("failed",HttpStatus.NOT_FOUND);
		}
		
	}
	
	
}
