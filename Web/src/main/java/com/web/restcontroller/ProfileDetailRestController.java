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

import com.web.model.AddressModel;
import com.web.model.EducationModel;
import com.web.model.OccupationReservationModel;
import com.web.model.PersonalDetailModel;
import com.web.model.StudentModel;
import com.web.services.AddressRCService;
import com.web.services.EducationalInformationRCService;
import com.web.services.OccupationReservationRCService;
import com.web.services.PersonalDetailRCService;
import com.web.services.StudentRCService;
import com.web.session.Session;
import com.web.staticandconstants.StaticConstants;
import com.web.staticandconstants.StaticMethods;

@RestController
@PreAuthorize("hasRole('" + StaticConstants.ROLE.ROLE_STUDENT + "')")
@RequestMapping(value="/rest")
public class ProfileDetailRestController {
	
	@Autowired
	StudentRCService studentRCService;
	
	@Autowired
	PersonalDetailRCService personalDetailService;
	
	@Autowired
	AddressRCService addressRCService;
	
	@Autowired
	EducationalInformationRCService educationalInformationService;
	
	@Autowired
	Session session;
	
	@Autowired
	OccupationReservationRCService occupationReservationRCService;
	
	
	@RequestMapping(value="/student/get/")
	public StudentModel getStudent(Model model){
		System.out.println("BasicDetailRestController - getBasicDetail");
		return studentRCService.getStudent();
	}
	
	@RequestMapping(value="/student/save/", method=RequestMethod.POST)
	public void saveStudent(@RequestBody StudentModel basicDetailModel) {
		studentRCService.saveStudent(basicDetailModel);
	}
	
	@RequestMapping(value="/personalDetail/getPersonalDetail/")
	public PersonalDetailModel getPersonalDetail(Model model){
		return personalDetailService.getPersonalDetail(session.getStudent());
	}
	
	@RequestMapping(value="/personalDetail/savePersonalDetail/", method=RequestMethod.POST)
	public void savePersonalDetail(@RequestBody PersonalDetailModel personalDetailModel) {
		personalDetailService.savePersonalDetail(personalDetailModel, session.getStudent());
	}
	
	@RequestMapping(value="/address/getAddressDetail/")
	public AddressModel getAddressDetail(Model model){
		return addressRCService.getAddress();
	}
	
	@RequestMapping(value="/address/saveAddressDetail/", method=RequestMethod.POST)
	public void saveAddressDetail(@RequestBody AddressModel addressModel) {
		addressRCService.saveAddress(addressModel);
	}
	
	@RequestMapping(value="/educationalInformation/getEducationalInformation/")
	public EducationModel getEducationalInformation(Model model){
		return null; //educationalInformationService.getEducationalInformation();
	}
	
	@RequestMapping(value="/educationalInformation/getListofQualification/")
	public List<EducationModel.Qualification> getListofQualification(Model model){
		return educationalInformationService.getListofQualification(session.getStudent());
	}
	
	@RequestMapping(value="/educationalInformation/getQualificationDetail/{qualificationId}", method=RequestMethod.GET)
	public EducationModel.QualificationDetail getQualificationDetail(
			@PathVariable(value="qualificationId") Integer qualificationId){
		return educationalInformationService.getQualificationDetail(session.getStudent(), qualificationId);
	}
	
	@RequestMapping(value="/educationalInformation/getNewQualification/{qualificationGroup}", method=RequestMethod.GET)
	public EducationModel.QualificationDetail getNewQualification(
			@PathVariable(value="qualificationGroup") Integer qualificationGroup){
		if(session.getStudent() != null)
			return educationalInformationService.getNewQualification(session.getStudent(), qualificationGroup);
		else
			return null;
	}
	
	@RequestMapping(value="/educationalInformation/saveQualificationDetail/", method=RequestMethod.POST)
	public String saveQualificationDetail(@RequestBody EducationModel educationalModel){
		EducationModel.QualificationDetail qd = educationalModel.getQualificationDetail();
		Boolean success = false;
		String successMessage = "";
		String errorMessage = "";
		if(qd.getQualificationGroup() != null) {
			success = educationalInformationService.saveQualificationDetail(session.getStudent(), educationalModel.getQualificationDetail());
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
			success = educationalInformationService.deleteQualificationDetail(session.getStudent(), qualificationId);
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
	}
	
	@RequestMapping(value="/occupationreservation/getOccupationReservation/")
	public OccupationReservationModel getOccupationReservation(Model model){
		return occupationReservationRCService.getOccupationReservation(session.getStudent());
	}
	
	@RequestMapping(value="/occupationreservation/saveOccupationReservation/", method=RequestMethod.POST)
	public void saveOccupationReservation(@RequestBody OccupationReservationModel occupationReservationModel) {
		occupationReservationRCService.saveOccupationReservation(occupationReservationModel, session.getStudent());
	}
	
	
	
}
