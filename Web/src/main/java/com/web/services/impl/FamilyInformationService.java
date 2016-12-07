package com.web.services.impl;

import com.web.model.FamilyInformationModel;

public class FamilyInformationService {

	public FamilyInformationModel getFamilyInformation(){
		FamilyInformationModel familyInformationModel = new FamilyInformationModel();		
		familyInformationModel.setFathersName("Satyanarayan");
		familyInformationModel.setFathersMiddleName("Bhagwandas");
		familyInformationModel.setFathersAge("52");
		familyInformationModel.setFathersEmail("abc.gamil.com");
		familyInformationModel.setFathersContact("9422275602");
		familyInformationModel.setFathersQualification("B.Com");
		familyInformationModel.setFathersOccupation("Business");
		familyInformationModel.setFathersDesignation("Businessman");
		familyInformationModel.setFathersBusinessAddress("Jalgaon");
		familyInformationModel.setMothersName("Kiran");
		familyInformationModel.setMothersAge("48");
		familyInformationModel.setMothersEmail("er.manalirathi@gmail.com");
		familyInformationModel.setMothersContact("7588496457");
		familyInformationModel.setMothersQualification("B.Com");
		familyInformationModel.setMothersOccupation("Housewife");
		familyInformationModel.setMothersDesignation("Housewife");
		familyInformationModel.setMothersBusinessAddress("Jalgaon");
		return familyInformationModel;
	}
}
