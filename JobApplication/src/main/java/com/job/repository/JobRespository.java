package com.job.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.job.entity.Job;
import com.job.serviceInterface.IListJobDto;

@Repository
public interface JobRespository extends JpaRepository<Job, Long>{

	List<IListJobDto> findById(Long id, Class<IListJobDto> class1);

	Page<IListJobDto> findByOrderByIdDesc(Pageable pagable, Class<IListJobDto> class1);

	Page<IListJobDto> findByJobTitle(String search, Pageable pagable, Class<IListJobDto> class1);


}
