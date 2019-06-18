package com.spring.model;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "file")
public class FileStorageProperties {
    private String uploadDir;

    public String getUploadDir() {
        return uploadDir;
    }

    public void setUploadDir(String uploadDir) {
        this.uploadDir = uploadDir;
    }

	public FileStorageProperties(String uploadDir) {
		super();
		this.uploadDir = uploadDir;
	}

	public FileStorageProperties() {
		super();
		// TODO Auto-generated constructor stub
	}
    
    
    
}