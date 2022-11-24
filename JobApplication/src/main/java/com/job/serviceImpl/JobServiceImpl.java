package com.job.serviceImpl;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.job.dto.JobDto;
import com.job.entity.Job;
import com.job.entity.Role;
import com.job.entity.User;
import com.job.entity.UserRole;
import com.job.exception.ResourceNotFoundException;
import com.job.repository.JobRespository;
import com.job.repository.RoleRepository;
import com.job.repository.UserRepository;
import com.job.repository.UserRoleRepository;
import com.job.security.JwtTokenUtil;
import com.job.serviceInterface.IListAllJobsDto;
import com.job.serviceInterface.IListJobDto;
import com.job.serviceInterface.IListJobDtos;
import com.job.serviceInterface.JobServiceInterface;

import net.bytebuddy.dynamic.DynamicType.Builder.MethodDefinition.ImplementationDefinition.Optional;

@Service
public class JobServiceImpl implements JobServiceInterface {

	@Autowired
	private JobRespository jobRespository;

	@Autowired
	private RoleRepository roleRepository;

	@Autowired
	private JwtTokenUtil jwtTokenUtil;

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private UserRoleRepository userRoleRepository;

	@Override
	public Job addJob(JobDto jobDto, HttpServletRequest request,Long user_id) {
		User userEntity = userRepository.findById(user_id).orElseThrow(()-> new ResourceNotFoundException("Not Found UserId"));

			Job job = new Job();
			job.setJobTitle(jobDto.getJobTitle());
			job.setJobDescription(jobDto.getJobDescription());
			job.setDateOfJoining(jobDto.getDateOfJoining());
			job.setRecruiterId(userEntity);

			jobRespository.save(job);
			return job;
		 
	}

	@Override
	public void updateJob(JobDto jobDto, Long id, HttpServletRequest request) {

			Job job = jobRespository.findById(id)
					.orElseThrow(() -> new ResourceNotFoundException("Not Found JobId..."));

			job.setJobTitle(jobDto.getJobTitle());
			job.setJobDescription(jobDto.getJobDescription());
			job.setDateOfJoining(jobDto.getDateOfJoining());

			jobRespository.save(job);
		 

	}

	@Override
	public List<IListJobDto> getJobById(Long id) {

		Job job = jobRespository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Not Found JobId..."));

		List<IListJobDto> jobDto = jobRespository.findById(id, IListJobDto.class);

		return jobDto;
	}

	@Override
	public void deleteByJobId(Long id, HttpServletRequest request) {
			jobRespository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Not Found Job Id.."));

			jobRespository.deleteById(id);

	}

	@Override
	public Page<IListJobDto> getAllJobs(String search, String pageNumber, String pageSize) {

		Pageable pagable = new com.job.util.Pagination().getPagination(pageNumber, pageSize);

		if ((search == "") || (search == null) || (search.length() == 0)) {
			return jobRespository.findByOrderByIdDesc(pagable, IListJobDto.class);
		} else {
			return jobRespository.findByJobTitle(search, pagable, IListJobDto.class);
		}

	}
	
	//GetAll Jobs By Candidate Id&RecruiterId

	@Override
	public List<IListAllJobsDto> getAllJobsByRecruiter(HttpServletRequest request,Long user_id) {

		System.out.println("User"+user_id);
		userRoleRepository.findByUserById(user_id);
		
		List<IListAllJobsDto> list=jobRespository.findByJobAndPkUserByRecruiterId(user_id);

		return list;
		} 

	

//List of all jobs By Specific User
	@Override
	public List<IListJobDtos> getAllJobsByUser(String search, HttpServletRequest request) {

		return jobRespository.findByJobTitleByUser(search, IListJobDtos.class);

	}

}
