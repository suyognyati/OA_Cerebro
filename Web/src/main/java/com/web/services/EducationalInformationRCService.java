package com.web.services;

import java.util.List;

import com.data.entities.User;
import com.web.model.EducationModel;
import com.web.model.EducationModel.QualificationDetail;

public interface EducationalInformationRCService {

	/**
	 * This function will give Educational history of user
	 * @param user
	 * @return
	 */
	List<EducationModel.Qualification> getListofQualification(User user);
	/**
	 * This function will give all allowed previous qualifications for given program
	 * @param user
	 * @param program
	 * @return
	 */
	List<EducationModel.Qualification> getAllowedQualificationsForProgram(User user, Integer collegeProgramMapId);	
	QualificationDetail getQualificationDetail(User user, Integer qualificationGroupLevel);
	QualificationDetail getNewQualification(User user, Integer qualificationGroup);
	Boolean saveQualificationDetail(User user, QualificationDetail qualificationDetail);
	Boolean deleteQualificationDetail(User user, Integer qualificationId);
	
}
