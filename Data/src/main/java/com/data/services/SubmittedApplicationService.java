package com.data.services;

import java.util.List;

import com.data.entities.College;
import com.data.entities.SubmittedApplications;
import com.data.entities.User;
import com.data.poco.AppliedStudentPOCO;

public interface SubmittedApplicationService {
	public void save(SubmittedApplications application);
	public List<SubmittedApplications> getByUserandCollege(User user, College college);
	void deleteById(Integer submittedApplicationId);
	List<AppliedStudentPOCO> getAppliedStudentListOfProgram(Integer collegeProgramMapId);
}
