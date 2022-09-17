package com.springrestapi.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.springrestapi.Helper.ExcelHelper;
import com.springrestapi.errordto.ResourceNotFoundException;
import com.springrestapi.errordto.SuccessResponseDto;
import com.springrestapi.exception.Errordetails;
import com.springrestapi.service.ExcelServiceInterface;

@RestController

@RequestMapping("/excel")
public class ExcelControlller {

	@Autowired
	private ExcelServiceInterface excelServiceInterface;

	
	
	@PostMapping("/upload")
	  public ResponseEntity<?> uploadFile(@RequestParam MultipartFile file) throws ResourceNotFoundException {
		String message="";
		
		if (ExcelHelper.hasExcelFormat(file)) {
		      try {
		    	  System.out.println("File"+file);
		    	  excelServiceInterface.save(file);
		    	  System.out.println("File2"+message);
		   
		        
		        System.out.println("File2333"+message);
		        return new ResponseEntity<>(new SuccessResponseDto("Successfully Uploaded", "Uploaded", "Uploaded"),HttpStatus.OK);
		      } catch (Exception e) {
		       
		        return new ResponseEntity<>(new Errordetails(new Date(),"Could not upload the file..", "Could not upload the file "),HttpStatus.BAD_GATEWAY);
		      }
		    }

		  
		    return new ResponseEntity<>(new Errordetails(new Date(),"Please upload an excel file..", "Please upload an excel file"),HttpStatus.BAD_GATEWAY);

	}
	
	
}
