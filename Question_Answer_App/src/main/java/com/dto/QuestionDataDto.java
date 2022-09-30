package com.dto;

public class QuestionDataDto {

	private String question;
	
	private String description;

	public QuestionDataDto(String question, String description) {
		super();
		this.question = question;
		this.description = description;
	}

	public QuestionDataDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
}
