package com.learning.api.upload;

import java.io.IOException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/v1/file/uploader")
public class FileUploadController {
	
	
	@PostMapping(value="/uploadFile")
	public ResponseEntity<FileUploadResponse> uploadFile(@RequestParam("file") MultipartFile multipartFile) throws IOException{
		
		String fileName = StringUtils.cleanPath(multipartFile.getOriginalFilename());
		long size = multipartFile.getSize();
		FileUploadUtil.saveFile(fileName, multipartFile);
		FileUploadResponse response = new FileUploadResponse();
		response.setFileName(fileName);
		response.setSize(size);
		response.setDownloadUri("/downloadFile/"+fileName);
		
		return new ResponseEntity<>(response, HttpStatus.OK);	
		
		
		
		
	}

}
