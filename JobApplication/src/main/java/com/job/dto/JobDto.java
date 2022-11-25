package com.job.dto;

import java.util.Date;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonFormat;

public class JobDto {

	@NotNull(message = "Required")
	@NotBlank(message="Required")
	@NotEmpty(message="Required")
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

	public JobDto(String jobTitle, String jobDescription, Date dateOfJoining) {
		super();
		this.jobTitle = jobTitle;
		this.jobDescription = jobDescription;
		this.dateOfJoining = dateOfJoining;
		
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

	@NotNull(message = "Required")
	@NotBlank(message="Required")
	@NotEmpty(message="Required")
	private String jobDescription;
	
	private Date dateOfJoining;

	
	
}
