package com.web.restcontroller;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@RequestMapping("/subject")
public class SubjectRestController {

	@RequestMapping(value="/bachelorCourse/apply/", method=RequestMethod.POST)
	public void apply(@RequestBody Integer courseId) {
		// courseService.getSubjects(courseId);
	}
}
