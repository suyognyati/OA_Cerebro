package com.data.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.data.entities.SubmittedApplications;
import com.data.repository.SubmittedApplicationsJPARepository;
import com.data.services.SubmittedApplicationService;

@Service("submittedApplicationService")
public class SubmittedApplicationServiceImpl implements SubmittedApplicationService {

	@Autowired
	SubmittedApplicationsJPARepository submittedApplicationsJPARepository;
	
	@Override
	public void save(SubmittedApplications application) {
		submittedApplicationsJPARepository.save(application);
	}

}
