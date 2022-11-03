package com.job.controller;

import javax.validation.Valid;

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
import com.job.dto.RoleDataDto;
import com.job.dto.RoleDto;
import com.job.dto.SuccessResponseDto;
import com.job.serviceInterface.RoleServiceInterface;

@RestController
@RequestMapping("/api/role")

public class RoleController {

	@Autowired
	private RoleServiceInterface roleServiceInterface;
	
	@PostMapping
	public ResponseEntity<?> addRole(@RequestBody RoleDto roleDto)
	{
		
		if(roleDto.getRoleName().isBlank())
		{
			if(roleDto.getDescription().isBlank())
			{
				return new ResponseEntity<>(new ErrorResponseDto("Enter Valid Description..", "Please Enter Valid Description..."),HttpStatus.BAD_REQUEST);

			}
				return new ResponseEntity<>(new ErrorResponseDto("Enter RoleName ..", "Please Enter Valid RoleName"),HttpStatus.BAD_REQUEST);

		
				
		}else
		{
			roleServiceInterface.addRole(roleDto);
			
			return new ResponseEntity<>(new SuccessResponseDto("Success..", "SuccessFully added Roles..."),HttpStatus.CREATED);	
		}
		
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<?> updatedRoleById(@RequestBody RoleDto roleDto,@PathVariable Long id)
	{
		try
		{
//			
			if(roleDto.getRoleName().isBlank())
			{
				if(roleDto.getDescription().isEmpty())
				{
					return new ResponseEntity<>(new ErrorResponseDto("Enter Description..", "Enter Valid Description..."),HttpStatus.BAD_REQUEST);
				}
				else
				{
					return new ResponseEntity<>(new ErrorResponseDto("Enter RoleName..", "please Enter Valid RoleName..."),HttpStatus.BAD_REQUEST);

				}
			}
			else
			{
				roleServiceInterface.updateRoleById(roleDto,id);
				return new ResponseEntity<>(new SuccessResponseDto("Success..","SuccessFully Updated Roles..."),HttpStatus.ACCEPTED);		
			}
				
			
			
		}
		catch(Exception e)
		{
			return new ResponseEntity<>(new ErrorResponseDto("Not Found RoleId.. ", "Enter Valid RoleId"),HttpStatus.BAD_REQUEST);
		}
		
		
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> getRoleById(@PathVariable Long id)
	{
		try
		{
			RoleDataDto role=roleServiceInterface.getRole(id);
			return new ResponseEntity<>(new AuthSuccessDto("Success..","SuccessFully Updated Roles...",role),HttpStatus.ACCEPTED);	
		}
		catch(Exception e)
		{
			return new ResponseEntity<>(new ErrorResponseDto("Not Found RoleId.. ", "Enter Valid RoleId"),HttpStatus.BAD_REQUEST);
		}
		
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteRoleById(@PathVariable Long id)
	{
		
		try
		{
			roleServiceInterface.deleteRoleById(id);
			return new ResponseEntity<>(new SuccessResponseDto("Success..", "SuccessFully Deleted Roles..."),HttpStatus.ACCEPTED);
		}catch(Exception e)
		{
			return new ResponseEntity<>(new ErrorResponseDto("Not Found RoleId..", "Not Found RoleId..."),HttpStatus.ACCEPTED);
		}
		
		
	}
	
	@GetMapping
	public ResponseEntity<?> getAllRoles(@RequestParam(defaultValue = "") String search,
			@RequestParam(defaultValue = "1") String pageNumber,
			@RequestParam(defaultValue = "5") String pageSize)

	{

		Page<com.job.serviceInterface.IRoleListDto> page=roleServiceInterface.getAllRoles(search,pageNumber,pageSize);
			
		if(page.getTotalElements()!=0)
		{
			return new ResponseEntity<>(new AuthSuccessDto("Success", "Success", page.getContent()),HttpStatus.OK);
		}
		return new ResponseEntity<>(new ErrorResponseDto("No Records Avaliable..", "Not Avaliable.."),HttpStatus.BAD_REQUEST);

	}
	
	
}
