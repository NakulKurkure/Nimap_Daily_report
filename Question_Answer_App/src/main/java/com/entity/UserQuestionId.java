package com.entity;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.ManyToOne;


@Embeddable
public class UserQuestionId implements Serializable{

	private static final long serialVersionUID = 1L;

	@ManyToOne
	private UserEntity users;
	
	@ManyToOne
	private QuestionEntity questions;

	public UserEntity getUsers() {
		return users;
	}

	public UserQuestionId(UserEntity users, QuestionEntity questions) {
		super();
		this.users = users;
		this.questions = questions;
	}

	public UserQuestionId() {
		super();
		// TODO Auto-generated constructor stub
	}

	public void setUsers(UserEntity users) {
		this.users = users;
	}

	public QuestionEntity getQuestions() {
		return questions;
	}

	public void setQuestions(QuestionEntity questions) {
		this.questions = questions;
	}
	
}
