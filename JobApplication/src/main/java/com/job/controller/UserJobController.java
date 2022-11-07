package com.job.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.job.dto.ErrorResponseDto;
import com.job.dto.SuccessResponseDto;
import com.job.dto.UserJobRequestDto;
import com.job.serviceInterface.UserJobServiceInterface;

@RestController
@RequestMapping("/api/userjob")
public class UserJobController {
	@Autowired
	private UserJobServiceInterface userJobServiceInterface;
	
	@PostMapping
	public ResponseEntity<?> addUserJob(@RequestBody UserJobRequestDto userJobRequestDto)
	{
	
		try
		{
			
		
			userJobServiceInterface.addUserJob(userJobRequestDto);
			
			return new ResponseEntity<>(new SuccessResponseDto("Success..", "SuccessFully Added UserRoles.."),HttpStatus.CREATED);	
		}
		catch(Exception e)
		{
			return new ResponseEntity<>(new ErrorResponseDto(e.getMessage(),e.getLocalizedMessage()),HttpStatus.CREATED);	

		}
	}	
}
