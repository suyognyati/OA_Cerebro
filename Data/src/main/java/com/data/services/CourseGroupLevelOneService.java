package com.data.services;

import java.util.List;

import com.data.entities.CourseGroupLevelOne;

public interface CourseGroupLevelOneService {

	List<CourseGroupLevelOne> getCourseGroupLevelOneByProgram(Integer programId);
}
