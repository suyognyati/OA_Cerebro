package com.web.services;

import com.web.model.PersonalDetailModel;

public class PersonalDetailService {
	
	public PersonalDetailModel getPersonalDetail(){
		PersonalDetailModel personalDetailModel = new PersonalDetailModel();		
		personalDetailModel.setGender("Female");
		personalDetailModel.setBloodGroup("O+ve");
		personalDetailModel.setPlaceOfBirth("Jalgaon");
		personalDetailModel.setDomiciledIn("Maharashtrs");
		personalDetailModel.setMaritalStatus("Married");
		personalDetailModel.setAddress("Runwal Swaranjali, Prathamesh Park, Baner");
		personalDetailModel.setCity("Pune");
		personalDetailModel.setState("Maharashtra");
		return personalDetailModel;
	}
}
