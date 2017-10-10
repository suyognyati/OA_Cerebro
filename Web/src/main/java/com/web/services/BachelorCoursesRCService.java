package com.web.services;

import java.util.List;

import com.web.model.BachelorCoursesModel;

public interface BachelorCoursesRCService {

	List<BachelorCoursesModel> getBachelorCourses();
	void saveBachelorCourses(BachelorCoursesModel bachelorCoursesModel);
}
