package com.web.services.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.data.entities.College;
import com.data.entities.CollegeProgramMap;
import com.data.entities.CourseGroupLevelOne;
import com.data.entities.EducationalInformation;
import com.data.entities.Enums;
import com.data.entities.Application;
import com.data.entities.University_Subject;
import com.data.entities.User;
import com.data.services.CollegeProgramMapService;
import com.data.services.CollegeSubjectMapService;
import com.data.services.CourseGroupLevelOneService;
import com.data.services.EducationalInformationService;
import com.data.services.ApplicationService;
import com.web.model.AppliedCourseModel;
import com.web.model.SubjectModel;
import com.web.services.CourseRCService;
import com.web.staticandconstants.StaticMethods;

@Service("subjectRCService")
public class CourseRCServiceImpl implements CourseRCService{

	@Autowired
	CollegeProgramMapService collegeProgramMapService;
	
	@Autowired
	CollegeSubjectMapService collegeSubjectMapService;
	
	@Autowired 
	ApplicationService applicationService;
	
	@Autowired
	CourseGroupLevelOneService courseGroupLevelOneService;
	
	@Autowired
	EducationalInformationService educationalInformationService; 
	
	public SubjectModel getSubjectsByCollegeProgram(Integer collegeId, Integer collegeProgramId){
		
		SubjectModel subjectModel = new SubjectModel();
		CollegeProgramMap collegeProgramMap = collegeProgramMapService.getById(collegeProgramId);
		if(collegeProgramMap != null) {
			List<University_Subject> subjectListOfCollege = collegeSubjectMapService.getAvailableSubjectsForCollege(collegeProgramMap.getCollege(), collegeProgramMap.getProgram());
			List<CourseGroupLevelOne> courseGroupLevelOneList = courseGroupLevelOneService.getCourseGroupLevelOneByProgram(collegeProgramId);
			subjectModel.setProgram(collegeProgramMap.getProgram());
			subjectModel.setSubjectListOfCollege(subjectListOfCollege);
			subjectModel.setCourseGroupLevelOneList(courseGroupLevelOneList);
		}
		return subjectModel;
	}

	@Override
	public void applyForCourse(User vendor, User student, Integer collegeProgramMapId, Integer selectedAllowedQualification, List<University_Subject> selectedSubjectList) {
		Application application = new Application();
		application.setApplicationStatus(Enums.ApplicationStatus.Partial.getId());
		CollegeProgramMap clgPrgMap = collegeProgramMapService.getById(collegeProgramMapId);
		EducationalInformation educationalInformation = educationalInformationService.getById(selectedAllowedQualification);
		if(clgPrgMap != null) {
			application.setCollegeProgramMap(clgPrgMap);
			String frmNo = generateFormNo(clgPrgMap);
			application.setFormNo(frmNo);
			application.setUserDetail(student.getUserDetail());
			application.setDate(StaticMethods.GetCurrentDateString("dd-MM-yyyy"));
			application.setEducationalInformation(educationalInformation);
			application.setVendor(vendor.getVendor());
		}
		applicationService.save(application);
	}
	
	private String generateFormNo(CollegeProgramMap collegeProgramMap) {
		String formNo = "";
		if(collegeProgramMap != null && collegeProgramMap.getProgram() != null) {
			formNo = collegeProgramMap.getProgram().getUniversityProgramCode();
		}
		return formNo;
	}

	@Override
	public List<AppliedCourseModel> getAppliedCourseDetails(User user, College college) {
		List<Application> applicationList = applicationService.getByUserDetailandCollege(user.getUserDetail(), college);
		List<AppliedCourseModel> appliedCourses = new ArrayList<>();
		
		for(Application application : applicationList) {
			AppliedCourseModel appliedCourseModel = new AppliedCourseModel();
			appliedCourseModel.setApplicationId(application.getApplicationId());
			if(Enums.ApplicationStatus.get(application.getApplicationStatus()) != null) {				
				appliedCourseModel.setApplicationStatus(Enums.ApplicationStatus.getKeyValuePair(application.getApplicationStatus()));
			}
			appliedCourseModel.setCollegeProgramMap(application.getCollegeProgramMap());
			appliedCourseModel.setDate(application.getDate());
			appliedCourseModel.setFormNo(application.getFormNo());
			appliedCourseModel.setStatusComments(application.getStatusComments());
			
			appliedCourses.add(appliedCourseModel);
		}			
		return appliedCourses;
	}
}
