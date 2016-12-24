package com.web.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.data.entities.EducationalInformation;
import com.data.services.EducationalInformationService;
import com.web.model.EducationalInformationModel;
import com.web.services.EducationalInformationRCService;


@Service("educationalInformationRCService")
public class EducationalInformationRCServiceImpl implements EducationalInformationRCService {

	@Autowired
	EducationalInformationService educationalInformationService;
	
	public EducationalInformationModel getEducationalInformation(){
		List<EducationalInformation> educationalInformations = educationalInformationService.getAll();
		
		EducationalInformationModel educationalInformationModel = new EducationalInformationModel();
		
		for (EducationalInformation educationalInformation : educationalInformations) {
			educationalInformationModel.setState(educationalInformation.getState());
			educationalInformationModel.setBoard(educationalInformation.getBoard());
			educationalInformationModel.setSchoolName(educationalInformation.getSchoolName());
			educationalInformationModel.setSchoolPlace(educationalInformation.getSchoolPlace());
			educationalInformationModel.setFirstAttempt(educationalInformation.getFirstAttempt());
			educationalInformationModel.setMathsType(educationalInformation.getMathsType());
			educationalInformationModel.setPassingYear(educationalInformation.getPassingYear());
			educationalInformationModel.setPassingMonth(educationalInformation.getPassingMonth());
			educationalInformationModel.setTotalMarksObtained(educationalInformation.getTotalMarksObtained());
			educationalInformationModel.setOutOfMarks(educationalInformation.getOutOfMarks());
			educationalInformationModel.setGradeObtained(educationalInformation.getGradeObtained());
			educationalInformationModel.setSeatNo(educationalInformation.getSeatNo());
		}
		return educationalInformationModel;

	}
}