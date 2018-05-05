package com.web.services;

import java.util.List;

import com.data.entities.User;
import com.web.model.EducationModel;
import com.web.model.EducationModel.QualificationDetail;

public interface EducationalInformationRCService {

	List<EducationModel.Qualification> getListofQualification(User user);
	QualificationDetail getQualificationDetail(User user, Integer qualificationGroupLevel);
	QualificationDetail getNewQualification(User user, Integer qualificationGroup);
	Boolean saveQualificationDetail(User user, QualificationDetail qualificationDetail);
	Boolean deleteQualificationDetail(User user, Integer qualificationId);
	
}
