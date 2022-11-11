package com.job.serviceImpl;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.job.entity.Excel;
import com.job.repository.ExcelRepository;
import com.job.serviceInterface.ExcelServiceInterface;

@Service
public class ExcelServiceImpl implements ExcelServiceInterface{

	@Autowired
	private ExcelRepository excelRepo;

//	@Autowired
	private com.job.helper.ExcelHelper excelHelper;

	//uploaded file received in a multipart request. 
	  public void save(MultipartFile file) {
	    try {
	    	
	    	 System.out.println("File122"+file);
	    	 System.out.println("File1"+file.getInputStream());
	    	 
	      List<Excel> tutorials = com.job.helper.ExcelHelper.excelToTutorials(file.getInputStream());
	      System.out.println("File222"+tutorials);
	      excelRepo.saveAll(tutorials);
	      System.out.println("File33Save");
	    } catch (IOException e) {
	      throw new RuntimeException("fail to store excel data: " + e.getMessage());
	    }
	  }

}
