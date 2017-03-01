package com.web.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.data.entities.Enums.BloodGroup;
import com.data.entities.Enums.MaritalStatus;
import com.data.entities.Enums.NameChangeReason;
import com.data.entities.PersonalDetail;
import com.data.entities.UserDetail;
import com.data.services.PersonalDetailService;
import com.data.services.UserDetailService;
import com.web.model.PersonalDetailModel;
import com.web.services.PersonalDetailRCService;
import com.web.session.Session;

@Service("personalDetailRCService")
public class PersonalDetailRCServiceImpl implements PersonalDetailRCService {
	
	@Autowired
	PersonalDetailService personalDetailService;
	
	@Autowired
	UserDetailService userDetailService; 
	
	@Autowired
	Session userSession;
	
	public PersonalDetailModel getPersonalDetail(){
		PersonalDetailModel personalDetailModel = new PersonalDetailModel();
		UserDetail userDetail = userDetailService.getByUser(userSession.getCurrentUser());
		PersonalDetail personalDetail = personalDetailService.getByUser(userSession.getCurrentUser());
		personalDetailModel = setPersonalDetailModelObject(personalDetailModel, userDetail, personalDetail);
		return personalDetailModel;
	}
	
	public void savePersonalDetail(PersonalDetailModel personalDetailModel){
		PersonalDetail personalDetail = personalDetailService.getByUser(userSession.getCurrentUser());
		if(personalDetail == null) {
			personalDetail = new PersonalDetail();
			personalDetail.setUser(userSession.getCurrentUser());
		}
		
		/*Address address = personalDetail.getAddress();		
		if(address == null) {
			address = new Address();
			personalDetail.setAddress(address);
		}*/
		
		personalDetail = setPersonalDetailObject(personalDetail, personalDetailModel/*, address*/);
		
		personalDetailService.save(personalDetail);
		
	}

	private PersonalDetailModel setPersonalDetailModelObject(PersonalDetailModel personalDetailModel, 
			UserDetail userDetail, PersonalDetail personalDetail) {
		
		if(userDetail != null) {
			personalDetailModel.setLastName(userDetail.getLastName().toUpperCase());
			personalDetailModel.setFirstName(userDetail.getFirstName().toUpperCase());
			personalDetailModel.setBirthDate(userDetail.getDateOfBirth());
		}
		if(personalDetail != null) {
			personalDetailModel.setLastName(personalDetail.getLastName().toUpperCase());
			personalDetailModel.setFirstName(personalDetail.getFirstName().toUpperCase());
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
			personalDetailModel.setGender(personalDetail.getGender());
			personalDetailModel.setPlaceOfBirth(personalDetail.getPlaceOfBirth());
			personalDetailModel.setMaritalStatus(personalDetail.getMaritalStatus());
			personalDetailModel.setBloodGroup(personalDetail.getBloodGroup());
			
			personalDetailModel.setFathersLastName(personalDetail.getFathersLastName());
			personalDetailModel.setFathersFirstName(personalDetail.getFathersFirstName());
			personalDetailModel.setFathersMiddleName(personalDetail.getFathersMiddleName());
			personalDetailModel.setMothersLastName(personalDetail.getMothersLastName());
			personalDetailModel.setMothersFirstName(personalDetail.getMothersFirstName());
			personalDetailModel.setMothersMiddleName(personalDetail.getMothersMiddleName());
			personalDetailModel.setParentsEmailId(personalDetail.getParentsEmailId());
			personalDetailModel.setParentsContactNo(personalDetail.getParentsContactNo());
			/*personalDetailModel.setIsSelfEmployed(personalDetail.getIsSelfEmployed());*/
			
			personalDetailModel.setDomiciledIn(personalDetail.getDomicil());
			
			/*personalDetailModel.setFlatNo(personalDetail.getAddress().getFlatNo());
			personalDetailModel.setStreet(personalDetail.getAddress().getStreet());
			personalDetailModel.setArea(personalDetail.getAddress().getArea());
			personalDetailModel.setCity(personalDetail.getAddress().getCity());
			personalDetailModel.setState(personalDetail.getAddress().getState());
			personalDetailModel.setPinCode(personalDetail.getAddress().getPinCode());*/
		}
		personalDetailModel.setBloodGroupList(BloodGroup.getEnumList());
		personalDetailModel.setMaritalStatusList(MaritalStatus.getEnumList());
		personalDetailModel.setNameChangeReasonList(NameChangeReason.getEnumList());
		return personalDetailModel;
	}

	private PersonalDetail setPersonalDetailObject(PersonalDetail personalDetail, PersonalDetailModel personalDetailModel/*, Address address*/) {
		
		personalDetail.setLastName(personalDetailModel.getLastName().toUpperCase());
		personalDetail.setFirstName(personalDetailModel.getFirstName().toUpperCase());
		personalDetail.setMiddleName(personalDetailModel.getMiddleName().toUpperCase());
		personalDetail.setMotherName(personalDetailModel.getMothersName());
		personalDetail.setLastNameRegional(personalDetailModel.getLastNameRegional());
		personalDetail.setFirstNameRegional(personalDetailModel.getFirstNameRegional());
		personalDetail.setMiddleNameRegional(personalDetailModel.getMiddleNameRegional());
		personalDetail.setIsPreviousName(personalDetailModel.getIsPreviousName());
		personalDetail.setLastNamePrevious(personalDetailModel.getLastNamePrevious());
		personalDetail.setFirstNamePrevious(personalDetailModel.getFirstNamePrevious());
		personalDetail.setMiddleNamePrevious(personalDetailModel.getMiddleNamePrevious());
		personalDetail.setNameChangeReason(personalDetailModel.getNameChangeReason());
		
		personalDetail.setAdharNo(personalDetailModel.getAdharNo());		
		personalDetail.setBloodGroup(personalDetailModel.getBloodGroup());
		personalDetail.setGender(personalDetailModel.getGender());
		personalDetail.setMaritalStatus(personalDetailModel.getMaritalStatus());
		personalDetail.setPlaceOfBirth(personalDetailModel.getPlaceOfBirth());
		
		personalDetail.setFathersLastName(personalDetailModel.getFathersLastName());
		personalDetail.setFathersFirstName(personalDetailModel.getFathersFirstName());
		personalDetail.setFathersMiddleName(personalDetailModel.getFathersMiddleName());
		personalDetail.setMothersLastName(personalDetailModel.getMothersLastName());
		personalDetail.setMothersFirstName(personalDetailModel.getMothersFirstName());
		personalDetail.setMothersMiddleName(personalDetailModel.getMothersMiddleName());
		personalDetail.setParentsEmailId(personalDetailModel.getParentsEmailId());
		personalDetail.setParentsContactNo(personalDetailModel.getParentsContactNo());
		/*personalDetail.setIsSelfEmployed(personalDetailModel.getIsSelfEmployed());*/
		
		personalDetail.setDomicil(personalDetailModel.getDomiciledIn());
		
		/*address.setFlatNo(personalDetailModel.getFlatNo());
		address.setStreet(personalDetailModel.getStreet());
		address.setArea(personalDetailModel.getArea());
		address.setCity(personalDetailModel.getCity());
		address.setState(personalDetailModel.getState());
		address.setPinCode(personalDetailModel.getPinCode());*/
		
		return personalDetail;
	}
}