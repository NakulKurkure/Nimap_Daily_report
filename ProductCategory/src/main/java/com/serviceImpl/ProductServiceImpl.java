package com.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.dto.ProductDataDto;
import com.dto.ProductDto;
import com.entity.Category;
import com.entity.Product;
import com.exception.ResourceNotFoundException;
import com.repository.CategoryRepository;
import com.repository.ProductRepository;
import com.serviceInterface.ICategoryListDto;
import com.serviceInterface.IListProductDto;
import com.serviceInterface.ProductServiceInterface;
import com.util.Pagination;

@Service
public class ProductServiceImpl implements ProductServiceInterface{

	@Autowired
	private ProductRepository productRepository;
	
	@Autowired
	private CategoryRepository categoryRepository;
	
	public void addProduct(ProductDto productDto) {
		
		Long CategoryId=productDto.getCategoryId();
		
		Category category=categoryRepository.findById(CategoryId).orElseThrow();
		
		Product product=new Product();
		product.setProduct(productDto.getProduct());
		product.setCategory(category);
		
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
	public List<IListProductDto> getProductById(Long id) {
		
		Product product=productRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Not Found ProductId"));

		List<IListProductDto> productDtos= productRepository.findByProductId(id,IListProductDto.class);
		
		return productDtos;
		
		
	}

	@Override
	public void deleteByProductId(Long id) {
		
		this.productRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Not Found ProductId"));

		productRepository.deleteById(id);
		
		
	}

	@Override
	public Page<IListProductDto> getAllProduct(String search, String pageNumber, String pageSize) {
	
		Pageable pagable= new Pagination().getPagination(pageNumber, pageSize);
		
		if((search=="")||(search==null)||(search.length()==0))
		{
			return productRepository.findByOrderByProductIdDesc(pagable,IListProductDto.class);
		}
		else
		{
			return  productRepository.findByProduct(search,pagable,IListProductDto.class);
		}
	
	}



}
