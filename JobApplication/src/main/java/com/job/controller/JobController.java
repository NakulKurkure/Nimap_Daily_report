package com.job.controller;

import java.util.Date;
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
import com.job.dto.JobDto;
import com.job.dto.SuccessResponseDto;
import com.job.exception.ResourceNotFoundException;
import com.job.serviceInterface.IListJobDto;
import com.job.serviceInterface.JobServiceInterface;



@RestController
@RequestMapping("/api/job")
public class JobController {

	@Autowired
	private JobServiceInterface jobServiceInterface;
	
	
	@PostMapping
	public ResponseEntity<?> addJobByRecuriter(@RequestBody JobDto jobDto)
	{
		
		Date date=new Date();
		
		if(jobDto.getJobTitle().isBlank())
				{
			if(jobDto.getJobDescription().isEmpty())
			{
			 return new ResponseEntity<>(new ErrorResponseDto("Enter Valid Job Description..", "Please Enter Valid Job Description..."),HttpStatus.BAD_REQUEST);
			}else
			{
				 return new ResponseEntity<>(new ErrorResponseDto("Enter Valid Job Title..", "Please Enter Valid Job Title..."),HttpStatus.BAD_REQUEST);

			}
		}else
		{
			jobServiceInterface.addJob(jobDto);
			
			return new ResponseEntity<>(new SuccessResponseDto("Success..", "SuccessFully Added Jobs"),HttpStatus.CREATED);
				
		}
		
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<?> updateJobById(@RequestBody JobDto jobDto,@PathVariable Long id)
	{
		
		if(jobDto.getJobTitle().isBlank())
			{
			if(jobDto.getJobDescription().isEmpty())
			{
			 return new ResponseEntity<>(new ErrorResponseDto("Enter Valid Job Title..", "Please Enter Valid Job Title..."),HttpStatus.BAD_REQUEST);
			}else
			{
				 return new ResponseEntity<>(new ErrorResponseDto("Enter Valid Job Description..", "Please Enter Valid Job Description..."),HttpStatus.BAD_REQUEST);

			}
		}else
		{
			jobServiceInterface.updateJob(jobDto,id);
			
			return new ResponseEntity<>(new SuccessResponseDto("Success..", "SuccessFully Added Jobs"),HttpStatus.CREATED);
				
		}
		
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> getJobById(@PathVariable Long id){
		try
		{
			System.out.println("Id"+id);
			List<IListJobDto> list= jobServiceInterface.getJobById(id);
			return new ResponseEntity<>(new AuthSuccessDto("Success", "Success", list),HttpStatus.ACCEPTED);	
		}catch(Exception e)
		{
			return new ResponseEntity<>(new ErrorResponseDto("Invalid..", "Please Enter Valid JobId.."),HttpStatus.NOT_FOUND);

		}
		
		
	}
	
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteByJobId(@PathVariable Long id)
	{
		try
		{
			jobServiceInterface.deleteByJobId(id);
			return new ResponseEntity<>(new SuccessResponseDto("Success..", "Succesfully Deleted job.."),HttpStatus.CREATED);

		}catch (Exception e) {
			return new ResponseEntity<>(new ErrorResponseDto("Invalid..", "Please Enter Valid JobId"),HttpStatus.NOT_FOUND);

		}
		
		
		
	}
	
	@GetMapping
	public ResponseEntity<?> getAllJobs(
			@RequestParam(defaultValue = "") String search,@RequestParam (defaultValue = "1") String pageNumber,
			@RequestParam(defaultValue = "5") String pageSize
			)
	{
		
		Page<IListJobDto> page= jobServiceInterface.getAllJobs(search,pageNumber,pageSize);
		if(page.getTotalElements()!=0)
		{
			return new ResponseEntity<>(new AuthSuccessDto("Success", "Success", page.getContent()),HttpStatus.OK);
		}
		return new ResponseEntity<>(new ErrorResponseDto(" No Records Avaliable..", "Not Avaliable.."),HttpStatus.BAD_REQUEST);

		
	}
	
	
	
	
	
	
	
	
}