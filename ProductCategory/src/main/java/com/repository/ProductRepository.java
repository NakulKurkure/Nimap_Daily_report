package com.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.entity.Product;
import com.serviceInterface.IListProductDto;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long>{

	List<IListProductDto> findByProductId(Long id, Class<IListProductDto> class1);

	Page<IListProductDto> findByProduct(String search, Pageable pagable, Class<IListProductDto> class1);
	Product findByProductContainingIgnoreCase(String product1);

	Page<IListProductDto> findByOrderByProductIdDesc(Pageable pagable, Class<IListProductDto> class1);

}
