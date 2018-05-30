package com.web.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.data.services.CollegeProgramMapService;
import com.data.services.ApplicationService;
import com.web.services.ApplicationRCService;

@Service("applicationRCService")
public class ApplicationRCServiceImpl implements ApplicationRCService {

	@Autowired
	CollegeProgramMapService collegeProgramMapService;
	
	@Autowired
	ApplicationService applicationService;
	
	@Override
	public void deleteAppliedCourse(Integer applicationId) {
		applicationService.deleteById(applicationId);	
	}

}
