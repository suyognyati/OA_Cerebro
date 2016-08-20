package com.web.restcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.web.model.EducationalInformationModel;
import com.web.services.EducationalInformationService;

@RestController
@RequestMapping(value="/educationalInformation")
public class EducationalInformationRestController {
	
	@Autowired
	EducationalInformationService educationalInformationService;
	
	@RequestMapping(value="/getEducationalInformation/")
	public EducationalInformationModel getEducationalInformation(Model model){
		//EducationalInformationService educationalInformationService = new EducationalInformationService();
		
		return educationalInformationService.getEducationalInformation();
	}
}
