package com.job.serviceInterface;

public interface IListJobDto {

	public Long getId() ;
	
	public String getJobTitle();
	
	public String getJobDescription();
	
	public IRoleListDto getRecruiterId();
	
	
}


