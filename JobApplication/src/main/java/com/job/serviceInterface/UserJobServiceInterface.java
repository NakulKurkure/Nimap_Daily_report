package com.job.serviceInterface;

import javax.servlet.http.HttpServletRequest;

import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.Query;

import com.job.dto.UserJobRequestDto;

public interface UserJobServiceInterface {

	void addUserJob(UserJobRequestDto userJobRequestDto, Long user_id);

	Page<IListUserJobDto> getAllUserJob(String search, String pageNumber, String pageSize, HttpServletRequest request,
			String userId, String jobId);

}
