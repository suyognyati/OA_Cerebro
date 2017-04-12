package com.web.restcontroller;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
public class FileUploadRestController {
	@RequestMapping(value = "/saveSingleFile", method = RequestMethod.POST)
	@ResponseBody
	public Object saveSingleFile( @RequestParam(value = "path") String strpath, 
			@RequestParam(value = "file") MultipartFile mFile) {
		
		String rootDirectory = "D:\\";
		System.out.println("Root Directory "+rootDirectory);
		try {
			String fileName = mFile.getOriginalFilename();
	        System.out.println(fileName);
	              
	        //java.nio.file.Path path = Paths.get("G:\\Projects\\Production_Workspace\\UploadFiles\\" + fileName);
	        java.nio.file.Path path = Paths.get(strpath + fileName);
	        Files.deleteIfExists(path);
	        InputStream in = mFile.getInputStream();
	        Files.copy(in, path);
	        
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
	
	@RequestMapping(value = "/saveMultipleFile", method = RequestMethod.POST)
	@ResponseBody
	public Object saveMultipleFile( @RequestParam(value = "path") String strpath, 
			@RequestParam(value = "file") MultipartFile[] mFileList) {
		
		String rootDirectory = "D:\\";
		System.out.println("Root Directory "+rootDirectory);
		try {
			for(MultipartFile mFile : mFileList) {
				String fileName = mFile.getOriginalFilename();
		        System.out.println(fileName);
		              
		        //java.nio.file.Path path = Paths.get("G:\\Projects\\Production_Workspace\\UploadFiles\\" + fileName);
		        java.nio.file.Path path = Paths.get(strpath + fileName);
		        Files.deleteIfExists(path);
		        InputStream in = mFile.getInputStream();
		        Files.copy(in, path);
			}
	        
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
}
