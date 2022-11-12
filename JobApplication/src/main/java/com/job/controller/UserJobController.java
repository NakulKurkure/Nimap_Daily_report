package com.job.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.job.dto.AuthSuccessDto;
import com.job.dto.ErrorResponseDto;
import com.job.dto.SuccessResponseDto;
import com.job.dto.UserJobRequestDto;
import com.job.serviceInterface.IListUserListDto;
import com.job.serviceInterface.IUserJobListDto;
import com.job.serviceInterface.UserJobServiceInterface;

@RestController
@RequestMapping("/api/userjob")
public class UserJobController {
	@Autowired
	private UserJobServiceInterface userJobServiceInterface;
	
//	@PreAuthorize("hasRole('userJobAdd')")
	@PostMapping
	
	public ResponseEntity<?> addUserJob(@RequestBody UserJobRequestDto userJobRequestDto,HttpServletRequest request)
	{
		try
		{
			
			userJobServiceInterface.addUserJob(userJobRequestDto,request);
			
			return new ResponseEntity<>(new SuccessResponseDto("Success..", "SuccessFully Added UserJobs.."),HttpStatus.CREATED);	
		}
		catch(Exception e)
		{
			return new ResponseEntity<>(new ErrorResponseDto(e.getMessage(),e.getLocalizedMessage()),HttpStatus.BAD_REQUEST);	

		}
	}	
	
	
	@GetMapping
	public ResponseEntity<?> getAllUserJob(
			@RequestParam(defaultValue = "") String search,
			@RequestParam(defaultValue = "1") String pageNumber,
			@RequestParam(defaultValue = "5") String pageSize,HttpServletRequest request)
	{
		try
		{
			
		
		
		Page<IListUserListDto> page= userJobServiceInterface.getAllUserJobs(search,pageNumber,pageSize,request);
		if(page.getTotalElements()!=0)
		{
			return new ResponseEntity<>(new AuthSuccessDto("Success", "Success", page.getContent()),HttpStatus.ACCEPTED);
		}
		else
		{
			return new ResponseEntity<>(new ErrorResponseDto("Records Not Available..", "No Records Available..."),HttpStatus.NOT_FOUND);
	    }
		
		}catch(Exception e)
		{
			return new ResponseEntity<>(new ErrorResponseDto(e.getMessage(), e.getLocalizedMessage()),HttpStatus.NOT_FOUND);

		}
	}
}
