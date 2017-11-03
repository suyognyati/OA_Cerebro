package com.web.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.web.model.ProgramCategoriesModel;
import com.web.services.ProgramCategoryRCService;

@RestController
@RequestMapping(value="/rest/applyOnline")
public class ApplyOnlineRestController {

	@Autowired
	ProgramCategoryRCService programCategoryRCService;
	
	@RequestMapping(value="/programCategories/get/")
	public List<ProgramCategoriesModel> get(Model model){
		return programCategoryRCService.getProgramCategories();
	}
}
