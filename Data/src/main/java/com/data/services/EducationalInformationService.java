package com.data.services;

import java.util.List;

import com.data.entities.EducationalInformation;
import com.data.entities.User;

public interface EducationalInformationService {
	List<EducationalInformation> getByUserOrderByQualificationLevelAsc(User user);
}
