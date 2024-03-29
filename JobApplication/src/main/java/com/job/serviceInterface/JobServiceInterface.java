package com.job.serviceInterface;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.data.domain.Page;

import com.job.dto.JobDto;
import com.job.entity.Job;

public interface JobServiceInterface {

	Job addJob(JobDto jobDto, HttpServletRequest request, Long user_id);

	void updateJob(JobDto jobDto, Long id, HttpServletRequest request);

	List<IListJobDto> getJobById(Long id);

	void deleteByJobId(Long id, HttpServletRequest request);

	Page<IListJobDto> getAllJobs(String search, String pageNumber, String pageSize);

	List<IListAllJobsDto> getAllJobsByRecruiter(Long userId);


}
