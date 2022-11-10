package com.job.serviceInterface;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.data.domain.Page;

import com.job.dto.JobDto;

public interface JobServiceInterface {

	void addJob(JobDto jobDto,HttpServletRequest request);

	void updateJob(JobDto jobDto, Long id,HttpServletRequest request);

	List<IListJobDto> getJobById(Long id);

	void deleteByJobId(Long id);

	Page<IListJobDto> getAllJobs(String search, String pageNumber, String pageSize);

	List<IListAllJobsDto> getAllJobsByRecruiter(HttpServletRequest request);

}
