package com.dto;

public class QuestionAnswerRequestDto {

	public QuestionAnswerRequestDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	private Long questionId;
	
	private Long answerId;

	public Long getQuestionId() {
		return questionId;
	}

	public void setQuestionId(Long questionId) {
		this.questionId = questionId;
	}

	public QuestionAnswerRequestDto(Long questionId, Long answerId) {
		super();
		this.questionId = questionId;
		this.answerId = answerId;
	}

	public Long getAnswerId() {
		return answerId;
	}

	public void setAnswerId(Long answerId) {
		this.answerId = answerId;
	}
}
