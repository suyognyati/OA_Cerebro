package com.web.services;

import java.util.List;

import com.data.entities.User;
import com.web.model.EducationModel;
import com.web.model.EducationModel.QualificationDetail;

public interface EducationalInformationRCService {

	List<EducationModel.Qualification> getListofQualification(User user);
	QualificationDetail getQualificationDetail(User user, Integer qualificationMainLevel, Integer qualificationSubLevel);
	QualificationDetail getNewQualification(User user, Integer qualificationMainLevel);
	Boolean saveQualificationDetail(User user, QualificationDetail qualificationDetail);
	
}
