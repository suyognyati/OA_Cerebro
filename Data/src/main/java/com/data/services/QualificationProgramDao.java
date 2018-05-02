package com.data.services;

import java.util.List;

import com.data.entities.QualificationLevel;
import com.data.entities.QualificationProgram;

public interface QualificationProgramDao {

	/**
	 * This function will give all available programs for selected qualification
	 * @param qualificationLevel - Qualification level should be a object of selected qualification for which this list is required
	 * @return List&ltQualificationProgram&gt - This will return all available programs of qualification.
	 */
	List<QualificationProgram> getProgramListOfQualification(QualificationLevel qualificationLevel);
}
