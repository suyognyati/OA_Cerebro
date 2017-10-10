package com.web.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.web.model.BachelorCoursesModel;
import com.web.services.BachelorCoursesRCService;

@RestController
@RequestMapping(value="/bachelorCourses")
public class BachelorCoursesRestController {

	@Autowired
	BachelorCoursesRCService bachelorCoursesService;
	
	@RequestMapping(value="/get/")
	public List<BachelorCoursesModel> get(Model model){
		return bachelorCoursesService.getBachelorCourses();
	}
	
	@RequestMapping(value="/save/", method=RequestMethod.POST)
	public void save(@RequestBody BachelorCoursesModel bachelorCoursesModel) {
		bachelorCoursesService.saveBachelorCourses(bachelorCoursesModel);
	}
}
