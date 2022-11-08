package com.job.serviceImpl;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.job.dto.UserJobRequestDto;
import com.job.entity.Job;
import com.job.entity.Role;
import com.job.entity.User;
import com.job.entity.UserJob;
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
	private UserRepository userRepository;

	@Autowired
	private RoleRepository roleRepository;
	
	@Autowired
	private  UserRoleRepository userRoleRepository;
	
	@Autowired
	private JobRespository jobRespository;
	
	@Autowired
	private EmailServiceInterface emailServiceInterface;
	

	@Autowired
	private UserJobRepository userJobRepository;
	
	@Override
	public void addUserJob(UserJobRequestDto userJobRequestDto) {
	
	
		User user=userRepository.findById(userJobRequestDto.getUserId()).orElseThrow(()-> new ResourceNotFoundException("Not Found UserId"));
		

		
		ArrayList<Job> userJobs = new ArrayList<>();

		for(int i=0;i<userJobRequestDto.getJobId().size();i++)
		{
			
			Long JobId=userJobRequestDto.getJobId().get(i);
			System.out.println("JobId"+JobId);
			Job job=jobRespository.findById(JobId).orElseThrow(()-> new ResourceNotFoundException("Not Found Job Id"));
		
			System.out.println("Id");
			List<UserRole> userRole=userRoleRepository.findByUserId(user.getUserId());
			System.err.println("UserRole..."+userRole);
			
			userJobs.add(job);
			UserJob userJob=new UserJob();
			userJob.setJob(job);
			userJob.setUser(user);
			userJobRepository.save(userJob);
			
			System.out.println("Size"+userRole.size());
	
			
			UserRole role=userRole.get(i);
			
			Long Id=role.getPk().getRole().getRoleId();
			for(int i1=0;i1<Id;i1++)
			{

				System.out.println("Role"+Id.SIZE);
				
			}
			String roleName=role.getPk().getRole().getRoleName();
			System.out.println("RoleName"+roleName);
			if(roleName.equals("Candidate"))
			{
				emailServiceInterface.sendMessage(user.getEmail(), "Candidate Apply sucessfully To Job", job.getJobTitle());
				
			}
			
			
			List<Role> roles=roleRepository.findAll();
			System.out.println("Roles"+roles);
			String roless=roles.get(i).getRoleName();
			
			if(roless.equals("Recruiter"))
			{
				
				
				emailServiceInterface.sendMessage(user.getEmail(), "Candidate Apply sucessfully To Job", job.getJobTitle());

			}
		
			
		}
		
	
		
		
		
	}
		
}
	


