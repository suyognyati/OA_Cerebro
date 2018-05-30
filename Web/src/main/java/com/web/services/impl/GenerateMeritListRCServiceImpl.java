package com.web.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.data.entities.CollegeProgramMap;
import com.data.entities.Enums;
import com.data.entities.University_Program;
import com.data.poco.AppliedStudentPOCO;
import com.data.services.CollegeProgramMapService;
import com.data.services.EducationalInformationService;
import com.data.services.OccupationReservationService;
import com.data.services.PersonalDetailService;
import com.data.services.ApplicationService;
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
	CollegeProgramMapService collegeProgramMapService;
	
	@Autowired
	ApplicationService applicationService;
	
	GenerateMeritListModel generateMeritListModel = null;
	
	@Override
	public GenerateMeritListModel getMeritList(Integer collegeId, Integer programId) {
		generateMeritListModel = new GenerateMeritListModel();
		
		generateMeritListModel.setReservationList(Enums.Category.getEnumList());		
		
		CollegeProgramMap collegeProgramMap = collegeProgramMapService.getCollegeProgramByCollegeAndProgram(collegeId, programId);
		
		if(collegeProgramMap != null) {
			University_Program program = collegeProgramMap.getProgram();
			List<AppliedStudentPOCO> appliedStudentListOfProgram = applicationService.getAppliedStudentListOfProgram(collegeProgramMap.getCollegeProgramMapId());
			
			generateMeritListModel.setProgramCode(program.getUniversityProgramCode());
			generateMeritListModel.setProgramName(program.getUniversityProgramName());
			
			generateMeritListModel.setAppliedStudentList(appliedStudentListOfProgram);
		}
		
		return generateMeritListModel;
	}
}
