package com.data.services;

import java.util.List;

import com.data.entities.CollegeProgramMap;

public interface CollegeProgramMapService {

	List<CollegeProgramMap> getCollegeProgramsByCategory(Integer collegeId, Integer programCategoryId);
}
