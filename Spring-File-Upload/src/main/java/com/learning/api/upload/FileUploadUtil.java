package com.learning.api.upload;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import org.springframework.web.multipart.MultipartFile;

public class FileUploadUtil {
	
	public static void saveFile(String fileName, MultipartFile multipartFile) throws IOException {
		
		Path uploadDirectoryPath = Paths.get("Files-Upload");
		
		if (!Files.exists(uploadDirectoryPath)) {
            Files.createDirectories(uploadDirectoryPath);
        }
		
//		String fileCode = RandomStringUtils.randomAlphanumeric(8);
		try(InputStream inputStream = multipartFile.getInputStream()){
			Path filePath = uploadDirectoryPath.resolve(fileName);
			Files.copy(inputStream, filePath, StandardCopyOption.REPLACE_EXISTING);
			
		}catch(IOException ioe) {
			throw new IOException("Error in saving the upload file "+ fileName, ioe);
		}
		
	}

}
