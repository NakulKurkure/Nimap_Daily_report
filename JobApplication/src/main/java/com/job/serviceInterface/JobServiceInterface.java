package com.job.serviceInterface;

import java.util.List;

import org.springframework.data.domain.Page;

import com.job.dto.JobDto;

public interface JobServiceInterface {

	void addJob(JobDto jobDto);

	void updateJob(JobDto jobDto, Long id);

	List<IListJobDto> getJobById(Long id);

	void deleteByJobId(Long id);

	Page<IListJobDto> getAllJobs(String search, String pageNumber, String pageSize);

}
