package com.web.services;

import java.util.List;

import com.data.entities.College;
import com.data.entities.University_Subject;
import com.data.entities.User;
import com.web.model.AppliedCourseModel;
import com.web.model.SubjectModel;

public interface CourseRCService {

	SubjectModel getSubjectsByCollegeProgram(Integer collegeId, Integer programId);
	void applyForCourse(User user, Integer collegeProgramMapId, Integer selectedAllowedQualification, List<University_Subject> selectedSubjectList);
	List<AppliedCourseModel> getAppliedCourseDetails(User user, College College);
}
