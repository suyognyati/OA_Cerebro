package com.web.restcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.web.model.AppliedCourseModel;
import com.web.model.SubjectModel;
import com.web.services.CourseRCService;
import com.web.session.Session;

@RestController
@RequestMapping("/rest/subject")
public class CourseRestController {

	@Autowired
	Session session;
	
	@Autowired
	CourseRCService courseRCService;	
		
	@RequestMapping(value="/get/{collegeProgramId}")
	public SubjectModel get(@PathVariable(value="collegeProgramId") Integer collegeProgramId){
		return courseRCService.getSubjectsByCollegeProgram(session.getCollegeId(), collegeProgramId);
	}
	
	@RequestMapping(value="/applyForCourse", method = RequestMethod.POST)
	public void applyForCourse(@RequestBody AppliedCourseModel appliedCourseModel) {
		courseRCService.applyForCourse(appliedCourseModel.getCollegeProgramId(), appliedCourseModel.getSelectedSubjectList());
	}
}
