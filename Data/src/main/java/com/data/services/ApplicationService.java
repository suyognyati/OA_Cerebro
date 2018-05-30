package com.data.services;

import java.util.List;

import com.data.entities.College;
import com.data.entities.Application;
import com.data.entities.UserDetail;
import com.data.poco.AppliedStudentPOCO;

public interface ApplicationService {
	public void save(Application application);
	public List<Application> getByUserDetailandCollege(UserDetail userDetail, College college);
	void deleteById(Integer applicationId);
	List<AppliedStudentPOCO> getAppliedStudentListOfProgram(Integer collegeProgramMapId);
	
	/**
	 * Get application information by ID
	 * @param id
	 * @return Applications
	 */
	Application getById(Integer id);
}
