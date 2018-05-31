package com.data.services;

import java.util.List;

import com.data.entities.Application;
import com.data.entities.College;
import com.data.entities.Student;
import com.data.poco.AppliedStudentPOCO;

public interface ApplicationService {
	public Application save(Application application);
	public List<Application> getByStudentandCollege(Student student, College college);
	void deleteById(Integer applicationId);
	List<AppliedStudentPOCO> getAppliedStudentListOfProgram(Integer collegeProgramMapId);
	
	/**
	 * Get application information by ID
	 * @param id
	 * @return Applications
	 */
	Application getById(Integer id);
}
