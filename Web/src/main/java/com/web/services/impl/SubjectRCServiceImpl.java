package com.web.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.data.entities.CourseGroupLevelOne;
import com.data.services.CollegeSubjectMapService;
import com.data.services.CourseGroupLevelOneService;
import com.web.model.SubjectModel;
import com.web.services.SubjectRCService;

@Service("subjectRCService")
public class SubjectRCServiceImpl implements SubjectRCService{

	@Autowired
	CollegeSubjectMapService collegeSubjectMapService;
	
	@Autowired
	CourseGroupLevelOneService courseGroupLevelOneService;
	
	public SubjectModel getSubjectsByProgram(Integer collegeId, Integer programId){
		
		SubjectModel subjectModel = new SubjectModel();
		List<CourseGroupLevelOne> courseGroupLevelOneList = courseGroupLevelOneService.getCourseGroupLevelOneByProgram(programId);
		subjectModel.setCourseGroupLevelOneList(courseGroupLevelOneList);
		return subjectModel;
	}
}
