package com.web.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.data.entities.Enums;
import com.data.entities.University_Program;
import com.data.services.EducationalInformationService;
import com.data.services.OccupationReservationService;
import com.data.services.PersonalDetailService;
import com.data.services.University_ProgramService;
import com.data.services.UserDetailService;
import com.web.model.GenerateMeritListModel;
import com.web.services.GenerateMeritListRCService;

@Service("GenerateMeritListRCService")
public class GenerateMeritListRCServiceImpl implements GenerateMeritListRCService {

	@Autowired
	UserDetailService userDetailService; 
	
	@Autowired
	PersonalDetailService personalDetailService;
	
	@Autowired
	EducationalInformationService educationalInformationService;
	
	@Autowired
	OccupationReservationService occupationReservationService;
	
	@Autowired
	University_ProgramService university_ProgramService;
	
	GenerateMeritListModel generateMeritListModel = null;
	
	@Override
	public GenerateMeritListModel getMeritList(Integer collegeId, Integer programId) {
		generateMeritListModel = new GenerateMeritListModel();
		
		generateMeritListModel.setReservationList(Enums.Category.getEnumList());
		
		University_Program university_Program = university_ProgramService.getById(programId);
		
		generateMeritListModel.setProgramCode(university_Program.getUniversityProgramCode());
		generateMeritListModel.setProgramName(university_Program.getUniversityProgramName());
		
		return generateMeritListModel;
	}
}
