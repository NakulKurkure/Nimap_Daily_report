package com.springrestapi.serviceImpl;


import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
//import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;


import com.springrestapi.entity.FileUploadingEntity;
import com.springrestapi.errordto.ResourceNotFoundException;
import com.springrestapi.exception.FileStorageException;
import com.springrestapi.properties.FileStorageUploadProperty;
import com.springrestapi.repo.FileUploadRepo;
import com.springrestapi.service.FileStorageServiceInterface;

@Service
public class FileUploadStorageImpl implements FileStorageServiceInterface{

	@Autowired
	private FileUploadRepo fileUploadRepo;
	
	
	private final Path fileLocation ;


	@Override
	public FileUploadingEntity storeFile(MultipartFile file, HttpServletRequest request, String type) throws ResourceNotFoundException {
		// TODO Auto-generated method stub
		
		
		
		
		
		try
		{
			
		System.out.println("In Path1");
		//check path
		String fileName=StringUtils.cleanPath(file.getOriginalFilename());
		System.out.println("In Path1"+file.getOriginalFilename());
		
		//Not start with ..
		if(fileName.contains(".."))
		{
			System.out.println("In Path1 Error");
			
			throw new com.springrestapi.errordto.ResourceNotFoundException("Invalid Path "+fileName);
		}
		

	
		File pathAsFile = new File(this.fileLocation + "/" + type);

		System.out.println("Path4"+pathAsFile+type+fileLocation);
		if (!Files.exists(Paths.get(this.fileLocation + "/" + type))) {

			pathAsFile.mkdir();

		}
		//Copy file to target Location
		Path targetLocation = this.fileLocation.resolve(type + "/" + fileName);
		Files.copy(file.getInputStream(), targetLocation, StandardCopyOption.REPLACE_EXISTING);
		FileUploadingEntity fileUploadingEntity=new FileUploadingEntity();
		System.out.println("In Repo");
		fileUploadingEntity.setFileName(fileName);
		fileUploadingEntity.setMime(file.getContentType());
		fileUploadingEntity.setType(type);
		fileUploadingEntity.setEncoding(request.getCharacterEncoding());
		fileUploadingEntity.setOriginalName(fileName);
		fileUploadingEntity.setSize(file.getSize());
		
		FileUploadingEntity fileUploadingEntity2= fileUploadRepo.save(fileUploadingEntity);
		return fileUploadingEntity2;
		
		}catch(IOException e)
		{
			throw new com.springrestapi.errordto.ResourceNotFoundException("Not Valid Path and Store file"+file+e.getMessage());
		}
		
		
		
	}

	@Autowired
	public FileUploadStorageImpl(FileStorageUploadProperty  fileLocation) throws FileStorageException {
		super();
		this.fileLocation = Paths.get(FileStorageUploadProperty.getUploadDir()).toAbsolutePath().normalize();
		
		try {
			Files.createDirectories(this.fileLocation);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			
			e.printStackTrace();
			throw new FileStorageException("Could not create Directory where file is saved");
		}
	}

	@Override
	public Resource loadFileAsResource(String fileName) throws FileNotFoundException {
		// TODO Auto-generated method stub
		
		try
		{
			//check fileLocation First Exist or not
			System.out.println("FileLocation"+fileLocation);
			Path filePath=this.fileLocation.resolve(fileName).normalize();
			Resource resource=new UrlResource(filePath.toUri());
			if(resource.exists())
			{
				return resource;
			}
			else
			{
				throw new FileNotFoundException("File Not Found");
			}
			
		}catch (MalformedURLException e) {
			// TODO: handle exception
			throw new FileNotFoundException("File Not Found");
		}
		
	}



}
