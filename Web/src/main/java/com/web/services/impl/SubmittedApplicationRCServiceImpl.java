package com.web.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.data.services.CollegeProgramMapService;
import com.data.services.SubmittedApplicationService;
import com.web.services.SubmittedApplicationRCService;

@Service("submittedApplicationRCService")
public class SubmittedApplicationRCServiceImpl implements SubmittedApplicationRCService {

	@Autowired
	CollegeProgramMapService collegeProgramMapService;
	
	@Autowired
	SubmittedApplicationService submittedApplicationService;
	
	@Override
	public void deleteAppliedCourse(Integer applicationId) {
		submittedApplicationService.deleteById(applicationId);	
	}

}
