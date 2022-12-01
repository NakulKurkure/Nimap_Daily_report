package com.job.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class JobDto {

	@NotNull(message = "Required")
	@NotBlank(message = "Required")
	@NotEmpty(message = "Required")
	private String jobTitle;

	@NotNull(message = "Required")
	@NotBlank(message = "Required")
	@NotEmpty(message = "Required")
	private String jobDescription;

	public JobDto() {
		super();
	}

	public JobDto(String jobTitle, String jobDescription) {
		super();
		this.jobTitle = jobTitle;
		this.jobDescription = jobDescription;

	}

	public String getJobDescription() {
		return jobDescription;
	}

	public String getJobTitle() {
		return jobTitle;
	}

	public void setJobDescription(String jobDescription) {
		this.jobDescription = jobDescription;
	}

	public void setJobTitle(String jobTitle) {
		this.jobTitle = jobTitle;
	}

}
