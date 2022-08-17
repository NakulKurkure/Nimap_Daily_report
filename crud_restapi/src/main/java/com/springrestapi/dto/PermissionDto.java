package com.springrestapi.dto;

public class PermissionDto {

	private String actionName;
	private String path;
	private String method;
	private String baseUrl;
	public String getActionName() {
		return actionName;
	}
	public void setActionName(String actionName) {
		this.actionName = actionName;
	}
	public PermissionDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	public PermissionDto(String actionName, String path, String method, String baseUrl) {
		super();
		this.actionName = actionName;
		this.path = path;
		this.method = method;
		this.baseUrl = baseUrl;
	}
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	public String getMethod() {
		return method;
	}
	public void setMethod(String method) {
		this.method = method;
	}
	public String getBaseUrl() {
		return baseUrl;
	}
	public void setBaseUrl(String baseUrl) {
		this.baseUrl = baseUrl;
	}
	
}
