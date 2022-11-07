package com.job.entity;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.ManyToOne;

@Embeddable
public class UserJobId implements Serializable{

	private static final long serialVersionUID = 1L;

	@ManyToOne
	private User user;
	
	@ManyToOne
	private Job job;

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public UserJobId(User user, Job job) {
		super();
		this.user = user;
		this.job = job;
	}

	public UserJobId() {
		super();
	}

	public Job getJob() {
		return job;
	}

	public void setJob(Job job) {
		this.job = job;
	}
	
}
