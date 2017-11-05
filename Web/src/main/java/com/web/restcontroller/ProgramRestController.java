package com.web.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.web.model.ProgramModel;
import com.web.services.ProgramRCService;
import com.web.session.Session;

@RestController
@RequestMapping(value="/rest/program")
public class ProgramRestController {

	@Autowired
	Session session;
	
	@Autowired
	ProgramRCService programService;
	
	@RequestMapping(value="/get/{programCategoryId}")
	public List<ProgramModel> get(@PathVariable(value="programCategoryId") Integer programCategoryId){
		return programService.getProgramsByCategory(session.getCollegeId(), programCategoryId);
	}
		
}
