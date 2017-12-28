package com.web.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.data.entities.CollegeProgramMap;
import com.data.entities.Enums;
import com.data.entities.SubmittedApplications;
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
	public void newApplication() {
		
		SubmittedApplications submittedApplication = new SubmittedApplications();
		submittedApplication.setApplicationStatus(Enums.ApplicationStatus.Submitted.getId());
		CollegeProgramMap clgprgMap = collegeProgramMapService.getById(1);
		submittedApplication.setCollegeProgramMap(clgprgMap);
		submittedApplication.setFormNo("");
		submittedApplication.setDate("");
		
	}

}
