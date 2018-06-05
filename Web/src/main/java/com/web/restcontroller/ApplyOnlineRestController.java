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

import com.web.model.AppliedCourseModel;
import com.web.model.EducationModel;
import com.web.model.ProgramCategoriesModel;
import com.web.model.ProgramModel;
import com.web.model.SubjectModel;
import com.web.services.ApplicationRCService;
import com.web.services.CourseRCService;
import com.web.services.EducationalInformationRCService;
import com.web.services.ProgramCategoryRCService;
import com.web.services.ProgramRCService;
import com.web.session.Session;
import com.web.staticandconstants.StaticConstants;
import com.web.staticandconstants.StaticMethods;

@RestController
@RequestMapping(value="/rest")
public class ApplyOnlineRestController {

	@Autowired
	Session session;
	
	@Autowired
	ProgramCategoryRCService programCategoryRCService;
	
	@Autowired
	ProgramRCService programService;
	
	@Autowired
	CourseRCService courseRCService;
	
	@Autowired
	ApplicationRCService applicationRCService;
	
	@Autowired
	EducationalInformationRCService educationalInformationService; 
	
	@RequestMapping(value="/applyOnline/programCategories/getApplyOnline/")
	public List<ProgramCategoriesModel> get(Model model){
		return programCategoryRCService.getProgramCategories();
	}
	
	@RequestMapping(value="/program/getPrograms/{programCategoryId}")
	public List<ProgramModel> getPrograms(@PathVariable(value="programCategoryId") Integer programCategoryId){
		return programService.getProgramsByCategory(session.getCollegeId(), programCategoryId);
	}
	
	@RequestMapping(value="/educationalInformation/getAllowedQualifications/{collegeProgramId}")
	public List<EducationModel.Qualification> getAllowedQualifications(@PathVariable(value="collegeProgramId") Integer collegeProgramId){
		return educationalInformationService.getAllowedQualificationsForProgram(session.getStudent(), collegeProgramId);
	}
	
	@RequestMapping(value="/subject/getSubjects/{collegeProgramId}")
	public SubjectModel getSubjects(@PathVariable(value="collegeProgramId") Integer collegeProgramId){
		return courseRCService.getSubjectsByCollegeProgram(session.getCollegeId(), collegeProgramId);
	}
	
	@RequestMapping(value="/subject/applyForCourse", method = RequestMethod.POST)
	public void applyForCourse(@RequestBody AppliedCourseModel appliedCourseModel) {
		courseRCService.applyForCourse(session.getLoggedInUser(), session.getStudent(), appliedCourseModel.getCollegeProgramId(), 
				appliedCourseModel.getSelectedAllowedQualification(), appliedCourseModel.getSelectedSubjectList());
	}
	
	@RequestMapping(value="/subject/getAppliedCourses", method = RequestMethod.GET)
	public String getAppliedCourses() {
		List<AppliedCourseModel> appliedCoursemodel = courseRCService.getAppliedCourseDetails(session.getStudent(), session.getCollege());
		return StaticMethods.GetJsonStringFromObject(appliedCoursemodel, StaticConstants.DATEFORMAT.ddMMyyyy);
	}
	
	@RequestMapping(value="/application/deleteAppliedCourse", method = RequestMethod.POST)
	public JSONObject deleteAppliedCourse(@RequestBody Integer applicationId) {
		Boolean success = applicationRCService.deleteAppliedCourse(applicationId);		
		return StaticMethods.ResponseJson("deleted", success);
	}
}
