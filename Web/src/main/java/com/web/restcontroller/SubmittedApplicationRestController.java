package com.web.restcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.web.services.SubmittedApplicationRCService;

@RestController
@RequestMapping("/rest/application")
public class SubmittedApplicationRestController {
	
	@Autowired
	SubmittedApplicationRCService submittedApplicationRCService; 
	
	@RequestMapping(value="/deleteAppliedCourse", method = RequestMethod.POST)
	public void applyForCourse(@RequestBody Integer applicationId) {
		submittedApplicationRCService.deleteAppliedCourse(applicationId);
	}
}
