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
import com.dto.PermissionDto;
import com.dto.SuccessDto;
import com.dto.SuccessResponseDto;
import com.serviceInterface.IPermissionListDto;
import com.serviceInterface.IUserListDto;
import com.serviceInterface.PermissionServiceInterface;



@RestController
@RequestMapping("/api/permission")
public class PermissionController {

	@Autowired
	private PermissionServiceInterface permissionServiceInterface;
	
	@PostMapping
	public ResponseEntity<?> addPermission(@RequestBody PermissionDto dto){
		
		try {
			
			
			
		this.permissionServiceInterface.addPermission(dto);
		
		return new ResponseEntity<>(new SuccessDto("Permission Added Successfully", "Permission Added"),HttpStatus.CREATED);
		
	}catch(Exception e) {
		return new ResponseEntity<>(new ErrorResponseDto("Permission Not Added, please check agian ","not Added"),HttpStatus.BAD_REQUEST);
	}
	}	
	
	@GetMapping("/{id}")
	public ResponseEntity<?> getPermissionById(@PathVariable("id") Long id){
		try {
		
	 PermissionDto permissionDto=this.permissionServiceInterface.getPermissionById(id);
		
		return new ResponseEntity<>(new AuthResponseDto("Success", "Success", permissionDto),HttpStatus.ACCEPTED);
		
	}catch(Exception e) {
		
		return new ResponseEntity<>(new ErrorResponseDto(e.getMessage()," User Id Not Found"),HttpStatus.NOT_FOUND);
	}
	
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<?> updatePermission(@PathVariable ("id")Long id,@RequestBody PermissionDto dto){
		try
		{			
		PermissionDto permissionEntity = this.permissionServiceInterface.updatePermission(dto, id);
		
		return new ResponseEntity<>(new AuthResponseDto("Permission Update Successfully","Permission Updated", permissionEntity),HttpStatus.OK);
		
	}catch(Exception e) {
		
		return new ResponseEntity<>(new ErrorResponseDto("Not Found Id..","Permission Not Found"),HttpStatus.NOT_FOUND);
	}
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?>deletePermission(@PathVariable(name = "id") Long id){
		try {
		permissionServiceInterface.deletePermissionById(id);
		
		return new ResponseEntity<>(new SuccessDto("Permission deleted Successfully","Permission deleted"),HttpStatus.OK);
		}
		catch (Exception e) {
		
			return new ResponseEntity<>(new ErrorResponseDto("Not Found Id..","Permission Id Not Found"),HttpStatus.NOT_FOUND);
		}
	}
	
	@GetMapping
	public ResponseEntity<?> getAllPermission(@RequestParam(defaultValue = "") String search,
			@RequestParam(defaultValue = "1") String pageNumber,
			@RequestParam(defaultValue = "5") String pageSize)
	
	{
	
		Page<IPermissionListDto> page=permissionServiceInterface.getAllUsers(search,pageNumber,pageSize);
		
		if(page.getTotalElements()!=0)
		{
			return new ResponseEntity<>(new SuccessResponseDto("Success", "Success", page.getContent()),HttpStatus.OK);
		}
		return new ResponseEntity<>(new ErrorResponseDto(" No Records Avaliable..", "Not Avaliable.."),HttpStatus.BAD_REQUEST);
		
	}
	
}
