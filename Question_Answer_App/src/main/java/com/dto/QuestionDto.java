package com.dto;

public class QuestionDto {

	private String question;
	
	private String description;

	public String getQuestion() {
		return question;
	}

	public QuestionDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public QuestionDto(String question, String description) {
		super();
		this.question = question;
		this.description = description;
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
