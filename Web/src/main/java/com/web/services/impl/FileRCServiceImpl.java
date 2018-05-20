package com.web.services.impl;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.data.entities.User;
import com.web.services.FileRCService;
import com.web.staticandconstants.StaticMembers;

@Service("fileRCService")
public class FileRCServiceImpl implements FileRCService{

	@Override
	public Object saveFile(User user, MultipartFile inputFile) {
		String rootDirectory = getPath(user);
		//System.out.println("Root Directory "+rootDirectory);
		String fileName = getFileName(inputFile); //inputFile.getOriginalFilename();
        //System.out.println(fileName);
        try {
			      
	        //java.nio.file.Path path = Paths.get("G:\\Projects\\Production_Workspace\\UploadFiles\\" + fileName);
	        java.nio.file.Path folderPath = Paths.get(rootDirectory);
	        java.nio.file.Path filePath = Paths.get(rootDirectory + fileName);
	        Files.createDirectories(folderPath);
	        Files.deleteIfExists(filePath);
	        InputStream in = inputFile.getInputStream();
	        Files.copy(in, filePath);
	        
			//mFile.transferTo(new File(rootDirectory  + mFile.getOriginalFilename()));
		} catch (IllegalStateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		return null;
	}

	private String getPath(User user) {
		String rootDirectory = StaticMembers.UploadDocumentPath + File.separator + user.getUserId()+ File.separator;
		return rootDirectory;
	}
	
	private String getFileName(MultipartFile inputFile) {
		String fileName = inputFile.getOriginalFilename();
		
		return fileName;
	}
}
