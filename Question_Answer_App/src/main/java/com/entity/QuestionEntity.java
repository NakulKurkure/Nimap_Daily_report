package com.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
@Table(name="question_entity")
public class QuestionEntity implements Serializable{

	
	private static final long serialVersionUID = 1L;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public QuestionEntity() {
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
		return Description;
	}

	public void setDescription(String description) {
		Description = description;
	}

	public Date getCreated_At() {
		return created_At;
	}

	public void setCreated_At(Date created_At) {
		this.created_At = created_At;
	}

	public Date getUpdated_At() {
		return updated_At;
	}

	public void setUpdated_At(Date updated_At) {
		this.updated_At = updated_At;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="question")
	private String question;
	
	@Column(name="description")
	private String Description;
	
	@Column(name="created_at")
	@CreationTimestamp
	private Date created_At;
	
	@Column(name="updated_at")
	@UpdateTimestamp
	private Date updated_At;
	
	@Column(name="is_active")
	private boolean is_Active=true;

	public QuestionEntity(Long id, String question, String description, Date created_At, Date updated_At,
			boolean is_Active) {
		super();
		this.id = id;
		this.question = question;
		Description = description;
		this.created_At = created_At;
		this.updated_At = updated_At;
		this.is_Active = is_Active;
	}

	public boolean isIs_Active() {
		return is_Active;
	}

	public void setIs_Active(boolean is_Active) {
		this.is_Active = is_Active;
	}
	
	
}
