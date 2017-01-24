package com.web.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.web.model.EducationModel;
import com.web.services.EducationalInformationRCService;

@RestController
@RequestMapping(value="/rest/educationalInformation")
public class EducationalInformationRestController {
	
	@Autowired
	EducationalInformationRCService educationalInformationService;
	
	@RequestMapping(value="/getEducationalInformation/")
	public EducationModel getEducationalInformation(Model model){
		return null; //educationalInformationService.getEducationalInformation();
	}
	
	@RequestMapping(value="/getListofQualification/")
	public List<EducationModel.Qualification> getListofQualification(Model model){
		return educationalInformationService.getListofQualification();
	}
}
