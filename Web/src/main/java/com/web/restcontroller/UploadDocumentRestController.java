package com.web.restcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Timed;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.web.model.UploadDocumentModel;
import com.web.services.UploadDocumentRCService;
import com.web.session.Session;

@RestController
public class UploadDocumentRestController {
	
	@Autowired
	Session session;
	
	@Autowired
	UploadDocumentRCService uploadDocumentRCService;
	
	@RequestMapping(value = "/getDocumentList", method = RequestMethod.GET)
	@ResponseBody
	public UploadDocumentModel getDocumentList() {
		
		if(session.getCurrentUser() == null)
			return null;
		
		return uploadDocumentRCService.getUserDocuments(session.getCurrentUser());
	}
	
	@RequestMapping(value = "/getDocument/{userDocumentId}", method = RequestMethod.GET)
	@Timed(millis = 0)
	public @ResponseBody byte[] getDocument(
			@PathVariable(value="userDocumentId") Integer userDocumentId) {
		
		if(session.getCurrentUser() == null)
			return null;
		
	    return uploadDocumentRCService.getDocument(session.getCurrentUser(), userDocumentId);
	}
}
