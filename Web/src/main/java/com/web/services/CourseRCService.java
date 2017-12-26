package com.web.services;

import java.util.List;

import com.data.entities.University_Subject;
import com.web.model.SubjectModel;

public interface CourseRCService {

	SubjectModel getSubjectsByCollegeProgram(Integer collegeId, Integer programId);
	void applyForCourse(Integer collegeProgramMapId, List<University_Subject> selectedSubjectList);
}
