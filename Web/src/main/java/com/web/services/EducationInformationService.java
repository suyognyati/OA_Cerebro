package com.web.services;

import com.web.model.EducationInformationModel;

public class EducationInformationService {

	public EducationInformationModel getEducationInformation(){
		EducationInformationModel educationInformationModel = new EducationInformationModel();		
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
		return educationInformationModel;
	}
}
