package com.springrestapi.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;

@Entity
@Table(name="file_upload")
public class FileUploadingEntity {

	@Id
	@GeneratedValue
	private int id;
	
	@Column(name="file_name")
	private String fileName;
	
	@Column(name="mime")
	private String mime;
	
	@Column(name="original_name")
	private String originalName;
	
	public FileUploadingEntity() {
		super();
		// TODO Auto-generated constructor stub
	}

	public FileUploadingEntity(int id, String fileName, String mime, String originalName, String encoding, String type,
			Long size, Date created_At) {
		super();
		this.id = id;
		this.fileName = fileName;
		this.mime = mime;
		this.originalName = originalName;
		this.encoding = encoding;
		this.type = type;
		this.size = size;
		this.created_At = created_At;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getMime() {
		return mime;
	}

	public void setMime(String mime) {
		this.mime = mime;
	}

	public String getOriginalName() {
		return originalName;
	}

	public void setOriginalName(String originalName) {
		this.originalName = originalName;
	}

	public String getEncoding() {
		return encoding;
	}

	public void setEncoding(String encoding) {
		this.encoding = encoding;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Long getSize() {
		return size;
	}

	public void setSize(Long size) {
		this.size = size;
	}

	public Date getCreated_At() {
		return created_At;
	}

	public void setCreated_At(Date created_At) {
		this.created_At = created_At;
	}

	@Column(name="encoding")
	private String encoding;
	
	@Column(name="type")
	private String type;
	
	@Column(name="size")
	private Long size;
	
	@CreationTimestamp
	@Column(name="created_at")
	private Date created_At;
	
}
