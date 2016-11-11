package com.web.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.data.entities.Address;
import com.data.entities.BasicDetail;
import com.data.entities.BloodGroup;
import com.data.entities.Enums;
import com.data.entities.PersonalDetail;
import com.data.repository.BasicDetailJpaRepository;
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
	BasicDetailJpaRepository basicDetailJpaRepository; 
	
	@Autowired
	UserJpaRepository userJpaRepository;
	
	@Autowired
	BloodGroupJpaRepository bloodGroupJpaRepository;
	
	@Autowired
	UserSession userSession;
	
	public PersonalDetailModel getPersonalDetail(){
		BasicDetail basicDetail = basicDetailJpaRepository.findByUser(userSession.getCurrentUser());
		PersonalDetail personalDetail = personalDetailJpaRepository.findByUser(userSession.getCurrentUser());
		PersonalDetailModel personalDetailModel = new PersonalDetailModel();
		
		if(basicDetail != null) {
			personalDetailModel.setLastName(basicDetail.getLastName());
			personalDetailModel.setFirstName(basicDetail.getFirstName());
			personalDetailModel.setMiddleName(basicDetail.getMidleName());
			personalDetailModel.setMothersName(basicDetail.getMotherName());
			personalDetailModel.setBirthDate(basicDetail.getDateOfBirth());
			personalDetailModel.setEmail(basicDetail.getEmail());
			personalDetailModel.setMobileNo(basicDetail.getMobileNo());
			personalDetailModel.setOtherContactNo(basicDetail.getOtherContact());
		}
		if(personalDetail != null) {
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
		BasicDetail basicDetail = basicDetailJpaRepository.findByUser(userSession.getCurrentUser());
		PersonalDetail personalDetail = personalDetailJpaRepository.findByUser(userSession.getCurrentUser());

		if(basicDetail == null) {
			basicDetail = new BasicDetail();
			basicDetail.setUser(userSession.getCurrentUser());
		}
		
		if(personalDetail == null) {
			personalDetail = new PersonalDetail();
			personalDetail.setUser(userSession.getCurrentUser());
		}
		
		basicDetail.setLastName(personalDetailModel.getLastName());
		basicDetail.setFirstName(personalDetailModel.getFirstName());
		basicDetail.setMidleName(personalDetailModel.getMiddleName());
		basicDetail.setMotherName(personalDetailModel.getMothersName());
		basicDetail.setDateOfBirth(personalDetailModel.getBirthDate());
		basicDetail.setOtherContact(personalDetailModel.getOtherContactNo());		
		basicDetailJpaRepository.save(basicDetail);
		
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
