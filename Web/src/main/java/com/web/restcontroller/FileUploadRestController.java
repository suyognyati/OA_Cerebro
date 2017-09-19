package com.web.restcontroller;

import static java.nio.file.StandardOpenOption.CREATE_NEW;
import static java.nio.file.StandardOpenOption.WRITE;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.OpenOption;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Timed;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.web.services.FileRCService;
import com.web.session.Session;
import com.web.session.StaticMethods;

@RestController
public class FileUploadRestController {
	
	@Autowired
	Session session;
	
	@Autowired
	FileRCService fileRCService;
	
	@RequestMapping(value = "/saveSingleFile", method = RequestMethod.POST)
	@ResponseBody
	public Object saveSingleFile( @RequestParam(value = "path") String strpath, 
			@RequestParam(value = "file") MultipartFile mFile) {
		
		if(session.getCurrentUser() == null)
			return null;
		
		StaticMethods.UploadDocumentPath = strpath;
		
		return fileRCService.saveFile(session.getCurrentUser(), mFile);
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

	@RequestMapping(value = "/savePDFFile", method = RequestMethod.POST)
	@ResponseBody
	public Object savePDFFile( @RequestParam(value = "path") String strpath, 
			@RequestParam(value = "file") byte[] pdfData) {
		String rootDirectory = StaticMethods.UploadDocumentPath + File.separator + session.getCurrentUser().getUserId()+ File.separator;
		Path pdfSavePath = Paths.get(rootDirectory + "abc.pdf");
		OpenOption[] options = new OpenOption[] { WRITE, CREATE_NEW };
		try {
			Files.deleteIfExists(pdfSavePath);
	        Files.write(pdfSavePath, pdfData, options);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	@RequestMapping(value = "/showPdf", method = RequestMethod.GET)
	@Timed(millis = 0)
	public @ResponseBody byte[] getOpenedEventsInPdf(/*HttpServletResponse response*/) {
		/*response.setHeader("Content-Disposition", "inline; filename=file.pdf");
	    response.setContentType("application/pdf");*/
	    Path pdfPath = Paths.get("D:\\invoice_1942217264.pdf");
	    byte[] pdfFile = null;
	    try {
			pdfFile = Files.readAllBytes(pdfPath);
	    } catch (IOException e) {
			
	    }
	    return pdfFile;
	}
}
