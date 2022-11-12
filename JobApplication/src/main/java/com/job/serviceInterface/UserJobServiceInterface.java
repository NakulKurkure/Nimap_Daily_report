package com.job.serviceInterface;

import javax.servlet.http.HttpServletRequest;

import org.springframework.data.domain.Page;

import com.job.dto.UserJobRequestDto;

public interface UserJobServiceInterface {

	void addUserJob(UserJobRequestDto userJobRequestDto, HttpServletRequest request);

	Page<IListUserListDto> getAllUserJobs(String search, String pageNumber, String pageSize,HttpServletRequest request);

}
