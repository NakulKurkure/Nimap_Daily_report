package com.springrestapi.serviceImpl;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.springrestapi.Helper.ExcelHelper;
import com.springrestapi.entity.ExcelEntity;
import com.springrestapi.repo.ExcelRepo;
import com.springrestapi.service.ExcelServiceInterface;
@Service
public class ExcelServiceImpl implements ExcelServiceInterface{

	
		@Autowired
		private ExcelRepo excelRepo;
	
//		@Autowired
//		private ExcelHelper excelHelper;
	
		  public void save(MultipartFile file) {
		    try {
		    	
		    	 System.out.println("File122"+file);
		    	 System.out.println("File1"+file.getInputStream());
		    	 
		      List<ExcelEntity> tutorials = ExcelHelper.excelToTutorials(file.getInputStream());
		      System.out.println("File222"+tutorials);
		      excelRepo.saveAll(tutorials);
		      System.out.println("File33Save");
		    } catch (IOException e) {
		      throw new RuntimeException("fail to store excel data: " + e.getMessage());
		    }
		  }

	

}
