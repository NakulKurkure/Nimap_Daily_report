package com.springrestapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springrestapi.dto.PermissionDto;
import com.springrestapi.errordto.SuccessResponseDto;
import com.springrestapi.service.PermissionServiceInterface;

@RestController
@RequestMapping("/permission")
public class PermissionController {

	@Autowired
	private PermissionServiceInterface permissionServiceInterface;
	
	@PostMapping
	public ResponseEntity<?> addpermission(@RequestBody PermissionDto permissionDto)
	{
		
		PermissionDto permissionDto1=permissionServiceInterface.addPermission(permissionDto);
		return new ResponseEntity<>(new SuccessResponseDto("Success", "Success", permissionDto1),HttpStatus.ACCEPTED);
	}
	
}
