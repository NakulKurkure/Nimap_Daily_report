package com.springrestapi.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springrestapi.entity.ExcelEntity;

@Repository
public interface ExcelRepo extends JpaRepository<ExcelEntity,Integer>{

}
