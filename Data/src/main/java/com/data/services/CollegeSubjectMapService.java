package com.data.services;

import java.util.List;

import com.data.entities.CollegeSubjectMap;

public interface CollegeSubjectMapService {

	List<CollegeSubjectMap> getCollegeSubjectsByProgram(Integer collegeId, Integer programId);
}
