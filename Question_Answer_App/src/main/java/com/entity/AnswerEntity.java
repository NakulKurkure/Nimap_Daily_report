package com.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.UpdateTimestamp;
import org.hibernate.annotations.Where;


@Entity
@SQLDelete(sql = "UPDATE answer_entity set is_active=false where id=?")
@Where(clause = "is_active=true")
// converts the Java object to JSON object,
public class AnswerEntity implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	public Long getId() {
		return id;
	}

	public AnswerEntity() {
		super();
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
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



	@Column(name="answer")
	private String answer;
	
	@Column(name="created_at")
	@CreationTimestamp
	private Date created_At;
	
	@Column(name="updated_at")  
	@UpdateTimestamp
	private Date updated_At;
	
	@Column(name="is_active")
	private boolean is_Active=true;
	
	@OneToOne(fetch = FetchType.EAGER)
	private QuestionEntity questionId;
	
	
	public QuestionEntity getQuestionId() {
		return questionId;
	}

	public void setQuestionId(QuestionEntity questionId) {
		this.questionId = questionId;
	}

	public UserEntity getUserId() {
		return userId;
	}

	public void setUserId(UserEntity userId) {
		this.userId = userId;
	}



	@OneToOne(fetch = FetchType.EAGER) 
	private UserEntity userId;
	
	
	@Column(name="is_flag")
	private boolean is_flag=false;

	public AnswerEntity(Long id, String answer, Date created_At, Date updated_At, boolean is_Active,
			QuestionEntity questionId, UserEntity userId, boolean is_flag) {
		super();
		this.id = id;
		this.answer = answer;
		this.created_At = created_At;
		this.updated_At = updated_At;
		this.is_Active = is_Active;
		this.questionId = questionId;
		this.userId = userId;
		this.is_flag = is_flag;
	}

	public boolean isIs_flag() {
		return is_flag;
	}

	public void setIs_flag(boolean is_flag) {
		this.is_flag = is_flag;
	}
}
