package com.web.services.impl;

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
import com.web.model.PersonalDetailModel;
import com.web.services.PersonalDetailService;
import com.web.session.Session;

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
	Session userSession;
	
	public PersonalDetailModel getPersonalDetail(){
		UserDetail basicDetail = basicDetailJpaRepository.findByUser(userSession.getCurrentUser());
		PersonalDetail personalDetail = personalDetailJpaRepository.findByUser(userSession.getCurrentUser());
		PersonalDetailModel personalDetailModel = new PersonalDetailModel();
		
		if(basicDetail != null) {
			personalDetailModel.setLastName(basicDetail.getLastName().toUpperCase());
			personalDetailModel.setFirstName(basicDetail.getFirstName().toUpperCase());
			personalDetailModel.setBirthDate(basicDetail.getDateOfBirth());
		}
		if(personalDetail != null) {
			personalDetailModel.setLastName(personalDetail.getLastName().toUpperCase());
			personalDetailModel.setFirstName(personalDetail.getFirstName().toUpperCase());
			personalDetailModel.setRelationType(personalDetail.getRelationType());
			personalDetailModel.setMiddleName(personalDetail.getMiddleName().toUpperCase());
			personalDetailModel.setMothersName(personalDetail.getMotherName());
			personalDetailModel.setLastNameRegional(personalDetail.getLastNameRegional());
			personalDetailModel.setFirstNameRegional(personalDetail.getFirstNameRegional());
			personalDetailModel.setMiddleNameRegional(personalDetail.getMiddleNameRegional());
			personalDetailModel.setIsPreviousName(personalDetail.getIsPreviousName());
			personalDetailModel.setLastNamePrevious(personalDetail.getLastNamePrevious());
			personalDetailModel.setFirstNamePrevious(personalDetail.getFirstNamePrevious());
			personalDetailModel.setMiddleNamePrevious(personalDetail.getMiddleNamePrevious());
			personalDetailModel.setNameChangeReason(personalDetail.getNameChangeReason());
			
			
			personalDetailModel.setAdharNo(personalDetail.getAdharNo());
			personalDetailModel.setGender(personalDetail.getGender().getValue());
			personalDetailModel.setPlaceOfBirth(personalDetail.getPlaceOfBirth());
			personalDetailModel.setMaritalStatus(personalDetail.getMaritalStatus());
			personalDetailModel.setBloodGroup(personalDetail.getBloodGroup() != null ? personalDetail.getBloodGroup().getBloodGroupId() : -1);
			
			personalDetailModel.setDomiciledIn(personalDetail.getDomicil());
			
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
		personalDetail.setAdharNo(personalDetailModel.getAdharNo());		
		
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
