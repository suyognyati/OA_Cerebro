package com.web.services;

import java.util.List;

import com.data.entities.User;
import com.web.model.EducationModel;

public interface EducationalInformationRCService {

	List<EducationModel.Qualification> getListofQualification();
	EducationModel.QualificationDetail getQualificationDetail(User user, Integer qualificationLevelId);
	
}
