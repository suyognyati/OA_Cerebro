package com.web.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.data.entities.PersonalDetail;
import com.data.repository.BloodGroupJpaRepository;
import com.data.repository.PersonalDetailJpaRepository;
import com.web.model.PersonalDetailModel;

@Service("personalDetailService")
public class PersonalDetailServiceImpl implements PersonalDetailService {
	
	@Autowired
	PersonalDetailJpaRepository personalDetailJpaRepository;
	
	@Autowired
	BloodGroupJpaRepository bloodGroupJpaRepository;
	
	public PersonalDetailModel getPersonalDetail(){
		List<PersonalDetail> personalDetails = personalDetailJpaRepository.findAll();
		
		PersonalDetailModel personalDetailModel = new PersonalDetailModel();
		
		for (PersonalDetail personalDetail : personalDetails) {
			personalDetailModel.setGender(personalDetail.getGender());
			personalDetailModel.setBloodGroup(personalDetail.getBloodGroup().getBloodGroupId());
			personalDetailModel.setPlaceOfBirth(personalDetail.getPlaceOfBirth());
			personalDetailModel.setDomiciledIn(personalDetail.getDomicil());
			personalDetailModel.setMaritalStatus(personalDetail.getMaritalStatus());
			personalDetailModel.setFlatNo(personalDetail.getAddress().getFlatNo());
			personalDetailModel.setStreet(personalDetail.getAddress().getStreet());
			personalDetailModel.setArea(personalDetail.getAddress().getArea());
			personalDetailModel.setCity(personalDetail.getAddress().getCity());
			personalDetailModel.setState(personalDetail.getAddress().getState());
			personalDetailModel.setPinCode(personalDetail.getAddress().getPinCode());
			personalDetailModel.setBloodGroups(bloodGroupJpaRepository.findAll());
		}
		
		
				
		/*personalDetailModel.setGender("Female");
		personalDetailModel.setBloodGroup("O+ve");
		personalDetailModel.setPlaceOfBirth("Jalgaon");
		personalDetailModel.setDomiciledIn("Maharashtrs");
		personalDetailModel.setMaritalStatus("Married");
		personalDetailModel.setAddress("Runwal Swaranjali, Prathamesh Park, Baner");
		personalDetailModel.setCity("Pune");
		personalDetailModel.setState("Maharashtra");*/
		return personalDetailModel;
	}
}
