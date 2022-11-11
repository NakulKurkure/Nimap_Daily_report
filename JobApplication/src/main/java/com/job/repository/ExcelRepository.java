package com.job.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.job.entity.Excel;

@Repository
public interface ExcelRepository extends JpaRepository<Excel,Long>{

}
