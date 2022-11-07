package com.job.serviceImpl;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.job.dto.UserJobRequestDto;
import com.job.entity.Job;
import com.job.entity.Role;
import com.job.entity.User;
import com.job.entity.UserJob;
import com.job.entity.UserJobId;
import com.job.entity.UserRole;
import com.job.exception.ResourceNotFoundException;
import com.job.repository.JobRespository;
import com.job.repository.RoleRepository;
import com.job.repository.UserJobRepository;
import com.job.repository.UserRepository;
import com.job.repository.UserRoleRepository;
import com.job.serviceInterface.EmailServiceInterface;
import com.job.serviceInterface.UserJobServiceInterface;

@Service
public class UserJobServiceImpl implements UserJobServiceInterface{

	@Autowired
	private JobRespository jobRespository;
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private UserJobRepository userJobRepository;
	
	@Autowired
	private JavaMailSender javaMailSender;
	
	@Autowired
	private  UserRoleRepository userRoleRepository;
	
	@Autowired
	private EmailServiceInterface emailServiceInterface;
	
	@Autowired
	private RoleRepository roleRepository;
	
	
	@Override
	public void addUserJob(UserJobRequestDto userJobRequestDto) {
	
	
		ArrayList<UserJob> userJobs = new ArrayList<>();

		User user_id=this.userRepository.findById(userJobRequestDto.getUserId()).orElseThrow(()-> new com.job.exception.ResourceNotFoundException("Not Found UserId"));

		Job jobId=jobRespository.findById(userJobRequestDto.getJobId()).orElseThrow(()-> new com.job.exception.ResourceNotFoundException("Not Found JobId"));
		
		UserJob userJob=new UserJob();
		UserJobId userJobId=new UserJobId(user_id,jobId);
		userJob.setPk(userJobId);
		System.out.println("UserJobId"+userJobId);
		userJobs.add(userJob);
		userJobRepository.saveAll(userJobs);
		
		
		System.out.println("UserRole122222"+userRoleRepository.findByUserById(user_id.getUserId().longValue()));
		UserRole userRole=  this.userRoleRepository.findByUserById(user_id.getUserId()).orElseThrow(()-> new ResourceNotFoundException("Not Found UserId.."));
		System.out.println("UserRole11111"+userRoleRepository.findByUserById(user_id.getUserId()));
//		UserRole userRole2= userRoleRepository.findByRoleId(userRole.getPk().getRole().getRoleId()).orElseThrow(()-> new ResourceNotFoundException("Not Found Job Id.."));
		System.out.println("RoleId"+userRole.getPk().getRole().getRoleId());
		Long RoleId=userRole.getPk().getRole().getRoleId();
		System.out.println("RoleId"+userRole.getPk().getRole().getRoleName());

		String role=userRole.getPk().getRole().getRoleName();
//		System.out.println("UserRole"+userRole2);
		
		
//		Role role= roleRepository.findByRoleName(userRole2).orElseThrow(()-> new ResourceNotFoundException("Not Found RoleName..."));
		
		if(role.equals("Candidate"))
		{
			this.emailServiceInterface.sendMessage(user_id.getEmail(),"subject",jobId.getJobTitle());	
			
		}
			
//		if(role.getRoleName().equals("Recruiter"))
//			{
//				this.emailServiceInterface.sendMessage(userId.getEmail(),"subject",jobId.getJobTitle());	
//
//			}
		else
		{
			throw new ResourceNotFoundException("Not Found Candidate and Recruiter");	
		}
		
		
		
		
		
		
	}
		
}
	


