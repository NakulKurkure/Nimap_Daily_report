package com.dto;

public class SuccessResponseDto {

	private String message;
	
	private String msgkey;
	
	private Object data;
	
	public SuccessResponseDto(String message, String msgkey, Object data) {
		super();
		this.message = message;
		this.msgkey = msgkey;
		this.data = data;
	}
	public Object getData() {
		return data;
	}
	public void setData(Object data) {
		this.data = data;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getMsgkey() {
		return msgkey;
	}
	
	public SuccessResponseDto(String message, String msgkey) {
		super();
		this.message = message;
		this.msgkey = msgkey;
		
	}
	public void setMsgkey(String msgkey) {
		this.msgkey = msgkey;
	}

}
