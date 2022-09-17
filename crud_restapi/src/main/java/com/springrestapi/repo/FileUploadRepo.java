package com.springrestapi.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springrestapi.entity.FileUploadingEntity;

@Repository
public interface FileUploadRepo extends JpaRepository<FileUploadingEntity, Integer>{

}
