package com.job.controller;

import java.util.ArrayList;
import java.util.List;

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

import com.job.dto.AuthSuccessDto;
import com.job.dto.ErrorResponseDto;
import com.job.dto.RolePermissionRequestDto;
import com.job.dto.SuccessResponseDto;
import com.job.serviceInterface.IListRoleDto;
import com.job.serviceInterface.IUserJobListDto;
import com.job.serviceInterface.RolePermissionServiceInterface;

@RestController
@RequestMapping("/api/rolepermission")
public class RolePermissionController {

	@Autowired
	private RolePermissionServiceInterface rolePermissionServiceInterface;
	
	@PostMapping
	private ResponseEntity<?> addRolePermission(@RequestBody RolePermissionRequestDto rolePermissionRequestDto)
	{
		try
		{
			this.rolePermissionServiceInterface.addRolePermission(rolePermissionRequestDto);
			return new ResponseEntity<>(new SuccessResponseDto("Added Successfully.. ","Role and Permission Added Successfully.."),HttpStatus.OK);		}catch(Exception e)
		{
			return new ResponseEntity<>(new ErrorResponseDto("Not Added ", "Not Added.."),HttpStatus.NOT_FOUND);
		}


	}

	@PutMapping
	public ResponseEntity<?> update(@RequestBody RolePermissionRequestDto rolePermissionRequestDto)
	{
		try
		{
			this.rolePermissionServiceInterface.updateRolePermission(rolePermissionRequestDto);
			return new ResponseEntity<>(new SuccessResponseDto("Success ", "SuccessFully Updated Roles and Permissions.."),HttpStatus.ACCEPTED);
		}catch(Exception e)
		{
			return new ResponseEntity<>(new ErrorResponseDto("Not Found RoleId..  ", "Not Found PermissionId.."),HttpStatus.NOT_FOUND);
		}

	}

	@DeleteMapping
	public ResponseEntity<?> delete(@RequestBody RolePermissionRequestDto rolePermissionRequestDto)
	{
		try
		{
			this.rolePermissionServiceInterface.deleteRolePermission(rolePermissionRequestDto);
			return new ResponseEntity<>(new SuccessResponseDto("Success ", "SuccessFully Deleted Roles and Permissions.."),HttpStatus.ACCEPTED);

		}catch(Exception e)
		{
			return new ResponseEntity<>(new ErrorResponseDto("Not Found RoleId..  ", "Not Found PermissionId.."),HttpStatus.NOT_FOUND);

		}

	}

	@GetMapping
	public ResponseEntity<?> getAllRolePermission(
			@RequestParam(defaultValue = "") String search,
			@RequestParam(defaultValue = "1") String pageNumber,
			@RequestParam(defaultValue = "5") String pageSize)
	{
		
		Page<IListRoleDto> page= rolePermissionServiceInterface.getAllRolePermission(search,pageNumber,pageSize);
		if(page.getTotalElements()!=0)
		{
			return new ResponseEntity<>(new AuthSuccessDto("Success", "Success", page.getContent()),HttpStatus.ACCEPTED);
		}
		else
		{
			return new ResponseEntity<>(new ErrorResponseDto("Records Not Available..", "No Records Available..."),HttpStatus.NOT_FOUND);
	    }
	}

	@GetMapping("/permissions/user/{id}")
	public ResponseEntity<?> getPermissionById(@PathVariable Long id)
	{
		ArrayList<String>tt= this.rolePermissionServiceInterface.getPermissionByUserId(id);
	
		return new ResponseEntity<>(tt,HttpStatus.OK);
	}
	
}
