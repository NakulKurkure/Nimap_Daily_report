package com.springrestapi.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.UpdateTimestamp;
import org.hibernate.annotations.Where;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Where(clause = "is_active=true")
@SQLDelete(sql="UPDATE ROLES SET is_active=false WHERE id=?")
@Table(name="roles")

public class RoleEntity implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	private int id;
	
	
	@CreationTimestamp
	private Date created_At;
	
	public RoleEntity(int id, Date created_At, Date updated_At, String roleName, List<UserRoleEntity> userRole,
			boolean isActive) {
		super();
		this.id = id;
		this.created_At = created_At;
		this.Updated_At = updated_At;
		this.roleName = roleName;
//		this.userRole = userRole;
		this.isActive = isActive;
	}


	public Date getCreated_At() {
		return created_At;
	}


	public void setCreated_At(Date created_At) {
		this.created_At = created_At;
	}


	public Date getUpdated_At() {
		return Updated_At;
	}


	public void setUpdated_At(Date updated_At) {
		Updated_At = updated_At;
	}


	public String getRoleName() {
		return roleName;
	}


	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public List<UserRoleEntity> getUserRole() {
		return userRole;
	}


	public void setUserRole(List<UserRoleEntity> userRole) {
		this.userRole = userRole;
	}

	@UpdateTimestamp
	private Date Updated_At;
	

	@Column(name="role_name")
	private String roleName;
	
	
	@OneToMany(fetch = FetchType.LAZY,mappedBy = "pk.roles",cascade = CascadeType.ALL)
//	@JsonManagedReference
	@JsonBackReference
	private List<UserRoleEntity> userRole;
	
	public RoleEntity() {
		super();
		
	}


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return roleName;
	}

	public void setName(String roleName) {
		this.roleName = roleName;
	}

	public boolean isActive() {
		return isActive;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}

	@Column(name="is_active")
	private boolean isActive=true;

}
