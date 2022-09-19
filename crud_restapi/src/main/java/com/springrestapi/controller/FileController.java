package com.springrestapi.controller;

import java.io.FileNotFoundException;
import java.net.http.HttpHeaders;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.app.exceptionsHandling.MyFileNotFoundException;
import com.springrestapi.entity.FileUploadingEntity;
import com.springrestapi.errordto.ResourceNotFoundException;
import com.springrestapi.errordto.SuccessResponseDto;
import com.springrestapi.exception.Errordetails;
import com.springrestapi.exception.GlobalExceptionHandler;
import com.springrestapi.service.FileStorageServiceInterface;

@RestController
@RequestMapping("/file")
public class FileController {

	@Autowired
	private FileStorageServiceInterface fileStorageServiceInterface;
	
	@PostMapping("/uploadfile")
	public ResponseEntity<?> uploadFile(@RequestParam MultipartFile file,@RequestParam String type,HttpServletRequest request) throws ResourceNotFoundException
	{
		
		FileUploadingEntity fileUploadingEntity;
		
		System.out.println("FileName is"+file.getOriginalFilename());
		
		if(file.getOriginalFilename().endsWith("pdf") && type.contains("pdf"))
		{
			
		try
		{
			
			fileUploadingEntity=fileStorageServiceInterface.storeFile(file,request,type);	
		}
		catch(Exception e)
		{
			return new ResponseEntity<>(new Errordetails(new Date(),"Invalid Folder Name", "Invalid Name"+e.getLocalizedMessage()),HttpStatus.BAD_GATEWAY);
		}
		
		}else
		{
			
			return new ResponseEntity<>(new Errordetails(new Date(),"Only Pdf is Allowed..", "valid pdf format Limit is Maximum 2MB "),HttpStatus.BAD_GATEWAY);
		}
		
		return new ResponseEntity<>(new SuccessResponseDto("File Upload Successfully", "Upload Successfully", "Successfully upload"),HttpStatus.OK);
		
	}
	
	@GetMapping("/downloadFile/{path}/{fileName:.+}")
	public ResponseEntity<?> downloadFile(@PathVariable String path,@PathVariable String fileName,HttpServletRequest request) throws FileNotFoundException
	{
		
		System.out.print("FileName is :-"+fileName);
		
		
		
		Resource resource=null;
		
		try
		{
			resource=fileStorageServiceInterface.loadFileAsResource(path+"/"+fileName);
		}
		catch(MyFileNotFoundException e)
		{
			return new ResponseEntity<>(new Errordetails(new Date(), "File Not Found", "Not Found"),HttpStatus.NOT_FOUND);
		}
		
		String contentType=null;
		
		try
		{
			contentType=request.getServletContext().getMimeType(resource.getFile().getAbsolutePath());
		}catch(Exception e)
		{
			System.out.println("Could not determine File Type");
		}
		
		if(contentType==null)
		{
			contentType="application/octent-stream";
			
		}
		return ResponseEntity.ok().contentType(MediaType.parseMediaType(contentType)).header(org.springframework.http.HttpHeaders.CONTENT_DISPOSITION,"inline;filename=\""+resource.getFilename()+"\"").body(resource);
		
	}
	
	
}
