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
import com.job.serviceInterface.IListDto;
import com.job.serviceInterface.IListUserJobDto;
import com.job.serviceInterface.IListUserListDto;

import com.job.serviceInterface.UserJobServiceInterface;
import com.job.util.Pagination;

@Service
public class UserJobServiceImpl implements UserJobServiceInterface {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private UserRoleRepository userRoleRepository;

	@Autowired
	private JobRespository jobRespository;

	@Autowired
	private EmailServiceInterface emailServiceInterface;

	@Autowired
	private UserJobRepository userJobRepository;


///Pending.....
	// Add UserJob @PreAuthorize
	@Override
	public void addUserJob(UserJobRequestDto userJobRequestDto, long user_ids) {
		
		
		ArrayList<Job> userJobs = new ArrayList<>();
		
		User user=userRepository.findById(user_ids).orElseThrow(()-> new ResourceNotFoundException("Not Found UserId"));
		System.out.println("Email"+user.getEmail());
		for(int i=0;i<userJobRequestDto.getJobId().size();i++)
		{
			
			Long jobId=userJobRequestDto.getJobId().get(i);
			System.out.println("Job"+jobId);
			
			Job job=jobRespository.findById(jobId).orElseThrow(()-> new ResourceNotFoundException("Not Found JobId"));
			System.out.println("Job"+job.getJobTitle());
			userJobs.add(job);
			UserJob userJob=new UserJob();
			userJob.setUser(user);
			userJob.setJob(job);
			userJobRepository.save(userJob);
	
			 emailServiceInterface.sendMessage(user.getEmail(), "Candidate Apply sucessfully To Job",
						job.getJobTitle());	

			List<IListDto> users= userRepository.findByUsersList(IListDto.class);
			 System.out.println("users"+users);
			 
			for(int i1=0;i1<users.size();i1++)
			{
				String recruiterEmail= users.get(i).getEmail();
				
				emailServiceInterface.sendMessage(recruiterEmail, "Candidate Apply sucessfully To Job",
						job.getJobTitle());
			}
		}		
	}

	
	@Override
	public Page<IListUserListDto> getAllUserJobs(String search, String pageNumber, String pageSize,
			HttpServletRequest request) {

		Pageable pagable = new Pagination().getPagination(pageNumber, pageSize);
		if ((search == "") || (search == null) || (search.length() == 0)) {
			return userJobRepository.findByOrderById(pagable, IListUserListDto.class);
		} else {
			return userJobRepository.findByUserName(search, pagable, IListUserListDto.class);
		}

	}

	@Override
	public Page<IListUserJobDto> getAllUserJob(String search, String pageNumber, String pageSize,
			HttpServletRequest request, String userId, String jobId) {

		Pageable pagable = new Pagination().getPagination(pageNumber, pageSize);

		return userJobRepository.findListofUserJob(userId, jobId, pagable, IListUserJobDto.class);
	}

}