package com.web.services.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.data.entities.College;
import com.data.entities.CollegeProgramMap;
import com.data.entities.Enums;
import com.data.entities.Enums.KeyValuePair;
import com.data.entities.ProgramCategoryWeightage;
import com.data.services.CollegeProgramMapService;
import com.data.services.ProgramCategoryWeightageDao;
import com.web.model.ProgramCategoryWeightageModel;
import com.web.model.ProgramCategoryWeightageModel.CategoryWeightage;
import com.web.services.ProgramCategoryWeightageRCService;
import com.web.staticandconstants.StaticConstants;

@Service("rogramCategoryWeightageRCService")
public class ProgramCategoryWeightageRCServiceImpl implements ProgramCategoryWeightageRCService {

	@Autowired
	ProgramCategoryWeightageDao programCategoryWeightageDao;
	
	@Autowired
	CollegeProgramMapService collegeProgramMapService;
	
	

	@Override
	public ProgramCategoryWeightageModel getCategoryWeightageByProgramId(Integer programId, College college) {
		CollegeProgramMap collegeProgramMap = null;
		collegeProgramMap = collegeProgramMapService.getCollegeProgramByCollegeAndProgram(college.getCollegeId(), programId);
		return getCategoryWeightage(collegeProgramMap, college);
	}

	@Override
	public ProgramCategoryWeightageModel getCategoryWeightage(Integer collegeProgramMapId, College college) {
		CollegeProgramMap collegeProgramMap = null;
		collegeProgramMap = collegeProgramMapService.getById(collegeProgramMapId);
		return getCategoryWeightage(collegeProgramMap, college);
	}
	
	private ProgramCategoryWeightageModel getCategoryWeightage(CollegeProgramMap collegeProgramMap, College college) {
		
		List<ProgramCategoryWeightage> programCategoryWeightageList = programCategoryWeightageDao.getByCollegeProgramMap(collegeProgramMap);
		ProgramCategoryWeightageModel programCategoryWeightageModel = new ProgramCategoryWeightageModel();
		List<CategoryWeightage> categoryWeightageList = new ArrayList<CategoryWeightage>();
		
		if(programCategoryWeightageList == null) {
			programCategoryWeightageList = programCategoryWeightageDao.getByCollege(college);
		}
		
		//For total weightage
		if(programCategoryWeightageList != null && programCategoryWeightageList.size() > 0) {
			for(ProgramCategoryWeightage pcw : programCategoryWeightageList) {
				if(pcw.getCategoryName() == StaticConstants.ProgramCategoryTotalName) {
					programCategoryWeightageModel.setProgramCategoryWeightageCount(pcw);
				}
			}
		} else {
			ProgramCategoryWeightage programCategoryWeightage = new ProgramCategoryWeightage();
			programCategoryWeightage.setCollegeProgram(collegeProgramMap);
			programCategoryWeightageModel.setProgramCategoryWeightageCount(programCategoryWeightage);
		}
		
		List<KeyValuePair> categoryList = Enums.Category.getEnumList();
		
		for(KeyValuePair category : categoryList) {
			CategoryWeightage categoryWeightage = programCategoryWeightageModel.new CategoryWeightage();
			ProgramCategoryWeightage programCategoryWeightage = null;
			for(ProgramCategoryWeightage pcw : programCategoryWeightageList) {
				if(pcw.getCategoryName() == category.getKey()) {
					programCategoryWeightage = pcw;
					break;
				}
			}
			if(programCategoryWeightage == null) {
				programCategoryWeightage = new ProgramCategoryWeightage();
				programCategoryWeightage.setCollegeProgram(collegeProgramMap);
				programCategoryWeightage.setCategoryName(category.getKey());
			}
			categoryWeightage.setCategory(category);
			categoryWeightage.setProgramCategoryWeightage(programCategoryWeightage);
			
			categoryWeightageList.add(categoryWeightage);
			programCategoryWeightage = null;
		}
		
		programCategoryWeightageModel.setCollegeProgramMap(collegeProgramMap);
		programCategoryWeightageModel.setCategoryWeightageList(categoryWeightageList);
		
		return programCategoryWeightageModel;
	}

}
