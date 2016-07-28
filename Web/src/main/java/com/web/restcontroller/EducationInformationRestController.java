package com.web.restcontroller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.web.model.EducationInformationModel;
import com.web.services.EducationInformationService;

@RestController
public class EducationInformationRestController {
	@RequestMapping(value="/educationInformation/getEducationInformation/")
	public EducationInformationModel getEducationInformation(Model model){
		EducationInformationService educationInformationService = new EducationInformationService();
		
		return educationInformationService.getEducationInformation();
	}
}
