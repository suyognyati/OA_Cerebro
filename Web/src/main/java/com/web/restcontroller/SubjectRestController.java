package com.web.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.web.model.SubjectModel;
import com.web.services.SubjectRCService;

@RestController
@RequestMapping("/rest/subject")
public class SubjectRestController {

	@Autowired
	SubjectRCService subjectRCService;
	
	@RequestMapping(value="/bachelorCourse/get/", method=RequestMethod.POST)
	public List<SubjectModel> get(@RequestBody Integer courseId) {
		List<SubjectModel> subjectModelList = subjectRCService.getBachelorSubject(courseId);
		return subjectModelList;
	}	
}
