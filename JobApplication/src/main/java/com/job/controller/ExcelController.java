package com.job.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.job.dto.AuthSuccessDto;
import com.job.dto.ErrorResponseDto;
import com.job.helper.ExcelHelper;
import com.job.serviceInterface.ExcelServiceInterface;

@RestController
//@RequestMapping("/api")
public class ExcelController {

	@Autowired
	public ExcelServiceInterface excelServiceInterface;
	
//	@Autowired
	public ExcelHelper excelHelper;
	
	
	@PostMapping("/excelupload")
	  public ResponseEntity<?> uploadFile(@RequestParam MultipartFile file) throws com.job.exception.ResourceNotFoundException {
		String message="";
		
		
		//check Excel format or not
		if (ExcelHelper.hasExcelFormat(file)) {
		      try {
		    	  System.out.println("File"+file);
		    	  excelServiceInterface.save(file);
		    	  System.out.println("File2"+message);
		   
		        
		        System.out.println("File2333"+message);
		        return new ResponseEntity<>(new AuthSuccessDto("Successfully Uploaded", "Uploaded", "Uploaded"),HttpStatus.OK);
		      } catch (Exception e) {
		       
		        return new ResponseEntity<>(new ErrorResponseDto("Could not upload the file..", "Could not upload the file "),HttpStatus.BAD_GATEWAY);
		      }
		    }

		  
		    return new ResponseEntity<>(new ErrorResponseDto("Please upload an excel file..", "Please upload an excel file"),HttpStatus.BAD_GATEWAY);

	}
	
}
