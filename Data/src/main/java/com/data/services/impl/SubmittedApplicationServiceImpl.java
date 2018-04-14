package com.data.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.data.entities.College;
import com.data.entities.SubmittedApplications;
import com.data.entities.User;
import com.data.poco.AppliedStudentPOCO;
import com.data.repository.SubmittedApplicationsJpaRepository;
import com.data.services.SubmittedApplicationService;

@Service("submittedApplicationService")
public class SubmittedApplicationServiceImpl implements SubmittedApplicationService {

	@Autowired
	SubmittedApplicationsJpaRepository submittedApplicationsJpaRepository;
	
	@Override
	public void save(SubmittedApplications application) {
		submittedApplicationsJpaRepository.save(application);
	}

	@Override
	public List<SubmittedApplications> getByUserandCollege(User user, College college) {
		return submittedApplicationsJpaRepository.findByUserAndCollegeProgramMapCollege(user, college);
	}

	@Override
	public void deleteById(Integer submittedApplicationId) {
		submittedApplicationsJpaRepository.delete(submittedApplicationId);
	}

	@Override
	public List<AppliedStudentPOCO> getAppliedStudentListOfProgram(Integer collegeProgramMapId) {
		return submittedApplicationsJpaRepository.getMeritStudents(collegeProgramMapId);
	}
}
