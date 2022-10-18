package com.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

import org.springframework.lang.NonNull;

public class CategoryDto {

	public CategoryDto(String category) {
		super();

		this.category = category;
	}


	@NonNull
	@NotEmpty(message="message * Required")
	@NotBlank(message="message * Required")
	private String category;


	public CategoryDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}
	
}
