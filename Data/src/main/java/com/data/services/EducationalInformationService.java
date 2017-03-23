package com.data.services;

import java.util.List;

import com.data.entities.EducationalInformation;
import com.data.entities.QualificationLevel;
import com.data.entities.User;

public interface EducationalInformationService {
	List<EducationalInformation> getByUserOrderByQualificationLevelAsc(User user);
	EducationalInformation getByUserAndQualificationLevel(User user, QualificationLevel qualificationLevel);
	EducationalInformation getByEducationalInformationId(User user, Integer educationalInformationId);
	Boolean saveEducationalInformation(EducationalInformation educationalInformation);
	Boolean deleteEducationalInformation(User user, Integer educationalInformationId);
}
