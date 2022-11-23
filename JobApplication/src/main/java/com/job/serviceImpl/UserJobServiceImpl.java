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

	@Autowired
	private JwtTokenUtil jwtTokenUtil;

	// Add UserJob @PreAuthorize
	@Override
	public void addUserJob(UserJobRequestDto userJobRequestDto, HttpServletRequest request) {

		final String header = request.getHeader("Authorization");
		String requestToken = header.substring(7);
		// email
		final String emails = jwtTokenUtil.getUsernameFromToken(requestToken);

		// check on repo.
		User user = userRepository.findByEmailContainingIgnoreCase(emails);
		System.out.println("user" + user);

		Long user_id = user.getUserId();
		System.out.println("UserId" + user_id);

		String candidateEmail = user.getEmail();
		System.out.println("candidateEmail" + candidateEmail);

		ArrayList<Job> userJobs = new ArrayList<>();

		for (int i = 0; i < userJobRequestDto.getJobId().size(); i++) {
			Long JobId = userJobRequestDto.getJobId().get(i);

			System.out.println("JobId" + JobId);
			Job job = jobRespository.findById(JobId)
					.orElseThrow(() -> new ResourceNotFoundException("Not Found Job Id"));

			System.out.println("Id");
			List<UserRole> userRole = userRoleRepository.findByUserId(user.getUserId());
			System.err.println("UserRole..." + userRole);

			userJobs.add(job);
			UserJob userJob = new UserJob();
			userJob.setJob(job);
			userJob.setUser(user);
			userJobRepository.save(userJob);

			for (int i1 = 0; i1 < userRole.size(); i1++) {

				String roleName = userRole.get(i1).getPk().getRole().getRoleName();
				System.out.println("RoleName" + roleName);
				if (roleName.equals("Candidate")) {
					emailServiceInterface.sendMessage(user.getEmail(), "Candidate Apply sucessfully To Job",
							job.getJobTitle());

				}
				System.out.println("job.getRecruiterId().getUserId()" + job.getRecruiterId().getUserId());
				Long userIdId = job.getRecruiterId().getUserId();
				System.out.println("UserId+RecId" + userIdId);
				List<UserRole> list = userRoleRepository.findByUserId(userIdId);
				System.out.println("List" + list);

				for (int i11 = 0; i11 <= list.size(); i11++) {
					String roleName1 = list.get(i11).getPk().getRole().getRoleName();
					System.out.println("Email" + roleName);
					String email = list.get(i11).getPk().getUser().getEmail();
					System.out.println("Email" + email);

					if (roleName1.equals("Recruiter")) {
						emailServiceInterface.sendMessage(email, "Candidate Apply sucessfully To Job",
								job.getJobTitle());

					}

				}
//				

			}

		}

	}

	//
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

}