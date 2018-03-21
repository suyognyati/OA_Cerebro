package com.web.restcontroller;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.util.StringTokenizer;

import javax.imageio.ImageIO;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import sun.misc.BASE64Decoder;

@RestController
@RequestMapping(value="/rest/uploadPhotoSign/")
public class PhotoSignRestController {

	@RequestMapping(value="uploadPhoto/", method=RequestMethod.POST)
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
}
