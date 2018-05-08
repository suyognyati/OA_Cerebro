package com.data.services;

import java.util.List;

import com.data.entities.EducationalInformation;
import com.data.entities.QualificationLevel;
import com.data.entities.University_Program;
import com.data.entities.User;

public interface EducationalInformationService {
	/**
	 * This function give complete educational history of a user.
	 * The information will be in 
	 * <b>ascending order of qualification level</b>
	 */
	List<EducationalInformation> getEducationalHistory(User user);
	EducationalInformation getByUserAndQualificationLevel(User user, QualificationLevel qualificationLevel);
	EducationalInformation getByEducationalInformationId(User user, Integer educationalInformationId);
	Boolean saveEducationalInformation(EducationalInformation educationalInformation);
	Boolean deleteEducationalInformation(User user, Integer educationalInformationId);
	
	/**
	 * This function will give all allowed qualifications to apply particular program.
	 * The information will be in 
	 * <b>ascending order of qualification level</b>
	 */
	List<EducationalInformation> getAllowedLastQualification(User user, University_Program program);
	
	/**
	 * This function will give Educational information by id.
	 * The information will be in 
	 * <b>ascending order of qualification level</b>
	 * @param educationalInformationId
	 * @return EducationalInformation
	 */
	EducationalInformation getById(Integer educationalInformationId);
}
