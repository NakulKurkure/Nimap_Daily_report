package com.serviceInterface;

import org.springframework.data.domain.Page;

import com.dto.CategoryDataDto;
import com.dto.CategoryDto;


public interface CategoryServiceInterface {

	void addCategory(CategoryDto categoryDto);

	CategoryDto updateCategory(long id, CategoryDto categoryDto);

	CategoryDataDto getCategoryById(Long id);

	void deleteCategoryById(Long id);

	Page<ICategoryListDto> getAllCategory(String search, String pageNumber, String pageSize);

	
}
