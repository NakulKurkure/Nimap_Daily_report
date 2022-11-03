package com.job.dto;

public class AuthSuccessDto {

	

		private String message;
		
		private String msgKey;
		
		private Object data;

		public Object getData() {
			return data;
		}

		public void setData(Object data) {
			this.data = data;
		}

		public String getMessage() {
			return message;
		}

	

		public AuthSuccessDto() {
			super();
			// TODO Auto-generated constructor stub
		}

		public AuthSuccessDto(String message, String msgKey, Object data) {
			super();
			this.message = message;
			this.msgKey = msgKey;
			this.data = data;
		}

		public void setMessage(String message) {
			this.message = message;
		}

		public String getMsgKey() {
			return msgKey;
		}

		
		public void setMsgKey(String msgKey) {
			this.msgKey = msgKey;
		}
		
		
	}


