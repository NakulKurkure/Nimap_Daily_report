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
import com.job.serviceInterface.JobServiceInterface;

@Service
public class JobServiceImpl implements JobServiceInterface{

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
	public Job addJob(JobDto jobDto,HttpServletRequest request) {
	
		
		Role role=roleRepository.findById(jobDto.getRecruiterId()).orElseThrow(()-> new ResourceNotFoundException("Please Enter Valid RoleId..."));
		
		final String header=request.getHeader("Authorization");
		String requestToken=header.substring(7);
//		//email
		final String email=jwtTokenUtil.getUsernameFromToken(requestToken);
		
//		//check on repo.
		User userEntity=userRepository.findByEmailContainingIgnoreCase(email);
		
		Long user_id=userEntity.getUserId();
		System.out.println("userId"+user_id);
		
		UserRole userRole= userRoleRepository.findByUserById(user_id);
		String roleName;
		
			roleName=userRole.getPk().getRole().getRoleName();
			System.out.println("RoleName.."+roleName);	
			
			if(roleName.equals("Recruiter"))
			{
				Job job=new Job();
				job.setJobTitle(jobDto.getJobTitle());
				job.setJobDescription(jobDto.getJobDescription());
				job.setDateOfJoining(jobDto.getDateOfJoining());
				job.setRecruiterId(role);
				
				 jobRespository.save(job);
				return job;
				
			}	else
			{
				throw new ResourceNotFoundException("Only Recruiter Can be Posted the Jobs..");
			}
		
		}
		
		
		
		
	@Override
	public void updateJob(JobDto jobDto,Long id,HttpServletRequest request) {
	
		roleRepository.findById(jobDto.getRecruiterId()).orElseThrow(()-> new ResourceNotFoundException("Please Enter Valid RoleId..."));
		
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
			if(roleName.equals("Admin"))
			{
				Job job=jobRespository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Not Found JobId..."));

				job.setJobTitle(jobDto.getJobTitle());
				job.setJobDescription(jobDto.getJobDescription());
				job.setDateOfJoining(jobDto.getDateOfJoining());
				
				jobRespository.save(job);
			}else
			{
				throw new ResourceNotFoundException("Only Admin Can Update The Jobs..." );
			}
			
		}
	
	
	@Override
	public List<IListJobDto> getJobById(Long id) {
		
		
		Job job=jobRespository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Not Found JobId..."));
		
		List<IListJobDto> jobDto= jobRespository.findById(id,IListJobDto.class);
		
		return jobDto;
	}
		
	@Override
	public void deleteByJobId(Long id,HttpServletRequest request) {
	
		
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
		
		if(roleName.equals("Admin"))
		{
			
		jobRespository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Not Found Job Id.."));
		
		jobRespository.deleteById(id);
		
		}else
		{
			throw new ResourceNotFoundException("Only Access Admin...");
		}
		
	}

	@Override
	public Page<IListJobDto> getAllJobs(String search, String pageNumber, String pageSize) {
		
		
		Pageable pagable= new com.job.util.Pagination().getPagination(pageNumber, pageSize);
		
		if((search=="")||(search==null)||(search.length()==0))
		{
			return jobRespository.findByOrderByIdDesc(pagable,IListJobDto.class);
		}
		else
		{
			return  jobRespository.findByJobTitle(search,pagable,IListJobDto.class);
		}
	
	}


	@Override
	public List<IListAllJobsDto> getAllJobsByRecruiter(HttpServletRequest request) {
		
		final String header=request.getHeader("Authorization");
		String requestToken=header.substring(7);
//		//email
		final String email=jwtTokenUtil.getUsernameFromToken(requestToken);
//		//check on repo.
		User user=userRepository.findByEmailContainingIgnoreCase(email);

		Long user_id=user.getUserId();
		System.out.println("userId"+user_id);

		UserRole userRole= userRoleRepository.findByUserById(user_id);
		System.out.println("userRoleEntity1111");
		
		Long recuriterId=userRole.getPk().getRole().getRoleId();
		System.out.println("RoleId."+recuriterId);
		
		String roleName=userRole.getPk().getRole().getRoleName();
		System.out.println("RoleName."+roleName);
		
		List<Job> job=jobRespository.findByRecuriterId(recuriterId);
		System.out.println("job"+job);
	
		for(int i=0;i<job.size();i++)
		{
			
		Role recuriter_ids=	job.get(i).getRecruiterId();
		
		Long recuriter_id=recuriter_ids.getRoleId();
		
		String roleName1=recuriter_ids.getRoleName();
			
		if(roleName1.equals("Recruiter"))
		{
			List<IListAllJobsDto> list=jobRespository.findByJobAndPkUserByRecruiterId(recuriter_id);
			
			
			return list;	
		}
		else
		{
			throw new ResourceNotFoundException("Only Recruiter Access..");
		}
		}
		
		
//		Role recuriter_ids=job.getRecruiterId();
//		Long recuriter_id=recuriter_ids.getRoleId();		
		
//		System.out.println("findByJobAndPkUserByRecruiterId"+recuriter_id.longValue());
//		if(roleName.equals("Recruiter"))
//		{
//			List<Object> list=jobRespository.findByJobAndPkUserByRecruiterId(recuriter_id);
//			
//			System.out.println("Dj");
////			return null;	
//		}
//		else
//		{
			throw new ResourceNotFoundException("Only Recruiter Access..");
//		}
//		
//		
		
		
	}




	@Override
	public List<IListJobDto> getAllJobsByUser(HttpServletRequest request) {
		
		
		
		return null;
	}

}