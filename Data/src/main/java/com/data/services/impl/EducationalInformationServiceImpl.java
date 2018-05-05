package com.data.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.data.entities.EducationalInformation;
import com.data.entities.QualificationLevel;
import com.data.entities.User;
import com.data.repository.EducationalInformationJpaRepository;
import com.data.services.EducationalInformationService;

@Service("educationalInformationService")
public class EducationalInformationServiceImpl implements EducationalInformationService {

	@Autowired
	EducationalInformationJpaRepository educationalInformationJpaRepository;
	
	@Override
	public List<EducationalInformation> getEducationalHistory(User user) {
		return educationalInformationJpaRepository.
				findByUserOrderByQualificationLevelQualificationGroupAscQualificationLevelQualificationSubLevelAsc(user);
	}

	@Override
	public EducationalInformation getByUserAndQualificationLevel(User user, QualificationLevel qualificationLevel) {
		return educationalInformationJpaRepository.getByUserAndQualificationLevel(user, qualificationLevel);
	}
	
	@Override
	public EducationalInformation getByEducationalInformationId(User user, Integer educationalInformationId) {
		return educationalInformationJpaRepository.getByUserAndEducationalInformationId(user, educationalInformationId);
	}
	
	@Override
	public Boolean saveEducationalInformation(EducationalInformation educationalInformation) {
		educationalInformationJpaRepository.save(educationalInformation);
		return true;
	}
	
	@Override
	public Boolean deleteEducationalInformation(User user, Integer educationalInformationId) {
		Boolean success = false;
		EducationalInformation educationalInformation = getByEducationalInformationId(user, educationalInformationId);
		if(educationalInformation != null) {
			educationalInformationJpaRepository.delete(educationalInformationId);
			success = true;
		} else {
			success = false;
		}
		return success;
	}
}
