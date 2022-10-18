package com.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.dto.CategoryDataDto;
import com.dto.CategoryDto;
import com.entity.Category;
import com.exception.ResourceNotFoundException;
import com.repository.CategoryRepository;
import com.serviceInterface.CategoryServiceInterface;
import com.serviceInterface.ICategoryListDto;

import com.util.Pagination;

@Service
public class CategoryServiceImpl implements CategoryServiceInterface{

	@Autowired
	private CategoryRepository categoryRepository;
	
	@Override
	public void addCategory(CategoryDto categoryDto) {
		
		Category category=new Category();
		category.setCategory(categoryDto.getCategory());
		
		categoryRepository.save(category);
		
	}

	@Override
	public CategoryDto updateCategory(long id, CategoryDto categoryDto) {
		
		Category category= categoryRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Not Found CategoryId"));
		
		category.setCategory(categoryDto.getCategory());
		
		categoryRepository.save(category);
		
		return categoryDto;
	}

	@Override
	public CategoryDataDto getCategoryById(Long id) {
		
		Category category= categoryRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Not Found CategoryId"));
		
		CategoryDataDto categoryDto=new CategoryDataDto();
		categoryDto.setCategoryId(category.getCategoryId());
		categoryDto.setCategory(category.getCategory());
		return categoryDto;
		
		
		
	}

	@Override
	public void deleteCategoryById(Long id) {
		
		this.categoryRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Not Found CategoryId"));
		
		categoryRepository.deleteById(id);
		
		
	}

	@Override
	public Page<ICategoryListDto> getAllCategory(String search, String pageNumber, String pageSize) {
		
		Pageable pagable= new Pagination().getPagination(pageNumber, pageSize);
		
		if((search=="")||(search==null)||(search.length()==0))
		{
			return categoryRepository.findByOrderByCategoryId(pagable,ICategoryListDto.class);
		}
		else
		{
			return  categoryRepository.findByCategory(search,pagable,ICategoryListDto.class);
		}
		
	}

	
	
	

	
}
