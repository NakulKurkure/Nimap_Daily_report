package com.springrestapi.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@ConfigurationProperties(prefix="file")
public class FileStorageUploadProperty {

	public FileStorageUploadProperty() {
		super();

	}

	public static String getUploadDir() {
		return uploadDir;
	}

	public void setUploadDir(String uploadDir) {
		this.uploadDir = uploadDir;
	}

	private static  String uploadDir;
	
	
}
