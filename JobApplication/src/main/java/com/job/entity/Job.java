package com.job.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.UpdateTimestamp;
import org.hibernate.annotations.Where;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name="job")
@Where(clause = "is_active=true")
@SQLDelete(sql = "update job set is_active=false where id=?")
public class Job implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private Long id;
	
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="recuriter_id")
	private Role recruiterId;


	public Job() {
		super();
	}

	@Column(name="job_title")
	private String jobTitle;
	
	@Column(name="job_description")
	private String jobDescription;
	
	public Role getRecruiterId() {
		return recruiterId;
	}

	public Job(Long id, String jobTitle, String jobDescription, Date createdAt, Date updatedAt, boolean isActive,
			Date dateOfJoining, Role recruiterId) {
		super();
		this.id = id;
		this.jobTitle = jobTitle;
		this.jobDescription = jobDescription;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
		this.isActive = isActive;
		this.dateOfJoining = dateOfJoining;
		this.recruiterId = recruiterId;
	}

	public void setRecruiterId(Role recruiterId) {
		this.recruiterId = recruiterId;
	}

	@Column(name="created_at")
	@CreationTimestamp
	private Date createdAt;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getJobTitle() {
		return jobTitle;
	}

	public void setJobTitle(String jobTitle) {
		this.jobTitle = jobTitle;
	}

	public String getJobDescription() {
		return jobDescription;
	}

	public void setJobDescription(String jobDescription) {
		this.jobDescription = jobDescription;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public Date getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}

	public boolean isActive() {
		return isActive;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}

	public Date getDateOfJoining() {
		return dateOfJoining;
	}

	public void setDateOfJoining(Date dateOfJoining) {
		this.dateOfJoining = dateOfJoining;
	}

	@Column(name="updated_at")
	@UpdateTimestamp
	private Date updatedAt;
	
	@Column(name="is_active")
	private boolean isActive=true;

	@Column(name="date_of_joining")
	private Date dateOfJoining;
	
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "job",cascade = CascadeType.ALL)
	@JsonBackReference
	List<UserJob> userJob;
	
	
	
	
}