package com.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class QuestionDto {

	private String question;
	
	private String description;

	private boolean is_draft;

	public boolean isIs_draft() {
		return is_draft;
	}

	public void setIs_draft(boolean is_draft) {
		this.is_draft = is_draft;
	}

	public QuestionDto(String question, String description, boolean is_draft) {
		super();
		this.question = question;
		this.description = description;
		this.is_draft = is_draft;
	}

	public String getQuestion() {
		return question;
	}

	public QuestionDto() {
		super();
		// TODO Auto-generated constructor stub
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
