package com.dto;

public class CategoryDataDto {

	private String category;
	
	public CategoryDataDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CategoryDataDto(String category, Long categoryId) {
		super();
		this.category = category;
		this.categoryId = categoryId;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public Long getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(Long categoryId) {
		this.categoryId = categoryId;
	}

	private Long categoryId;
}
