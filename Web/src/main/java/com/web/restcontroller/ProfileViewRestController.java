package com.web.restcontroller;

import java.util.List;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.web.model.ApplicantsModel;
import com.web.model.EducationModel;
import com.web.services.ApplicantsRCService;
import com.web.services.EducationalInformationRCService;
import com.web.session.Session;
import com.web.session.SessionService;
import com.web.session.StaticMethods;

@RestController
//@PreAuthorize("hasAnyRole('ROLE_USER', 'ROLE_COLLEGEADMIN')")
//@RequestMapping(value={"/applicants"})
public class ProfileViewRestController {

	@Autowired
	ApplicantsRCService applicantsDetailRCService;
	
	@Autowired
	Session session;
	
	@Autowired
	SessionService sessionService;
	
	@Autowired
	EducationalInformationRCService educationalInformationService;
	
	@RequestMapping(value="/applicants/setApplicant/{applicantId}")
	public void setApplicant(@PathVariable(value="applicantId") Integer applicantId) {
		sessionService.setApplicant(applicantId);
	}
	
	@RequestMapping(value="/applicants/getDetail/")
	public ApplicantsModel getApplicantsDetail(Model model){
		return applicantsDetailRCService.getApplicantDetail(session.getApplicant());
	}
	
	@RequestMapping(value="/educationalInformation/getEducationalInformation/")
	public EducationModel getEducationalInformation(Model model){
		return null; //educationalInformationService.getEducationalInformation();
	}
	
	@RequestMapping(value="/educationalInformation/getListofQualification/")
	public List<EducationModel.Qualification> getListofQualification(Model model){
		return educationalInformationService.getListofQualification(session.getApplicant());
	}
	
	@RequestMapping(value="/educationalInformation/getQualificationDetail/{qualificationId}", method=RequestMethod.GET)
	public EducationModel.QualificationDetail getQualificationDetail(
			@PathVariable(value="qualificationId") Integer qualificationId){
		return educationalInformationService.getQualificationDetail(session.getApplicant(), qualificationId);
	}
	
	/*@RequestMapping(value="/educationalInformation/getNewQualification/{qualificationMainLevel}", method=RequestMethod.GET)
	public EducationModel.QualificationDetail getNewQualification(
			@PathVariable(value="qualificationMainLevel") Integer qualificationMainLevel){
		if(session.getApplicant() != null)
			return educationalInformationService.getNewQualification(session.getApplicant(), qualificationMainLevel);
		else
			return null;
	}
	
	@RequestMapping(value="/educationalInformation/saveQualificationDetail/", method=RequestMethod.POST)
	public String saveQualificationDetail(@RequestBody EducationModel educationalModel){
		EducationModel.QualificationDetail qd = educationalModel.getQualificationDetail();
		Boolean success = false;
		String successMessage = "";
		String errorMessage = "";
		if(qd.getQualificationMainLevel() != null) {
			success = educationalInformationService.saveQualificationDetail(session.getApplicant(), educationalModel.getQualificationDetail());
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
	
	@RequestMapping(value="/educationalInformation/deleteQualificationDetail/", method=RequestMethod.POST)
	public String deleteQualificationDetail(@RequestBody Integer qualificationId){
		//EducationModel.QualificationDetail qd = educationalModel.getQualificationDetail();
		Boolean success = false;
		String successMessage = "";
		String errorMessage = "";
		if(qualificationId != null) {
			success = educationalInformationService.deleteQualificationDetail(session.getApplicant(), qualificationId);
			if(success)
				successMessage = "Removed successfully";
			else
				errorMessage = "Error while removing";
		} else {
			success = false;
			errorMessage = "Invalid input parameters";
		}		
		JSONObject jsonObject = StaticMethods.ResponseJson(success, successMessage, errorMessage);		
		return jsonObject.toJSONString();
	}*/
}
