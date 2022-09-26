package com.controller;

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

import com.dto.AuthResponseDto;
import com.dto.ErrorResponseDto;
import com.dto.RoleDto;
import com.dto.SuccessDto;
import com.serviceInterface.IRoleListDto;
import com.serviceInterface.RoleServiceInterface;

@RestController
@RequestMapping("/role")
public class RoleController {

	@Autowired
	private RoleServiceInterface roleServiceInterface;
	
	@PostMapping
	public ResponseEntity<?> addRole(@RequestBody RoleDto roleDto)
	{
		
		try
		{
			
		roleServiceInterface.addRole(roleDto);
		return new ResponseEntity<>(new SuccessDto("Success", "SuccessFully Added Roles.."),HttpStatus.OK);
		}catch(Exception e)
		{
			return new ResponseEntity<>(new ErrorResponseDto("Invalid UserId..", "Invalid Id.."),HttpStatus.NO_CONTENT);
		}
		
		
		
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> getById(@PathVariable Long id)
	{
		
		try
		{
			return new ResponseEntity<>(new AuthResponseDto("Success", "Success", this.roleServiceInterface.getById(id)),HttpStatus.OK); 
		}
		catch(Exception e)
		{
			return new ResponseEntity<>(new ErrorResponseDto("Invalid UserId..", "Invalid Id.."),HttpStatus.NO_CONTENT);
		}
		
		
	}
	
	
	@PutMapping("/{id}")
	public ResponseEntity<?> updateRoleById(@RequestBody RoleDto roleDto,@PathVariable Long id)
	{
		
		try
		{
			
		
		RoleDto roleDto1=this.roleServiceInterface.updateRole(roleDto,id);
		
		return new ResponseEntity<>(new AuthResponseDto("Success", "SuccessFully Updated..",roleDto1 ),HttpStatus.OK);
		}catch(Exception e)
		{
			return new ResponseEntity<>(new ErrorResponseDto("Invalid UserId..", "Invalid"),HttpStatus.NOT_FOUND);
		}
		
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteRoleById(@PathVariable Long id)
	{
		try
		{
			this.roleServiceInterface.deleteRole(id);
			
			return new ResponseEntity<>(new SuccessDto("Success", "SuccessFully deleted Role.."),HttpStatus.OK);
	
		}catch(Exception e)
		{
			return new ResponseEntity<>(new ErrorResponseDto("Invalid UserId..", "Invalid"),HttpStatus.NOT_FOUND);
		}
		
		
	}
	
	
	@GetMapping
	public ResponseEntity<?> getAllRoles(@RequestParam (defaultValue = "") String search,
	
			@RequestParam (defaultValue = "1") String pageNumber,@RequestParam (defaultValue = "5") String pageSize)
	{
		Page<IRoleListDto> page=roleServiceInterface.getAllRoles(search,pageNumber,pageSize);
		
		if(page.getTotalElements()!=0)
		{
			return new ResponseEntity<>(new AuthResponseDto("Success", "Success", page.getContent()),HttpStatus.OK);
		}
	
		return new ResponseEntity<>(new ErrorResponseDto("Not Avaliable Records", "Not Avaliable"),HttpStatus.NOT_FOUND);
		
	}
	
	
	
	
}
