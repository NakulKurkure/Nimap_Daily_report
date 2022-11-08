package com.job.dto;

import java.io.Serializable;
import java.util.List;

public class UserJobRequestDto implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Long userId;
	
	private List<Long> jobId;

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public List<Long> getJobId() {
		return jobId;
	}

	public void setJobId(List<Long> jobId) {
		this.jobId = jobId;
	}

	public UserJobRequestDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public UserJobRequestDto(Long userId, List<Long> jobId) {
		super();
		this.userId = userId;
		this.jobId = jobId;
	}

	
	
}
