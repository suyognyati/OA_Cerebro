package com.web.services.impl;

import com.web.model.OtherInformationModel;

public class OtherInformationService {

	public OtherInformationModel getOtherInformation(){
		OtherInformationModel otherInformationModel = new OtherInformationModel();		
		otherInformationModel.setCategory("");
		otherInformationModel.setCaste("");
		otherInformationModel.setReligion("");
		otherInformationModel.setSpecialCategory("");
		otherInformationModel.setAadharCardNumber("");
		otherInformationModel.setPhysicallyReserved("");
		otherInformationModel.setExtraCurricular("");
		otherInformationModel.setMemberOfNcc("");
		otherInformationModel.setScholarship("");
		otherInformationModel.setEarningMember("");
		otherInformationModel.setNonEarningMember("");
		otherInformationModel.setTotalMember("");
		otherInformationModel.setAnnualIncome("");
		return otherInformationModel;
	}
}
