package com.job.controller;

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
import com.job.dto.PermissionDto;
import com.job.dto.SuccessResponseDto;
import com.job.serviceInterface.IPermissionListDto;


@RestController
@RequestMapping("/api/permission")
public class PermissionController {

	@Autowired
	private com.job.serviceInterface.PermissionServiceInterface permissionServiceInterface;
	
	@PostMapping
	public ResponseEntity<?> addPermission(@RequestBody com.job.dto.PermissionDto dto){

		try {

			
			if(dto.getActionName().isBlank())
			{
				
				if(dto.getBaseUrl().isBlank())
				{
					return new ResponseEntity<>(new ErrorResponseDto("Enter Valid BaseUrl and ActionName..", "Please Enter Valid BaseUrl and ActionName..."),HttpStatus.BAD_REQUEST);
				}else
				{
					return new ResponseEntity<>(new ErrorResponseDto("Enter Valid ActionName", "Please Enter Valid ActionName.."),HttpStatus.BAD_REQUEST);

				}
				
			}else
			{
				this.permissionServiceInterface.addPermission(dto);

				return new ResponseEntity<>(new SuccessResponseDto("Permission Added Successfully", "Permission Added"),HttpStatus.CREATED);		
			}
			
		

	}catch(Exception e) {
		return new ResponseEntity<>(new ErrorResponseDto("Permission Not Added, please check agian ","not Added"),HttpStatus.BAD_REQUEST);
	}
	}

	@GetMapping("/{id}")
	public ResponseEntity<?> getPermissionById(@PathVariable("id") Long id){
		try {

	 PermissionDto permissionDto=this.permissionServiceInterface.getPermissionById(id);

		return new ResponseEntity<>(new AuthSuccessDto("Success", "Success", permissionDto),HttpStatus.ACCEPTED);

	}catch(Exception e) {

		return new ResponseEntity<>(new ErrorResponseDto(e.getMessage()," User Id Not Found"),HttpStatus.NOT_FOUND);
	}

	}

	@PutMapping("/{id}")
	public ResponseEntity<?> updatePermission(@PathVariable ("id")Long id,@RequestBody PermissionDto dto){
		
		
		try
		{
		this.permissionServiceInterface.updatePermission(dto, id);

		return new ResponseEntity<>(new SuccessResponseDto("Permission Update Successfully","Permission Updated"),HttpStatus.OK);

	}catch(Exception e) {

		return new ResponseEntity<>(new ErrorResponseDto("Not Found Id..","Permission Not Found"),HttpStatus.NOT_FOUND);
	}
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<?>deletePermission(@PathVariable(name = "id") Long id){
			
		try {
		permissionServiceInterface.deletePermissionById(id);

		return new ResponseEntity<>(new SuccessResponseDto("Permission deleted Successfully","Permission deleted"),HttpStatus.OK);
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
		
		Page<IPermissionListDto> page=permissionServiceInterface.getAllpermission(search,pageNumber,pageSize);

		if(page.getTotalElements()!=0)
		{
			return new ResponseEntity<>(new AuthSuccessDto("Success", "Success", page.getContent()),HttpStatus.OK);
		}
		return new ResponseEntity<>(new ErrorResponseDto(" No Records Avaliable..", "Not Avaliable.."),HttpStatus.BAD_REQUEST);

	}

	

}
