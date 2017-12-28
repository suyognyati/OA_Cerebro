package com.web.services.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.data.entities.College;
import com.data.entities.CollegeProgramMap;
import com.data.entities.CourseGroupLevelOne;
import com.data.entities.Enums;
import com.data.entities.SubmittedApplications;
import com.data.entities.University_Subject;
import com.data.entities.User;
import com.data.services.CollegeProgramMapService;
import com.data.services.CourseGroupLevelOneService;
import com.data.services.SubmittedApplicationService;
import com.web.model.AppliedCourseModel;
import com.web.model.SubjectModel;
import com.web.services.CourseRCService;
import com.web.session.StaticMethods;

@Service("subjectRCService")
public class CourseRCServiceImpl implements CourseRCService{

	@Autowired
	CollegeProgramMapService collegeProgramMapService;
	
	@Autowired 
	SubmittedApplicationService submittedApplicationService;
	
	@Autowired
	CourseGroupLevelOneService courseGroupLevelOneService;
	
	public SubjectModel getSubjectsByCollegeProgram(Integer collegeId, Integer collegeProgramId){
		
		SubjectModel subjectModel = new SubjectModel();
		List<CourseGroupLevelOne> courseGroupLevelOneList = courseGroupLevelOneService.getCourseGroupLevelOneByProgram(collegeProgramId);
		subjectModel.setCourseGroupLevelOneList(courseGroupLevelOneList);
		return subjectModel;
	}

	@Override
	public void applyForCourse(User user, Integer collegeProgramMapId, List<University_Subject> selectedSubjectList) {
		SubmittedApplications submittedApplication = new SubmittedApplications();
		submittedApplication.setApplicationStatus(Enums.ApplicationStatus.Submitted.getId());
		CollegeProgramMap clgPrgMap = collegeProgramMapService.getById(collegeProgramMapId);
		if(clgPrgMap != null) {
			submittedApplication.setCollegeProgramMap(clgPrgMap);
			String frmNo = generateFormNo(clgPrgMap);
			submittedApplication.setFormNo(frmNo);
			submittedApplication.setUser(user);
			submittedApplication.setDate(StaticMethods.GetCurrentDateString("dd-MM-yyyy"));
		}
		submittedApplicationService.save(submittedApplication);
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
		List<SubmittedApplications> submittedApplicationList = submittedApplicationService.getByUserandCollege(user, college);
		List<AppliedCourseModel> appliedCourses = new ArrayList<>();
		
		for(SubmittedApplications submittedApplication : submittedApplicationList) {
			AppliedCourseModel appliedCourseModel = new AppliedCourseModel();
			appliedCourseModel.setApplicationId(submittedApplication.getApplicationId());
			if(Enums.ApplicationStatus.get(submittedApplication.getApplicationStatus()) != null) {
				appliedCourseModel.setApplicationStatus(
						Enums.ApplicationStatus.get(submittedApplication.getApplicationStatus()).getValue());
			}
			appliedCourseModel.setCollegeProgramMap(submittedApplication.getCollegeProgramMap());
			appliedCourseModel.setDate(submittedApplication.getDate());
			appliedCourseModel.setFormNo(submittedApplication.getFormNo());
			appliedCourseModel.setStatusComments(submittedApplication.getStatusComments());
			
			appliedCourses.add(appliedCourseModel);
		}			
		return appliedCourses;
	}
}
