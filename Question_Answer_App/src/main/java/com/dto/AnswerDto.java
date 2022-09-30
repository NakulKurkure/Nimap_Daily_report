package com.dto;

public class AnswerDto {

	
	private String answer;
	
	private Long question_id;

	
	
	public AnswerDto(String answer, Long question_id) {
		super();
		this.answer = answer;
		this.question_id = question_id; 

	}


	public void setQuestion_id(Long question_id) {
		this.question_id = question_id;
	}

	public Long getQuestion_id() {
		return question_id;
	}

	public AnswerDto( String answer) {
		super();
	
		this.answer = answer;
	}

	public AnswerDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

}
