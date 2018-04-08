package com.web.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.data.entities.Enums;
import com.data.services.EducationalInformationService;
import com.data.services.OccupationReservationService;
import com.data.services.PersonalDetailService;
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
	
	GenerateMeritListModel generateMeritListModel = null;
	
	@Override
	public GenerateMeritListModel getMeritList(Integer collegeId, Integer programId) {
		generateMeritListModel = new GenerateMeritListModel();
		
		generateMeritListModel.setReservationList(Enums.Category.getEnumList());
		
		
		return generateMeritListModel;
	}
}
