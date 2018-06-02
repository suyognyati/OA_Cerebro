package com.web.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.web.model.ApplicantsModel;
import com.web.model.EducationModel;
import com.web.services.ApplicantsRCService;
import com.web.services.EducationalInformationRCService;
import com.web.session.Session;
import com.web.session.SessionService;

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
	
	@RequestMapping(value="/applicants/setStudentUser/{studentId}")
	public void setStudentUserByStudentId(@PathVariable(value="studentId") Integer studentId) {
		sessionService.setStudentUserByStudentId(studentId);
	}
	
	@RequestMapping(value="/applicants/getDetail/")
	public ApplicantsModel getApplicantsDetail(Model model){
		return applicantsDetailRCService.getApplicantDetail(session.getStudent());
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
	
}
