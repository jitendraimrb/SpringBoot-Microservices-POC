package com.learning.api.upload;

public class FileUploadResponse {
	
	private String fileName;
	private String downloadUri;
	private Long size;
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public String getDownloadUri() {
		return downloadUri;
	}
	public void setDownloadUri(String downloadUri) {
		this.downloadUri = downloadUri;
	}
	public Long getSize() {
		return size;
	}
	public void setSize(Long size) {
		this.size = size;
	}
	
	

}
