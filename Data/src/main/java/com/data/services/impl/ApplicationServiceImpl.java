package com.data.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.data.entities.College;
import com.data.entities.Application;
import com.data.entities.UserDetail;
import com.data.poco.AppliedStudentPOCO;
import com.data.repository.ApplicationJpaRepository;
import com.data.services.ApplicationService;

@Service("applicationService")
public class ApplicationServiceImpl implements ApplicationService {

	@Autowired
	ApplicationJpaRepository applicationJpaRepository;
	
	@Override
	public Application save(Application application) {
		return applicationJpaRepository.save(application);
	}
	
	@Override
	public List<Application> getByUserDetailandCollege(UserDetail userDetail, College college) {
		return applicationJpaRepository.findByUserDetailAndCollegeProgramMapCollege(userDetail, college);
	}

	@Override
	public void deleteById(Integer applicationId) {
		applicationJpaRepository.delete(applicationId);
	}

	@Override
	public List<AppliedStudentPOCO> getAppliedStudentListOfProgram(Integer collegeProgramMapId) {
		return applicationJpaRepository.getMeritStudents(collegeProgramMapId);
	}

	
	@Override
	public Application getById(Integer id) {
		return applicationJpaRepository.findOne(id);
	}
	
}
