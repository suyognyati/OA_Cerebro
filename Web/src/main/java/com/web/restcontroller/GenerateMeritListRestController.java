package com.web.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.web.model.GenerateMeritListModel;
import com.web.model.ProgramCategoriesModel;
import com.web.model.ProgramModel;
import com.web.services.GenerateMeritListRCService;
import com.web.services.ProgramCategoryRCService;
import com.web.services.ProgramRCService;
import com.web.session.Session;

@RestController
@RequestMapping(value="/generateMeritList")

public class GenerateMeritListRestController {

	@Autowired
	Session session;
	
	@Autowired
	ProgramCategoryRCService programCategoryRCService;
	
	@Autowired
	ProgramRCService programService;
	
	@Autowired
	GenerateMeritListRCService generateMeritListRCService;
	
	@RequestMapping(value="/programCategories/get/")
	public List<ProgramCategoriesModel> get(Model model){
		return programCategoryRCService.getProgramCategories();
	}
	
	@RequestMapping(value="/getPrograms/{programCategoryId}")
	public List<ProgramModel> getPrograms(@PathVariable(value="programCategoryId") Integer programCategoryId){
		return programService.getProgramsByCategory(session.getCollegeId(), programCategoryId);
	}
	
	@RequestMapping(value="/getMeritList/{programId}")
	public GenerateMeritListModel getMeritList(@PathVariable(value="programId") Integer programId){
		return generateMeritListRCService.getMeritList(session.getCollegeId(), programId);
	}
}
