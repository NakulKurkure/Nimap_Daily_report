package com.dto;

public class ProductDataDto {

	public String getProduct() {
		return product;
	}

	public ProductDataDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ProductDataDto(String product, Long productId, Long categoryId) {
		super();
		this.product = product;
		this.productId = productId;
		this.categoryId = categoryId;
	}

	public void setProduct(String product) {
		this.product = product;
	}

	public Long getProductId() {
		return productId;
	}

	public void setProductId(Long productId) {
		this.productId = productId;
	}

	private String product;
	
	private Long productId;
	
	private Long categoryId;

	public Long getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(Long categoryId) {
		this.categoryId = categoryId;
	}
}
