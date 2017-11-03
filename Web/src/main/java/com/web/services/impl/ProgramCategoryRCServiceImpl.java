package com.web.services.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.data.entities.ProgramCategory;
import com.data.services.ProgramCategoryService;
import com.web.model.ProgramCategoriesModel;
import com.web.services.ProgramCategoryRCService;

@Service("programCategoryRCService")
public class ProgramCategoryRCServiceImpl implements ProgramCategoryRCService {

	@Autowired
	ProgramCategoryService programCategoryService;
	
	@Override
	public List<ProgramCategoriesModel> getProgramCategories() {
		List<ProgramCategory> programCategoryList = programCategoryService.getAllProgramCategories();
		List<ProgramCategoriesModel> listOfProgramCategoriesModel = new ArrayList<ProgramCategoriesModel>();
		for(ProgramCategory programCategory : programCategoryList) {
			ProgramCategoriesModel programCategoryModel = new ProgramCategoriesModel();
			programCategoryModel.setProgramCategoryId(programCategory.getCategoryId());
			programCategoryModel.setProgramCategoryName(programCategory.getCategoryName());
			listOfProgramCategoriesModel.add(programCategoryModel);
		}
		return listOfProgramCategoriesModel;
	}

}
