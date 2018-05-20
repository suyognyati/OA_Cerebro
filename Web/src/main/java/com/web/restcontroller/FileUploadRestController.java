package com.web.restcontroller;

import static java.nio.file.StandardOpenOption.CREATE_NEW;
import static java.nio.file.StandardOpenOption.WRITE;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.OpenOption;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.StringTokenizer;

import javax.imageio.ImageIO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Timed;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.web.model.UploadDocumentModel;
import com.web.services.FileRCService;
import com.web.services.UploadDocumentRCService;
import com.web.session.Session;
import com.web.staticandconstants.StaticMembers;

import sun.misc.BASE64Decoder;

@RestController
public class FileUploadRestController {
	
	@Autowired
	Session session;
	
	@Autowired
	FileRCService fileRCService;
	
	@Autowired
	UploadDocumentRCService uploadDocumentRCService;
	
	@RequestMapping(value="/rest/uploadPhotoSign/uploadPhoto/", method=RequestMethod.POST)
	public void save(@RequestBody String photo) {
		String sourceData = photo;
		System.out.println(sourceData);
		
		//def sourceData = 'data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAAPAAAADwCAYAAAA+VemSAAAgAEl...==';

		// tokenize the data
		StringTokenizer strtok = new StringTokenizer(sourceData, ",");
		int tokencount = strtok.countTokens();
		String[] parts = new String[tokencount];
		int count = 0;
		while(strtok.hasMoreTokens()) {
			parts[count] = strtok.nextToken();
			count++;
		}

		String imageString = parts[1];

		// create a buffered image
		BufferedImage image = null;
		byte[] imageByte;

		BASE64Decoder decoder = new BASE64Decoder();
		try {
			imageByte = decoder.decodeBuffer(imageString);
			ByteArrayInputStream bis = new ByteArrayInputStream(imageByte);
			image = ImageIO.read(bis);
			bis.close();
			// write the image to a file
			File outputfile = new File("d:\\admissions\\1\\image.jpg");
			if(outputfile.mkdirs())
				ImageIO.write(image, "jpg", outputfile);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@RequestMapping(value = "/getDocumentList", method = RequestMethod.GET)
	@ResponseBody
	public UploadDocumentModel getDocumentList() {
		
		if(session.getStudent() == null)
			return null;
		
		return uploadDocumentRCService.getUserDocuments(session.getStudent());
	}
	
	@RequestMapping(value = "/getDocument/{userDocumentId}", method = RequestMethod.GET)
	@Timed(millis = 0)
	public @ResponseBody byte[] getDocument(
			@PathVariable(value="userDocumentId") Integer userDocumentId) {
		
		if(session.getStudent() == null)
			return null;
		
	    return uploadDocumentRCService.getDocument(session.getStudent(), userDocumentId);
	}
	
	@RequestMapping(value = "/saveSingleFile", method = RequestMethod.POST)
	@ResponseBody
	public Object saveSingleFile( @RequestParam(value = "path") String strpath, 
			@RequestParam(value = "file") MultipartFile mFile) {
		
		if(session.getStudent() == null)
			return null;
		
		StaticMembers.UploadDocumentPath = strpath;
		
		return fileRCService.saveFile(session.getStudent(), mFile);
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
		String rootDirectory = StaticMembers.UploadDocumentPath + File.separator + session.getStudent().getUserId()+ File.separator;
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
