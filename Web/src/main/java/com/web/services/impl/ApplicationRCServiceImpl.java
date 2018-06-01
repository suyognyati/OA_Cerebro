package com.web.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.data.entities.Application;
import com.data.entities.Enums;
import com.data.entities.StudentSelectedSubject;
import com.data.services.ApplicationService;
import com.data.services.CollegeProgramMapService;
import com.data.services.StudentSelectedSubjectsDao;
import com.web.services.ApplicationRCService;

@Service("applicationRCService")
public class ApplicationRCServiceImpl implements ApplicationRCService {

	@Autowired
	CollegeProgramMapService collegeProgramMapService;
	
	@Autowired
	ApplicationService applicationService;
	
	@Autowired
	StudentSelectedSubjectsDao studentSelectedSubjectsDao;
	
	@Override
	public Boolean deleteAppliedCourse(Integer applicationId) {
		Application application = applicationService.getById(applicationId);
		if(application != null) {
			Enums.ApplicationStatus applicationStatus = Enums.ApplicationStatus.get(application.getApplicationStatus());
			if(applicationStatus.getSequenceNo() <= Enums.ApplicationStatus.Partial.getSequenceNo()) { 
				List<StudentSelectedSubject> studentSelectedSubjects = studentSelectedSubjectsDao.getSelectedSubjectOfApplication(applicationId);
				studentSelectedSubjectsDao.deleteBySelectedSubjectList(studentSelectedSubjects);
				applicationService.deleteById(applicationId);
				return true;
			}
		}
		return false;
	}

}
