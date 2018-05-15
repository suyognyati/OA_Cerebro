package com.data.services;

import java.util.List;

import com.data.entities.EducationalInformation;
import com.data.entities.QualificationLevel;
import com.data.entities.University_Program;
import com.data.entities.UserDetail;

public interface EducationalInformationService {
	/**
	 * This function give complete educational history of a user.
	 * The information will be in 
	 * <b>ascending order of qualification level</b>
	 */
	List<EducationalInformation> getEducationalHistory(UserDetail userDetail);
	EducationalInformation getByUserDetailAndQualificationLevel(UserDetail userDetail, QualificationLevel qualificationLevel);
	EducationalInformation getByEducationalInformationId(UserDetail userDetail, Integer educationalInformationId);
	Boolean saveEducationalInformation(EducationalInformation educationalInformation);
	Boolean deleteEducationalInformation(UserDetail userDetail, Integer educationalInformationId);
	
	/**
	 * This function will give all allowed qualifications to apply particular program.
	 * The information will be in 
	 * <b>ascending order of qualification level</b>
	 */
	List<EducationalInformation> getAllowedLastQualification(UserDetail userDetail, University_Program program);
	
	/**
	 * This function will give Educational information by id.
	 * The information will be in 
	 * <b>ascending order of qualification level</b>
	 * @param educationalInformationId
	 * @return EducationalInformation
	 */
	EducationalInformation getById(Integer educationalInformationId);
}
