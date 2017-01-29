package com.web.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.web.model.EducationModel;
import com.web.services.EducationalInformationRCService;
import com.web.session.Session;

@RestController
@RequestMapping(value="/rest/educationalInformation")
public class EducationalInformationRestController {
	
	@Autowired
	EducationalInformationRCService educationalInformationService;
	
	@Autowired
	Session session;
	
	@RequestMapping(value="/getEducationalInformation/")
	public EducationModel getEducationalInformation(Model model){
		return null; //educationalInformationService.getEducationalInformation();
	}
	
	@RequestMapping(value="/getListofQualification/")
	public List<EducationModel.Qualification> getListofQualification(Model model){
		return educationalInformationService.getListofQualification();
	}
	
	@RequestMapping(value="/getQualificationDetail/")
	public EducationModel.QualificationDetail getQualificationDetail(@RequestBody Integer qualificationLevel){
		return educationalInformationService.getQualificationDetail(session.getCurrentUser(), qualificationLevel);
	}
}
