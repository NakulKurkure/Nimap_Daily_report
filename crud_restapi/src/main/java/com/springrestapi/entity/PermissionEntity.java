package com.springrestapi.entity;

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
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.UpdateTimestamp;
import org.hibernate.annotations.Where;

@Entity
@Where(clause = "is_active=true")
@SQLDelete(sql="UPDATE permission SET is_active=false WHERE id=?")
@Table(name="permission")
public class PermissionEntity implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public PermissionEntity() {
		super();
		
	}										
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name="action_name")
	private String actionName;
	
	@Column(name="method")
	private String method;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getActionName() {
		return actionName;
	}

	public void setActionName(String actionName) {
		this.actionName = actionName;
	}

	public String getMethod() {
		return method;
	}

	public void setMethod(String method) {
		this.method = method;
	}
																						//{"/id"}
											//post		//addpermission  //URI 			//Path

	public PermissionEntity(int id, String actionName, String method, String baseUrl, String path, Date createdAt,
			Date updatedAt, boolean isActive) {
		super();
		this.id = id;
		this.actionName = actionName;
		this.method = method;
		this.baseUrl = baseUrl;
		this.path = path;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
		this.isActive = isActive;
	}
	public boolean isActive() {
		return isActive;
	}
	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}
	public String getBaseUrl() {
		return baseUrl;
	}

	public void setBaseUrl(String baseUrl) {
		this.baseUrl = baseUrl;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
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

	@Column(name="base_url")
	private String baseUrl;
	
	@Column(name="path")
	private String path;
	
	@Column(name="created_at")
	@CreationTimestamp
	private Date createdAt;
	
	@Column(name="updated_at")
	@UpdateTimestamp
	private Date updatedAt;

	@Column(name="is_active")
	private boolean isActive=true;
	
	@OneToMany(fetch = FetchType.LAZY,mappedBy = "pk.permission",cascade = CascadeType.ALL)
	private List<RolePermissionEntity> rolePermissionEntity;
}


