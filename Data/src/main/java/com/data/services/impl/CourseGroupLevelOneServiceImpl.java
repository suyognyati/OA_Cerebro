package com.data.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.data.entities.CourseGroupLevelOne;
import com.data.entities.University_Program;
import com.data.repository.CourseGroupLevelOneJPARepository;
import com.data.services.CourseGroupLevelOneService;
import com.data.services.University_ProgramService;

@Service("courseGroupLevelOneService")
public class CourseGroupLevelOneServiceImpl implements CourseGroupLevelOneService {

	@Autowired
	CourseGroupLevelOneJPARepository courseGroupLevelOneJPARepository;
	
	@Autowired
	University_ProgramService university_ProgramService;
	
	
	@Override
	public List<CourseGroupLevelOne> getCourseGroupLevelOneByProgram(Integer programId) {
		University_Program program = university_ProgramService.getById(programId);
		List<CourseGroupLevelOne> courseGroupLevelOneList = courseGroupLevelOneJPARepository.findByUniversityProgram(program);
		return courseGroupLevelOneList;
	}

}
