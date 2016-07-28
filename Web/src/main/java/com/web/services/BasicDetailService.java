package com.web.services;

import com.web.model.BasicDetailModel;

public class BasicDetailService {

	public BasicDetailModel getBasicDetail(){
		BasicDetailModel basicDetailModel = new BasicDetailModel();		
		basicDetailModel.setLastName("Nyati");
		basicDetailModel.setFirstName("Manali");
		basicDetailModel.setMiddleName("Suyog");
		basicDetailModel.setMothersName("Kiran");
		basicDetailModel.setBirthDate("08Jun1989");
		basicDetailModel.setEmail("er.manalirathi@gmail.com");
		basicDetailModel.setMobileNo("7588436460");
		basicDetailModel.setOtherContactNo("9028912426");
		return basicDetailModel;
	}
}
