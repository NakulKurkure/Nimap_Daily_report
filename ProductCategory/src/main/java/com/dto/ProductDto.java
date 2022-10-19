package com.dto;

public class ProductDto {

	private String product;
	
	private Long categoryId;

	public Long getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(Long categoryId) {
		this.categoryId = categoryId;
	}

	public String getProduct() {
		return product;
	}

	public ProductDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public void setProduct(String product) {
		this.product = product;
	}

	public ProductDto(String product, Long categoryId) {
		super();
		this.product = product;
		this.categoryId = categoryId;
	}

	public ProductDto(String product) {
		super();
		this.product = product;
	}
	
	
}
