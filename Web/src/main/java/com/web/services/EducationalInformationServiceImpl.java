package com.web.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.data.entities.EducationalInformation;
import com.data.repository.EducationalInformationJpaRepository;
import com.web.model.EducationalInformationModel;


@Service("educationalInformationService")
public class EducationalInformationServiceImpl implements EducationalInformationService {

	@Autowired
	EducationalInformationJpaRepository educationalInformationJpaRepository;
	
	public EducationalInformationModel getEducationalInformation(){
		List<EducationalInformation> educationalInformations = educationalInformationJpaRepository.findAll();
		
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
		
		/*public EducationalInformationModel getEducationInformation(){
		EducationalInformationModel educationInformationModel = new EducationalInformationModel();		
		educationInformationModel.setState("Maharashtra");
		educationInformationModel.setBoard("Maharashtra State Board");
		educationInformationModel.setSchoolName("NEMS");
		educationInformationModel.setSchoolPlace("Jalgaon");
		educationInformationModel.setFirstAttempt("YES");
		educationInformationModel.setMathsType("Easy Type");
		educationInformationModel.setPassingYear("2004");
		educationInformationModel.setPassingMonth("June");
		educationInformationModel.setTotalMarksObtained("615");
		educationInformationModel.setOutOfMarks("750");
		educationInformationModel.setGradeObtained("A+");
		educationInformationModel.setSeatNo("D456923");
	}*/
		return educationalInformationModel;

	}
}