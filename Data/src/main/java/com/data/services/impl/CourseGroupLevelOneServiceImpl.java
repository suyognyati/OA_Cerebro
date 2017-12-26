package com.data.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.data.entities.CollegeProgramMap;
import com.data.entities.CourseGroupLevelOne;
import com.data.repository.CourseGroupLevelOneJPARepository;
import com.data.services.CollegeProgramMapService;
import com.data.services.CourseGroupLevelOneService;

@Service("courseGroupLevelOneService")
public class CourseGroupLevelOneServiceImpl implements CourseGroupLevelOneService {

	@Autowired
	CourseGroupLevelOneJPARepository courseGroupLevelOneJPARepository;
	
	@Autowired
	CollegeProgramMapService collegeProgramMapService;
	
	
	@Override
	public List<CourseGroupLevelOne> getCourseGroupLevelOneByProgram(Integer collegeProgramId) {
		CollegeProgramMap collegeProgramMap = collegeProgramMapService.getById(collegeProgramId);
		List<CourseGroupLevelOne> courseGroupLevelOneList = null;
		if(collegeProgramMap != null)
			courseGroupLevelOneList = courseGroupLevelOneJPARepository.findByUniversityProgram(collegeProgramMap.getProgram());
		return courseGroupLevelOneList;
	}

}
