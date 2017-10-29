package com.web.services.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.web.model.SubjectModel;
import com.web.services.SubjectRCService;

@Service("subjectRCService")
public class SubjectRCServiceImpl implements SubjectRCService{

	public List<SubjectModel> getBachelorSubject(Integer courseId){
		List<SubjectModel> subjectModelList = new ArrayList<SubjectModel>();
		
		SubjectModel subjectModel = new SubjectModel();
		subjectModel.setSubjectCode("1");
		subjectModel.setSubjectName("English");
		subjectModelList.add(subjectModel);
		
		subjectModel = new SubjectModel();
		subjectModel.setSubjectCode("2");
		subjectModel.setSubjectName("Language");
		subjectModelList.add(subjectModel);
		
		return subjectModelList;
	}
}
