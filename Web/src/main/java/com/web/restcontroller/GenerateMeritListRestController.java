package com.web.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.web.model.GenerateMeritListModel;
import com.web.model.ProgramCategoriesModel;
import com.web.model.ProgramCategoryWeightageModel;
import com.web.model.ProgramModel;
import com.web.services.GenerateMeritListRCService;
import com.web.services.ProgramCategoryRCService;
import com.web.services.ProgramCategoryWeightageRCService;
import com.web.services.ProgramRCService;
import com.web.session.Session;

@RestController
//@RequestMapping(value="/generateMeritList")
public class GenerateMeritListRestController {

	@Autowired
	Session session;
	
	@Autowired
	ProgramCategoryRCService programCategoryRCService;
	
	@Autowired
	ProgramRCService programService;
	
	@Autowired
	GenerateMeritListRCService generateMeritListRCService;
	
	@Autowired
	ProgramCategoryWeightageRCService programCategoryWeightageRCService;
	
	@RequestMapping(value="/generateMeritList/programCategories/get/")
	public List<ProgramCategoriesModel> get(Model model){
		return programCategoryRCService.getProgramCategories();
	}
	
	@RequestMapping(value="/generateMeritList/getPrograms/{programCategoryId}")
	public List<ProgramModel> getPrograms(@PathVariable(value="programCategoryId") Integer programCategoryId){
		return programService.getProgramsByCategory(session.getCollegeId(), programCategoryId);
	}
	
	@RequestMapping(value="/generateMeritList/getAllPrograms/")
	public List<ProgramModel> getAllProgramsOfCollege(){
		return programService.getAllProgramsOfCollege(session.getCollegeId());
	}
	
	@RequestMapping(value="/generateMeritList/getMeritList/{programId}")
	public GenerateMeritListModel getMeritList(@PathVariable(value="programId") Integer programId){
		return generateMeritListRCService.getMeritList(session.getCollegeId(), programId);
	}
	
	@RequestMapping(value="/program/getCategoryWeightage/{programId}")
	public ProgramCategoryWeightageModel getCategoryWeightage(@PathVariable(value="programId") Integer programId){
		 return programCategoryWeightageRCService.getCategoryWeightageByProgramId(programId, session.getCollege());
	}
	
	@RequestMapping(value="/program/setCategoryWeightage/", method=RequestMethod.POST)
	public Boolean setCategoryWeightage(@RequestBody ProgramCategoryWeightageModel programCategoryWeightageModel){
		 programCategoryWeightageRCService.setCategoryWeightage(programCategoryWeightageModel);
		 return true;
	}
}
