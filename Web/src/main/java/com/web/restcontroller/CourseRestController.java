package com.web.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.web.model.CourseModel;
import com.web.services.CourseRCService;

@RestController
@RequestMapping(value="/rest/course")
public class CourseRestController {

	@Autowired
	CourseRCService courseService;
	
	@RequestMapping(value="/bachelorCourse/get/")
	public List<CourseModel> get(Model model){
		return courseService.getBachelorCourses();
	}
	
	@RequestMapping(value="/bachelorCourse/save/", method=RequestMethod.POST)
	public void save(@RequestBody CourseModel bachelorCoursesModel) {
		courseService.saveBachelorCourses(bachelorCoursesModel);
	}
	
}
