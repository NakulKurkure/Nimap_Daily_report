package com.entity;

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
@Table(name="role_entity")
@Where(clause = "is_active=true")
@SQLDelete(sql="UPDATE role_entity SET is_Active=false WHERE id=?")
public class RoleEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="role_name")
	private String roleName;
	
	public RoleEntity(Long id, String roleName, String description, Date created_At, Date updated_At,
			boolean is_Active) {
		super();
		this.id = id;
		this.roleName = roleName;
		this.description = description;
		this.created_At = created_At;
		this.updated_At = updated_At;
		this.is_Active = is_Active;
	}

	public RoleEntity() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Column(name="description")
	private String description;
	
	@Column(name="created_at")
	@CreationTimestamp
	private Date created_At;
	
	@Column(name="updated_at")
	@UpdateTimestamp
	private Date updated_At;
	
	
	@OneToMany(fetch = FetchType.LAZY,mappedBy = "pk.roles",cascade = CascadeType.ALL)
	List<UserRoleEntity> userRole;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
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
	
	
}
