package com.web.services;

import java.util.List;

import com.web.model.CourseModel;

public interface CourseRCService {

	List<CourseModel> getBachelorCourses();
	void saveBachelorCourses(CourseModel bachelorCoursesModel);
}
