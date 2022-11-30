package com.job.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.job.entity.User;
import com.job.entity.UserJob;

@Repository
public interface ExcelRepo extends JpaRepository<UserJob, Long>{

}
