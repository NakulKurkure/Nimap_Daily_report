package com.job.controller;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

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
import com.job.entity.Job;
import com.job.exception.ResourceNotFoundException;
import com.job.serviceInterface.IListAllJobsDto;
import com.job.serviceInterface.IListJobDto;
import com.job.serviceInterface.JobServiceInterface;
import com.job.serviceInterface.UserServiceInterface;



@RestController
@RequestMapping("/api/job")
public class JobController {

	@Autowired
	private JobServiceInterface jobServiceInterface;
	
	//Only Recruiter:- Post a job, with the following fields - Job Title and Job Description 
	@PostMapping
	public ResponseEntity<?> addJobByRecuriter(@RequestBody JobDto jobDto,HttpServletRequest request)
	{
		
		try
		{

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
			Job job=jobServiceInterface.addJob(jobDto,request);
			
			return new ResponseEntity<>(new SuccessResponseDto("Success..", "SuccessFully Added Jobs"),HttpStatus.CREATED);
				
		}
		}catch(Exception e)
		{
			return new ResponseEntity<>(new ErrorResponseDto(e.getLocalizedMessage(),"Job Add Only By Recruiter.."),HttpStatus.BAD_REQUEST);
		}
		
	}
	
	
	// Only Admin :-Update a job, with the following fields - Job Title and Job Description 
	@PutMapping("/{id}")
	public ResponseEntity<?> updateJobById(@RequestBody JobDto jobDto,@PathVariable Long id,HttpServletRequest request)
	{
		try
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
			jobServiceInterface.updateJob(jobDto,id,request);
			
			return new ResponseEntity<>(new SuccessResponseDto("Success..", "SuccessFully Added Jobs"),HttpStatus.CREATED);
				
		}
		}
		catch(Exception e)
		{
			return new ResponseEntity<>(new ErrorResponseDto( "Not Valid..",e.getMessage()),HttpStatus.BAD_REQUEST);
	
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
	
	//Only Admin
	//Can remove specific jobs, candidate or recruiter accounts
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteByJobId(@PathVariable Long id,HttpServletRequest request)
	{
		try
		{
			jobServiceInterface.deleteByJobId(id,request);
			return new ResponseEntity<>(new SuccessResponseDto("Success..", "Succesfully Deleted job.."),HttpStatus.CREATED);

		}catch (Exception e) {
			return new ResponseEntity<>(new ErrorResponseDto(e.getMessage(), "Please Enter Valid JobId"),HttpStatus.NOT_FOUND);

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
	
	
	
	//getAllJobs By RecuriterId Using Only Recuriter Token
	@GetMapping("/getAllJobs")
	public ResponseEntity<?> getAllJobsByRecruiter(HttpServletRequest request)
	{
		try
		{
			
		List<IListAllJobsDto> jobs=jobServiceInterface.getAllJobsByRecruiter(request);
		return new ResponseEntity<>(new AuthSuccessDto("Success.", "Success..", jobs),HttpStatus.ACCEPTED);
		
		}catch(Exception e)
		{
			return new ResponseEntity<>(new ErrorResponseDto(e.getMessage(), "Only Recruiter access.."),HttpStatus.NOT_FOUND);	
		}
		
	}
	
		@GetMapping("/jobs/user")
		public ResponseEntity<?> getAllJobsByUser(HttpServletRequest request)
		{
			
			try
			{
				List<IListJobDto> jobs=	jobServiceInterface.getAllJobsByUser(request);
				return new ResponseEntity<>(new AuthSuccessDto("Success.", "Success..", jobs),HttpStatus.ACCEPTED);

				
			}catch(Exception e)
			{
				return new ResponseEntity<>(new ErrorResponseDto(e.getMessage(), "access.."),HttpStatus.NOT_FOUND);	

			}
			
			
			
		}
	
	

}