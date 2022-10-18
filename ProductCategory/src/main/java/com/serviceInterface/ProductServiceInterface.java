package com.serviceInterface;

import com.dto.ProductDto;



public interface ProductServiceInterface {

	void addProduct(ProductDto productDto);

	ProductDto updateProductById(ProductDto productDto, Long id);

	void getProductById(Long id);

}
