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

import com.dto.ErrorDetailsDto;

import com.dto.RoleDto;
import com.dto.SuccessDto;
import com.dto.SuccessResponseDto;
import com.serviceInterface.IRoleListDto;
import com.serviceInterface.RoleServiceInterface;

@RestController
@RequestMapping("/api/role")
public class RoleController {

	@Autowired
	private RoleServiceInterface roleServiceInterface;
	
	@PostMapping
	public ResponseEntity<?> addRole(@RequestBody RoleDto roleDto)
	{
		
		roleServiceInterface.addRole(roleDto);
		return new ResponseEntity<>(new SuccessDto("Success", "SuccessFully Added Roles.."),HttpStatus.CREATED);
		
		
	}
	

	@GetMapping("/{id}")
	public ResponseEntity<?> getByRoleId(@PathVariable Long id)
	{

		try
		{
			RoleDto roleDto=this.roleServiceInterface.getByRoleId(id);
			return new ResponseEntity<>(new SuccessResponseDto("Success ", "Success", roleDto),HttpStatus.OK);
		}
		catch(Exception e)
		{
			return new ResponseEntity<>(new ErrorDetailsDto("Invalid RoleId..", "Invalid Id.."),HttpStatus.NOT_FOUND);
		}


	}
	
	
	@PutMapping("/{id}")
	public ResponseEntity<?> updateRoleById(@PathVariable Long id,@RequestBody RoleDto roleDto)
	{
		try
		{
			
			this.roleServiceInterface.updateRoleById(roleDto,id);

			return new ResponseEntity<>(new SuccessDto("Success", "SuccessFully Updated Roles.."),HttpStatus.OK);
		}catch(Exception e)
		{
			return new ResponseEntity<>(new ErrorDetailsDto("Invalid RoleId..", "Invalid"),HttpStatus.BAD_REQUEST);
		}

	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteRoleById(@PathVariable Long id)
	{
		try
		{
			this.roleServiceInterface.deleteRoleById(id);

			return new ResponseEntity<>(new SuccessDto("Success", "SuccessFully deleted Role.."),HttpStatus.OK);

		}catch(Exception e)
		{
			return new ResponseEntity<>(new ErrorDetailsDto("Invalid RoleId..", "Invalid"),HttpStatus.BAD_REQUEST);
		}


	}

	@GetMapping
	public ResponseEntity<?> getAllRoles(@RequestParam (defaultValue = "") String search,

			@RequestParam (defaultValue = "1") String pageNumber,@RequestParam (defaultValue = "5") String pageSize)
		{
		Page<IRoleListDto> page=roleServiceInterface.getAllRoles(search,pageNumber,pageSize);

		if(page.getTotalElements()!=0)
		{
			return new ResponseEntity<>(new SuccessResponseDto("Success", "Success", page.getContent()),HttpStatus.OK);
		}

		return new ResponseEntity<>(new ErrorDetailsDto("Not Avaliable Records", "Not Avaliable"),HttpStatus.NOT_FOUND);

	}

}
