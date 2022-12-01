package com.job.serviceInterface;

import org.springframework.data.domain.Page;

import com.job.dto.UserJobRequestDto;

public interface UserJobServiceInterface {

	void addUserJob(UserJobRequestDto userJobRequestDto, Long user_id);

	Page<IListUserJobDto> getAllUserJob(String search, String pageNumber, String pageSize, String userId, String jobId);

}
