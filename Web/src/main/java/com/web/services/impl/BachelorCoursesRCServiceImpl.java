package com.web.services.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.web.model.BachelorCoursesModel;
import com.web.services.BachelorCoursesRCService;

@Service("bachelorCoursesRCService")
public class BachelorCoursesRCServiceImpl implements BachelorCoursesRCService {

	
	
	public List<BachelorCoursesModel> getBachelorCourses() {
	
		List<BachelorCoursesModel> bachelorCoursesModelList = new ArrayList<BachelorCoursesModel>();
		
		BachelorCoursesModel bachelorCoursesModel = new BachelorCoursesModel();
		bachelorCoursesModel.setProgramCode("1");
		bachelorCoursesModel.setProgramName("BSc IT");
		bachelorCoursesModel.setFacultyOrCollege("Faculty of Science");
		bachelorCoursesModel.setApplicationDates("22-02-2015");
		bachelorCoursesModelList.add(bachelorCoursesModel);
		
		bachelorCoursesModel = new BachelorCoursesModel();
		bachelorCoursesModel.setProgramCode("2");
		bachelorCoursesModel.setProgramName("BSc Comp Sc");
		bachelorCoursesModel.setFacultyOrCollege("Faculty of Science");
		bachelorCoursesModel.setApplicationDates("22-02-2015");
		bachelorCoursesModelList.add(bachelorCoursesModel);
		
		return bachelorCoursesModelList;
	}
	
	public void saveBachelorCourses(BachelorCoursesModel bachelorCoursesModel) {
		
	}
		
		
}
