package com.job.dto;

public class UserJobRequestDto {

	private Long userId;
	
	private Long jobId;

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public UserJobRequestDto() {
		super();
	}

	public Long getJobId() {
		return jobId;
	}

	public UserJobRequestDto(Long userId, Long jobId) {
		super();
		this.userId = userId;
		this.jobId = jobId;
	}

	public void setJobId(Long jobId) {
		this.jobId = jobId;
	}
	
}
