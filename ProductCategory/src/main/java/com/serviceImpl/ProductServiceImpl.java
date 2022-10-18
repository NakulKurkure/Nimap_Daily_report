package com.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dto.ProductDto;
import com.entity.Product;
import com.exception.ResourceNotFoundException;
import com.repository.ProductRepository;
import com.serviceInterface.ProductServiceInterface;

@Service
public class ProductServiceImpl implements ProductServiceInterface{

	@Autowired
	private ProductRepository productRepository;
	
	@Override
	public void addProduct(ProductDto productDto) {
		
		Product product=new Product();
		product.setProduct(productDto.getProduct());
		
		productRepository.save(product);
		
		
	}

	@Override
	public ProductDto updateProductById(ProductDto productDto, Long id) {
		
		Product product= productRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Not Found ProductId"));
		
		product.setProduct(productDto.getProduct());
		productRepository.save(product);
		return productDto;
		
		
		
	}

	@Override
	public void getProductById(Long id) {
		// TODO Auto-generated method stub
		
	}

}
