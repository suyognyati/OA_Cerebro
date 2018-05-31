package com.data.services;

import java.util.List;

import com.data.entities.EducationalInformation;
import com.data.entities.QualificationLevel;
import com.data.entities.University_Program;
import com.data.entities.Student;

public interface EducationalInformationService {
	/**
	 * This function give complete educational history of a user.
	 * The information will be in 
	 * <b>ascending order of qualification level</b>
	 */
	List<EducationalInformation> getEducationalHistory(Student student);
	EducationalInformation getByStudentAndQualificationLevel(Student student, QualificationLevel qualificationLevel);
	EducationalInformation getByEducationalInformationId(Student student, Integer educationalInformationId);
	Boolean saveEducationalInformation(EducationalInformation educationalInformation);
	Boolean deleteEducationalInformation(Student student, Integer educationalInformationId);
	
	/**
	 * This function will give all allowed qualifications to apply particular program.
	 * The information will be in 
	 * <b>ascending order of qualification level</b>
	 */
	List<EducationalInformation> getAllowedLastQualification(Student student, University_Program program);
	
	/**
	 * This function will give Educational information by id.
	 * The information will be in 
	 * <b>ascending order of qualification level</b>
	 * @param educationalInformationId
	 * @return EducationalInformation
	 */
	EducationalInformation getById(Integer educationalInformationId);
}
