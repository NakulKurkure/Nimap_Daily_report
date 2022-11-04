package com.job.dto;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class JobDto {

	private String jobTitle;
	
	public JobDto() {
		super();
	}

	public String getJobTitle() {
		return jobTitle;
	}

	public void setJobTitle(String jobTitle) {
		this.jobTitle = jobTitle;
	}

	public JobDto(String jobTitle, String jobDescription, Date dateOfJoining, Long recruiterId) {
		super();
		this.jobTitle = jobTitle;
		this.jobDescription = jobDescription;
		this.dateOfJoining = dateOfJoining;
		this.recruiterId = recruiterId;
	}

	public String getJobDescription() {
		return jobDescription;
	}

	public void setJobDescription(String jobDescription) {
		this.jobDescription = jobDescription;
	}

	public Date getDateOfJoining() {
		return dateOfJoining;
	}

	public void setDateOfJoining(Date dateOfJoining) {
		this.dateOfJoining = dateOfJoining;
	}

	public Long getRecruiterId() {
		return recruiterId;
	}

	public void setRecruiterId(Long recruiterId) {
		this.recruiterId = recruiterId;
	}

	private String jobDescription;
	
	@JsonFormat(pattern = "yyyy-MM-dd")
	private Date dateOfJoining;
	
	private Long recruiterId;
	
	
}
