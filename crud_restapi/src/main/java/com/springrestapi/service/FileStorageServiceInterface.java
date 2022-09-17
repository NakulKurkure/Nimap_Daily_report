package com.springrestapi.service;

import java.io.FileNotFoundException;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;

import com.app.exceptionsHandling.ResourceNotFoundException;
import com.springrestapi.entity.FileUploadingEntity;

public interface FileStorageServiceInterface {

//	public String getFolderName(String type) throws ResourceNotFoundException, com.springrestapi.errordto.ResourceNotFoundException;

//	FileUploadingEntity storeFile(MultipartFile file, String type, HttpServletRequest request) throws com.springrestapi.errordto.ResourceNotFoundException, IOException;

//	public FileUploadingEntity storeFile() throws com.springrestapi.errordto.ResourceNotFoundException, IOException;

//	public FileUploadingEntity storeFile(MultipartFile file,HttpServletRequest request,String type) throws com.springrestapi.errordto.ResourceNotFoundException;

//	public FileUploadingEntity storeFile() throws com.springrestapi.errordto.ResourceNotFoundException;

	public FileUploadingEntity storeFile(MultipartFile file, HttpServletRequest request, String type) throws com.springrestapi.errordto.ResourceNotFoundException;

	public Resource loadFileAsResource(String string) throws FileNotFoundException;

	

	
}
