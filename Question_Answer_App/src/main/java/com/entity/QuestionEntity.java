package com.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.UpdateTimestamp;
import org.hibernate.annotations.Where;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import antlr.collections.List;

@Entity
@SQLDelete(sql = "UPDATE question_entity SET is_active=false,is_draft=false where id=?")
@Where(clause = "is_active=true")
@Table(name="question_entity")
public class QuestionEntity implements Serializable{

	
	private static final long serialVersionUID = 1L;
	
	public QuestionEntity() {
		super();
		
	}


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="question")
	private String question;
	
	@Column(name="description")
	private String description;
	
	@Column(name="created_at")
	@CreationTimestamp
	private Date created_At;
	
	@Column(name="updated_at")
	@UpdateTimestamp
	private Date updated_At;
	
	
	public QuestionEntity(Long id, String question, String description, Date created_At, Date updated_At,
			Date is_publish, java.util.List<UserQuestionEntity> userQuestions, boolean is_Active, boolean is_draft,
			boolean is_flag) {
		super();
		this.id = id;
		this.question = question;
		this.description = description;
		this.created_At = created_At;
		this.updated_At = updated_At;
		this.is_publish = is_publish;
		this.userQuestions = userQuestions;
		this.is_Active = is_Active;
		this.is_draft = is_draft;
		this.is_flag = is_flag;
	}


	@Column(name="is_publish")
	private Date is_publish;
	

	public Date getIs_publish() {
		return is_publish;
	}

	public void setIs_publish(Date is_publish) {
		this.is_publish = is_publish;
	}


	@OneToMany(fetch = FetchType.LAZY,mappedBy = "pk.questions",cascade = CascadeType.ALL)
	@JsonIgnore
	java.util.List<UserQuestionEntity> userQuestions;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public boolean isIs_Active() {
		return is_Active;
	}

	public void setIs_Active(boolean is_Active) {
		this.is_Active = is_Active;
	}


	@Column(name="is_active")
	private boolean is_Active=true;

	@Column(name="is_draft")
	private boolean is_draft=false;


	public java.util.List<UserQuestionEntity> getUserQuestions() {
		return userQuestions;
	}

	public void setUserQuestions(java.util.List<UserQuestionEntity> userQuestions) {
		this.userQuestions = userQuestions;
	}

	public boolean isIs_draft() {
		return is_draft;
	}

	public void setIs_draft(boolean is_draft) {
		this.is_draft = is_draft;
	}
	
	public QuestionEntity(Long id, String question, String description, Date created_At, Date updated_At,
			Date is_publish, java.util.List<UserQuestionEntity> userQuestions, boolean is_Active, boolean is_draft,
			boolean is_flag, UserEntity user_id) {
		super();
		this.id = id;
		this.question = question;
		this.description = description;
		this.created_At = created_At;
		this.updated_At = updated_At;
		this.is_publish = is_publish;
		this.userQuestions = userQuestions;
		this.is_Active = is_Active;
		this.is_draft = is_draft;
		this.is_flag = is_flag;
		this.user_id = user_id;
	}

	public boolean isIs_flag() {
		return is_flag;
	}

	public UserEntity getUser_id() {
		return user_id;
	}

	public void setUser_id(UserEntity user_id) {
		this.user_id = user_id;
	}

	public void setIs_flag(boolean is_flag) {
		this.is_flag = is_flag;
	}


	@Column(name="is_flag")
	private boolean is_flag =false;

	
	@OneToOne(fetch = FetchType.LAZY)
	private UserEntity user_id;
	

}
