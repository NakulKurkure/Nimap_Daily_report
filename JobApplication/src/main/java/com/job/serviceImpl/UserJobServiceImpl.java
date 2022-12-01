package com.job.serviceImpl;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.job.dto.UserJobRequestDto;
import com.job.entity.Job;
import com.job.entity.User;
import com.job.entity.UserJob;
import com.job.exception.ResourceNotFoundException;
import com.job.repository.JobRespository;
import com.job.repository.UserJobRepository;
import com.job.repository.UserRepository;
import com.job.serviceInterface.IListUserJobDto;
import com.job.serviceInterface.UserJobServiceInterface;
import com.job.util.Pagination;

@Service
public class UserJobServiceImpl implements UserJobServiceInterface {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private JobRespository jobRespository;

	@Autowired
	private EmailServiceImpl emailServiceImpl;

	@Autowired
	private UserJobRepository userJobRepository;

	// Add UserJob @PreAuthorize
	@Override
	public void addUserJob(UserJobRequestDto userJobRequestDto, Long user_ids) {

		ArrayList<Job> userJobs = new ArrayList<>();

		User user = userRepository.findById(user_ids)
				.orElseThrow(() -> new ResourceNotFoundException("Not Found UserId"));
		System.out.println("Email" + user.getEmail());
		for (int i = 0; i < userJobRequestDto.getJobId().size(); i++) {

			Long jobId = userJobRequestDto.getJobId().get(i);
			System.out.println("Job" + jobId);

			Job job = jobRespository.findById(jobId)
					.orElseThrow(() -> new ResourceNotFoundException("Not Found JobId"));
			System.out.println("Job" + job.getJobTitle());
			userJobs.add(job);
			UserJob userJob = new UserJob();
			userJob.setUser(user);
			userJob.setJob(job);
			userJobRepository.save(userJob);

			emailServiceImpl.sendMessage(user.getEmail(), "Candidate Apply sucessfully To Job", job.getJobTitle());

			String email = job.getRecruiterId().getEmail();

			System.out.println("recruiterEmail" + email);
			emailServiceImpl.sendMessage(email, "Candidate Apply sucessfully To Job", job.getJobTitle());
		}
	}

	@Override
	public Page<IListUserJobDto> getAllUserJob(String search, String pageNumber, String pageSize, String userId,
			String jobId) {

		Pageable paging = new Pagination().getPagination(pageNumber, pageSize);
		Page<IListUserJobDto> listUserJobs = null;
		System.out.println("pageNumber" + pageNumber);
		System.out.println("pageSize" + pageSize);

		listUserJobs = this.userJobRepository.findList1(paging, userId, jobId, IListUserJobDto.class);

		return listUserJobs;
	}

}