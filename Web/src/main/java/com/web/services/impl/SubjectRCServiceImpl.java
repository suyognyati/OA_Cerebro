package com.web.services.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.data.entities.CollegeSubjectMap;
import com.data.entities.University_Subject;
import com.data.services.CollegeSubjectMapService;
import com.web.model.SubjectModel;
import com.web.services.SubjectRCService;

@Service("subjectRCService")
public class SubjectRCServiceImpl implements SubjectRCService{

	@Autowired
	CollegeSubjectMapService collegeSubjectMapService;
	
	public List<SubjectModel> getSubjectsByProgram(Integer collegeId, Integer programId){
		
		List<CollegeSubjectMap> subjectsUnderProgram = collegeSubjectMapService.getCollegeSubjectsByProgram(collegeId, programId);
		List<SubjectModel> subjectModelList = new ArrayList<SubjectModel>();
		
		University_Subject subject = null;
		for(CollegeSubjectMap subjectunderProgram : subjectsUnderProgram) {
			subject = subjectunderProgram.getSubject();
			if(subject != null) {
				SubjectModel subjectModel = new SubjectModel();			
				subjectModel.setSubjectCode(subject.getUniversitySubjectCode());
				subjectModel.setSubjectName(subject.getUniversitySubjectName());
				subjectModel.setSubjectId(subject.getUniversitySubjectId());
				subjectModelList.add(subjectModel);
			}
		}
		
		return subjectModelList;
	}
}
