package com.repository;


import javax.transaction.Transactional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.entity.Category;
import com.serviceInterface.ICategoryListDto;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long>{
	
	Page<ICategoryListDto> findByCategory(String search, Pageable pagable, Class<ICategoryListDto> class1);

	Category findByCategory(String category);


	Page<ICategoryListDto> findByOrderByCategoryIdDesc(Pageable pagable, Class<ICategoryListDto> class1);
	

}
