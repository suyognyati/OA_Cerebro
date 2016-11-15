package com.web.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.data.entities.Address;
import com.data.entities.UserDetail;
import com.data.entities.BloodGroup;
import com.data.entities.Enums;
import com.data.entities.PersonalDetail;
import com.data.repository.UserDetailJpaRepository;
import com.data.repository.BloodGroupJpaRepository;
import com.data.repository.PersonalDetailJpaRepository;
import com.data.repository.UserJpaRepository;
import com.web.common.UserSession;
import com.web.model.PersonalDetailModel;

@Service("personalDetailService")
public class PersonalDetailServiceImpl implements PersonalDetailService {
	
	@Autowired
	PersonalDetailJpaRepository personalDetailJpaRepository;
	
	@Autowired
	UserDetailJpaRepository basicDetailJpaRepository; 
	
	@Autowired
	UserJpaRepository userJpaRepository;
	
	@Autowired
	BloodGroupJpaRepository bloodGroupJpaRepository;
	
	@Autowired
	UserSession userSession;
	
	public PersonalDetailModel getPersonalDetail(){
		UserDetail basicDetail = basicDetailJpaRepository.findByUser(userSession.getCurrentUser());
		PersonalDetail personalDetail = personalDetailJpaRepository.findByUser(userSession.getCurrentUser());
		PersonalDetailModel personalDetailModel = new PersonalDetailModel();
		
		if(basicDetail != null) {
			personalDetailModel.setLastName(basicDetail.getLastName().toUpperCase());
			personalDetailModel.setFirstName(basicDetail.getFirstName().toUpperCase());
			personalDetailModel.setBirthDate(basicDetail.getDateOfBirth());
			personalDetailModel.setEmail(basicDetail.getEmail());
			personalDetailModel.setMobileNo(basicDetail.getMobileNo());
		}
		if(personalDetail != null) {
			personalDetailModel.setLastName(personalDetail.getLastName().toUpperCase());
			personalDetailModel.setFirstName(personalDetail.getFirstName().toUpperCase());
			personalDetailModel.setMiddleName(personalDetail.getMiddleName().toUpperCase());
			personalDetailModel.setMothersName(personalDetail.getMotherName());
			personalDetailModel.setOtherContactNo(personalDetail.getOtherContact());
			personalDetailModel.setGender(personalDetail.getGender().getValue());
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
		}
		personalDetailModel.setBloodGroups(bloodGroupJpaRepository.findAll());
		return personalDetailModel;
	}
	
	public void savePersonalDetail(PersonalDetailModel personalDetailModel){
		PersonalDetail personalDetail = personalDetailJpaRepository.findByUser(userSession.getCurrentUser());

		if(personalDetail == null) {
			personalDetail = new PersonalDetail();
			personalDetail.setUser(userSession.getCurrentUser());
		}
		
		personalDetail.setLastName(personalDetailModel.getLastName());
		personalDetail.setFirstName(personalDetailModel.getFirstName());
		personalDetail.setMiddleName(personalDetailModel.getMiddleName());
		personalDetail.setMotherName(personalDetailModel.getMothersName());
		personalDetail.setOtherContact(personalDetailModel.getOtherContactNo());		
		
		BloodGroup bloodGroup = bloodGroupJpaRepository.findByBloodGroupId(personalDetailModel.getBloodGroup());
		personalDetail.setBloodGroup(bloodGroup);
		personalDetail.setDomicil(personalDetailModel.getDomiciledIn());
		personalDetail.setGender(Enums.GenderTypes[personalDetailModel.getGender() - 1]);
		personalDetail.setMaritalStatus(personalDetailModel.getMaritalStatus());
		personalDetail.setPlaceOfBirth(personalDetailModel.getPlaceOfBirth());
		
		Address address = personalDetail.getAddress();
		
		if(address == null) {
			address = new Address();
			personalDetail.setAddress(address);
		}
		
		address.setFlatNo(personalDetailModel.getFlatNo());
		address.setStreet(personalDetailModel.getStreet());
		address.setArea(personalDetailModel.getArea());
		address.setCity(personalDetailModel.getCity());
		address.setState(personalDetailModel.getState());
		address.setPinCode(personalDetailModel.getPinCode());
		
		personalDetailJpaRepository.save(personalDetail);
		
	}
}
