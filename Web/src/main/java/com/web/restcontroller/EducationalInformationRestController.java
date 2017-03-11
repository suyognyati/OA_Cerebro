package com.web.restcontroller;

import java.util.List;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.web.model.EducationModel;
import com.web.services.EducationalInformationRCService;
import com.web.session.Session;
import com.web.session.StaticMethods;

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
		return educationalInformationService.getListofQualification(session.getCurrentUser());
	}
	
	@RequestMapping(value="/getQualificationDetail/{qualificationMainLevel}/{qualificationSubLevel}", method=RequestMethod.GET)
	public EducationModel.QualificationDetail getQualificationDetail(
			@PathVariable(value="qualificationMainLevel") Integer qualificationMainLevel,
			@PathVariable(value="qualificationSubLevel") Integer qualificationSubLevel){
		return educationalInformationService.getQualificationDetail(session.getCurrentUser(), qualificationMainLevel, qualificationSubLevel);
	}
	
	@RequestMapping(value="/getNewQualification/{qualificationMainLevel}", method=RequestMethod.GET)
	public EducationModel.QualificationDetail getNewQualification(
			@PathVariable(value="qualificationMainLevel") Integer qualificationMainLevel){
		if(session.getCurrentUser() != null)
			return educationalInformationService.getNewQualification(session.getCurrentUser(), qualificationMainLevel);
		else
			return null;
	}
	
	@RequestMapping(value="/saveQualificationDetail/", method=RequestMethod.POST)
	public String saveQualificationDetail(@RequestBody EducationModel educationalModel){
		EducationModel.QualificationDetail qd = educationalModel.getQualificationDetail();
		Boolean success = false;
		String successMessage = "";
		String errorMessage = "";
		if(qd.getQualificationMainLevel() != null && qd.getQualificationSubLevel() != null) {
			success = educationalInformationService.saveQualificationDetail(session.getCurrentUser(), educationalModel.getQualificationDetail());
			if(success)
				successMessage = "Saved successfully";
			else
				errorMessage = "Error while saving";
		} else {
			success = false;
			errorMessage = "Invalid input parameters";
		}		
		JSONObject jsonObject = StaticMethods.ResponseJson(success, successMessage, errorMessage);		
		return jsonObject.toJSONString();
	}
}
