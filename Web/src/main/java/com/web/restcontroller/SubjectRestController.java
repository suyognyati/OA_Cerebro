package com.web.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.web.model.SubjectModel;
import com.web.services.SubjectRCService;
import com.web.session.Session;

@RestController
@RequestMapping("/rest/subject")
public class SubjectRestController {

	@Autowired
	Session session;
	
	@Autowired
	SubjectRCService subjectRCService;	
		
	@RequestMapping(value="/get/{programId}")
	public List<SubjectModel> get(@PathVariable(value="programId") Integer programId){
		return subjectRCService.getSubjectsByProgram(session.getCollegeId(), programId);
	}
}
