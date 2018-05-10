package com.data.services;

import java.util.List;

import com.data.entities.College;
import com.data.entities.CollegeSubjectMap;
import com.data.entities.University_Program;
import com.data.entities.University_Subject;

public interface CollegeSubjectMapService {

	List<CollegeSubjectMap> getCollegeSubjectsByProgram(Integer collegeId, Integer programId);
	
	List<University_Subject> getAvailableSubjectsForCollege(College college, University_Program program);
}
