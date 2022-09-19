package com.springrestapi.service;

import java.io.InputStream;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.springrestapi.entity.ExcelEntity;

public interface ExcelServiceInterface {

	void save(MultipartFile file);

//	InputStream load();

	List<ExcelEntity> getAllTutorials();



}
