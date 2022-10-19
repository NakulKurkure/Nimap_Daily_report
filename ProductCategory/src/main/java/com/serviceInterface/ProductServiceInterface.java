package com.serviceInterface;

import java.util.List;

import javax.validation.Valid;

import org.springframework.data.domain.Page;

import com.dto.ProductDto;
import com.entity.Product;



public interface ProductServiceInterface {

	void addProduct(ProductDto productDto);

	ProductDto updateProductById(ProductDto productDto, Long id);

	List<IListProductDto> getProductById(Long id);

	void deleteByProductId(Long id);

	Page<IListProductDto> getAllProduct(String search, String pageNumber, String pageSize);

}
