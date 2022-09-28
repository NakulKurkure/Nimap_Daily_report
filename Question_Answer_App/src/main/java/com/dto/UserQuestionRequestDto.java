package com.dto;

public class UserQuestionRequestDto {

	
	private Long userId;
	
	private Long questionId;

	public Long getUserId() {
		return userId;
	}

	public UserQuestionRequestDto() {
		super();
		
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public Long getQuestionId() {
		return questionId;
	}

	public UserQuestionRequestDto(Long userId, Long questionId) {
		super();
		this.userId = userId;
		this.questionId = questionId;
	}

	public void setQuestionId(Long questionId) {
		this.questionId = questionId;
	}
}
