package com.job.dto;

import java.io.Serializable;
import java.util.List;

public class UserJobRequestDto implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private List<Long> jobId;
	
	public List<Long> getJobId() {
		return jobId;
	}

	public void setJobId(List<Long> jobId) {
		this.jobId = jobId;
	}

	public UserJobRequestDto() {
		super();
	}

	public UserJobRequestDto(List<Long> jobId) {
		super();
		
		this.jobId = jobId;
	}

	
	
}
