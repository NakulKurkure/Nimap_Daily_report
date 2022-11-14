package com.job.serviceInterface;

public interface IPermissionListDto {

	public Long getPermissionId();
	
	public String getActionName();
	
	public String getDescription(); 
	
	public String getMethod();
	
	public String getBaseUrl();
	
	public String getPath();
	
}
