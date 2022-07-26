package com.springrestapi.errordto;

import com.springrestapi.dto.EntityDto;

public class SuccessResponseDto {

	private String message;
	private String key;
	private Object data;
	
	public SuccessResponseDto(String message, String key, Object data) {
		super();
		this.message = message;
		this.key = key;
		this.data = data;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	

	

	

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}
}
