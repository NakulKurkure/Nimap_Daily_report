package com.dto;

import java.util.Date;

public class QuestionDto {

	private String question;
	
	private String description;

	private boolean is_draft;
	
	
	private Date is_publish;
	
	public QuestionDto(String question, String description, boolean is_draft, Date is_publish, boolean is_flag) {
		super();
		this.question = question;
		this.description = description;
		this.is_draft = is_draft;
		this.is_publish = is_publish;
		this.is_flag = is_flag;
	}

	public Date getIs_publish() {
		return is_publish;
	}

	public void setIs_publish(Date is_publish) {
		this.is_publish = is_publish;
	}

	public boolean isIs_flag() {
		return is_flag;
	}

	public void setIs_flag(boolean is_flag) {
		this.is_flag = is_flag;
	}

	private boolean is_flag;

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
