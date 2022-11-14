package com.job.serviceImpl;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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
import com.job.security.JwtTokenUtil;
import com.job.serviceInterface.EmailServiceInterface;
import com.job.serviceInterface.IListUserListDto;
import com.job.serviceInterface.IUserJobListDto;
import com.job.serviceInterface.UserJobServiceInterface;
import com.job.util.Pagination;

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
			
	@Autowired
	private JwtTokenUtil jwtTokenUtil;
			 	
	@Override
	public void addUserJob(UserJobRequestDto userJobRequestDto, HttpServletRequest request) {
				
//		User user=userRepository.findById(userJobRequestDto.getUserId()).orElseThrow(()-> new ResourceNotFoundException("Not Found UserId"));
				
		final String header=request.getHeader("Authorization");
		String requestToken=header.substring(7);
//		//email	
		final String email3=jwtTokenUtil.getUsernameFromToken(requestToken);
				
//		//check on repo.
		User user=userRepository.findByEmailContainingIgnoreCase(email3);
				
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
			

		
			System.out.println("JobId"+JobId);

			Job job1=jobRespository.findById(JobId).orElseThrow(()-> new ResourceNotFoundException("Not Found Job Id"));
			
			Role recruiterId= job1.getRecruiterId();
			
			System.out.println("Role"+recruiterId);
			Long recId=recruiterId.getRoleId();
			
			Role roles=roleRepository.findById(recId).orElseThrow(()-> new ResourceNotFoundException("Not Found RoleId.."));
			//3 --Recruiter
			Long RoleId=roles.getRoleId();
			System.out.println("RoleId"+RoleId);
			
			
			
			List<UserRole> userRoles=userRoleRepository.findRoleId(RoleId);
			
			System.out.println("UserRoles"+userRoles);
			
//			System.out.println("UserRoles"+userRoles.get(i));
			String roleName1=roles.getRoleName();
			
			
			for(int i1=0;i1<userRoles.size();i1++)
				
			{
				String email=userRoles.get(i1).getPk().getUser().getEmail();
				
				System.out.println("RoleName1..."+roleName1);

					
					if(roleName1.equals("Recruiter"))
					{
						
						emailServiceInterface.sendMessage(email, "Candidate Apply sucessfully To Job", job.getJobTitle());

					}
			}

			
		}
			
		
	}
	
	@Override
	 public Page<IListUserListDto> getAllUserJobs(String search, String pageNumber, String pageSize,HttpServletRequest request)
	  {
		final String header=request.getHeader("Authorization");
		String requestToken=header.substring(7);
//		//email
		final String email=jwtTokenUtil.getUsernameFromToken(requestToken);
		
//		//check on repo.
		User userEntity=userRepository.findByEmailContainingIgnoreCase(email);
		
		Long user_id=userEntity.getUserId();
		System.out.println("userId"+user_id);
		
//		List<UserRole> userRole= userRoleRepository.findByUserId(user_id);
		
		UserRole userRole= (UserRole) userRoleRepository.findByUserById(user_id);
		
		String roleName=userRole.getPk().getRole().getRoleName();
//			String roleName=userRole.get(i).getPk().getRole().getRoleName();
			System.out.println("roleName.."+roleName);
			
//			if(roleName.equals("Admin"))
//			{
				
			Pageable pagable=new Pagination().getPagination(pageNumber, pageSize);
			if((search=="")||(search==null)||(search.length()==0))
			{
				return userJobRepository.findByOrderById(pagable,IListUserListDto.class);
			}else
			{
				return userJobRepository.findByUserName(search,pagable,IListUserListDto.class);
			}
			
			
	
	  }
		
}