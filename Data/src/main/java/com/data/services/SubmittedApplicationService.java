package com.data.services;

import java.util.List;

import com.data.entities.College;
import com.data.entities.SubmittedApplications;
import com.data.entities.UserDetail;
import com.data.poco.AppliedStudentPOCO;

public interface SubmittedApplicationService {
	public void save(SubmittedApplications application);
	public List<SubmittedApplications> getByUserDetailandCollege(UserDetail userDetail, College college);
	void deleteById(Integer submittedApplicationId);
	List<AppliedStudentPOCO> getAppliedStudentListOfProgram(Integer collegeProgramMapId);
	
	/**
	 * Get application information by ID
	 * @param id
	 * @return SubmittedApplications
	 */
	SubmittedApplications getById(Integer id);
}
