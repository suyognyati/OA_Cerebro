package com.data.services;

import java.util.List;

import com.data.entities.College;
import com.data.entities.CollegeProgramMap;

public interface CollegeProgramMapService {

	List<CollegeProgramMap> getCollegeProgramsByCategory(Integer collegeId, Integer programCategoryId);
	List<CollegeProgramMap> getAllProgramsOfCollege(Integer collegeId);
	List<CollegeProgramMap> getAllProgramsOfCollege(College college);
	CollegeProgramMap getById(Integer id);
}
