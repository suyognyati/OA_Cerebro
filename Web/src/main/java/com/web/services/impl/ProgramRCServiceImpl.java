package com.web.services.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.web.model.CourseModel;
import com.web.services.ProgramRCService;

@Service("programRCService")
public class ProgramRCServiceImpl implements ProgramRCService {

	
	
	public List<CourseModel> getProgramsByCategory(Integer programCategoryId) {
	
		List<CourseModel> bachelorCoursesModelList = new ArrayList<CourseModel>();
		
		CourseModel bachelorCoursesModel = new CourseModel();
		bachelorCoursesModel.setProgramCode("1");
		bachelorCoursesModel.setProgramName("BSc IT");
		bachelorCoursesModel.setFacultyOrCollege("Faculty of Science");
		bachelorCoursesModel.setApplicationDates("22-02-2015");
		bachelorCoursesModel.setId(1);
		bachelorCoursesModelList.add(bachelorCoursesModel);
		
		bachelorCoursesModel = new CourseModel();
		bachelorCoursesModel.setProgramCode("2");
		bachelorCoursesModel.setProgramName("BSc Comp Sc");
		bachelorCoursesModel.setFacultyOrCollege("Faculty of Science");
		bachelorCoursesModel.setApplicationDates("22-02-2015");
		bachelorCoursesModel.setId(2);
		bachelorCoursesModelList.add(bachelorCoursesModel);
		
		return bachelorCoursesModelList;
	}
	
	public void saveBachelorCourses(CourseModel bachelorCoursesModel) {
		
	}
		
		
}
