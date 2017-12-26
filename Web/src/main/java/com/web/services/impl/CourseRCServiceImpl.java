package com.web.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.data.entities.CollegeProgramMap;
import com.data.entities.CourseGroupLevelOne;
import com.data.entities.Enums;
import com.data.entities.SubmittedApplications;
import com.data.entities.University_Subject;
import com.data.services.CollegeProgramMapService;
import com.data.services.CourseGroupLevelOneService;
import com.data.services.SubmittedApplicationService;
import com.web.model.SubjectModel;
import com.web.services.CourseRCService;

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
	public void applyForCourse(Integer collegeProgramMapId, List<University_Subject> selectedSubjectList) {
		SubmittedApplications submittedApplication = new SubmittedApplications();
		submittedApplication.setApplicationStatus(Enums.ApplicationStatus.Submitted.getId());
		CollegeProgramMap clgPrgMap = collegeProgramMapService.getById(collegeProgramMapId);
		if(clgPrgMap != null) {
			submittedApplication.setCollegeAndProgramDetail(clgPrgMap);
			String frmNo = clgPrgMap.getProgram().getUniversityProgramCode();
			submittedApplication.setFormNo(frmNo);
			submittedApplication.setDate("");
		}
		submittedApplicationService.save(submittedApplication);
	}
}
