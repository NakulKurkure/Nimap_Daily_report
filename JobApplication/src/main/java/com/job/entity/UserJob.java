package com.job.entity;

import java.util.Date;

import javax.persistence.AssociationOverride;
import javax.persistence.AssociationOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.hibernate.annotations.Where;

@Entity
@Table(name="user_job")
@Where(clause = "is_active=true")
@AssociationOverrides({@AssociationOverride(name="pk.user",joinColumns = @JoinColumn(name="user_id")),@AssociationOverride(name="pk.job",joinColumns = @JoinColumn(name="job_id"))})
public class UserJob {


	@EmbeddedId
	private UserJobId pk=new UserJobId();
	
	public UserJobId getPk() {
		return pk;
	}

	public void setPk(UserJobId pk) {
		this.pk = pk;
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

	public UserJob(UserJobId pk, Date createdAt, Date updatedAt, boolean isActive) {
		super();
		this.pk = pk;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
		this.isActive = isActive;
	}

	public UserJob() {
		super();
	}

	@Column(name="created_at")
	@CreationTimestamp
	private Date createdAt;
	
	@Column(name="updated_at")
	@UpdateTimestamp
	private Date updatedAt;
	
	@Column(name="is_active")
	private boolean isActive=true;
	
}
