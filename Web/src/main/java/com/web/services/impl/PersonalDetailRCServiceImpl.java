package com.web.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.data.entities.Enums;
import com.data.entities.Enums.BloodGroup;
import com.data.entities.Enums.MaritalStatus;
import com.data.entities.Enums.NameChangeReason;
import com.data.entities.Enums.PassportIssuingAuthority;
import com.data.entities.Enums.VisaSponsoringAgency;
import com.data.entities.Enums.VisaType;
import com.data.entities.PersonalDetail;
import com.data.entities.User;
import com.data.entities.UserDetail;
import com.data.services.GeoLocationsService;
import com.data.services.PersonalDetailService;
import com.data.services.UserDetailService;
import com.data.services.UserDocumentService;
import com.web.model.PersonalDetailModel;
import com.web.services.PersonalDetailRCService;
import com.web.staticandconstants.StaticConstants;

@Service("personalDetailRCService")
public class PersonalDetailRCServiceImpl implements PersonalDetailRCService {
	
	@Autowired
	PersonalDetailService personalDetailService;
	
	@Autowired
	UserDetailService userDetailService; 
	
	@Autowired
	GeoLocationsService geoLocationService;
	
	@Autowired
	UserDocumentService userDocumentService;
	
	public PersonalDetailModel getPersonalDetail(User user){
		PersonalDetailModel personalDetailModel = new PersonalDetailModel();
		PersonalDetail personalDetail = personalDetailService.getByUserDetail(user.getUserDetail());
		personalDetailModel = setPersonalDetailModelObject(personalDetailModel, user.getUserDetail(), personalDetail);
		return personalDetailModel;
	}
	
	public void savePersonalDetail(PersonalDetailModel personalDetailModel, User user){
		//Updating data in UserDetail Table
		user.getUserDetail().setDateOfBirth(personalDetailModel.getBirthDate());
		
		//Updating data in PersonalDetail Table
		PersonalDetail personalDetail = personalDetailService.getByUserDetail(user.getUserDetail());
		if(personalDetail == null) {
			personalDetail = new PersonalDetail();
			personalDetail.setUserDetail(user.getUserDetail());
		}
		
		personalDetail = setPersonalDetailObject(personalDetail, personalDetailModel/*, address*/);
		
		//Updating required document list as per filled data
		if(personalDetail.getIsNameChanged() != null) {
			if(personalDetail.getIsNameChanged()) {
				userDocumentService.addByDocumentFor(user.getUserDetail(), Enums.DocumentsFor.NameChanged.getId());
			} else {
				userDocumentService.deleteByDocumentFor(user.getUserDetail(), Enums.DocumentsFor.NameChanged.getId());
			}
		}
		
		if(personalDetail.getEducationGapInYrs() != null && personalDetail.getEducationGapInYrs() > 0) {
			userDocumentService.addByDocumentFor(user.getUserDetail(), Enums.DocumentsFor.EducationGap.getId());
		} else {
			userDocumentService.deleteByDocumentFor(user.getUserDetail(), Enums.DocumentsFor.EducationGap.getId());
		}
		
		if(personalDetail.getCountryOfCitizenship() != null 
				&& personalDetail.getCountryOfCitizenship().getCountryName().compareToIgnoreCase(StaticConstants.StrINDIA) == 0) {
			userDocumentService.deleteByDocumentFor(user.getUserDetail(), Enums.DocumentsFor.Passport.getId());
		} else {
			userDocumentService.addByDocumentFor(user.getUserDetail(), Enums.DocumentsFor.Passport.getId());			
		}
		
		personalDetailService.save(personalDetail);
		
	}

	private PersonalDetailModel setPersonalDetailModelObject(PersonalDetailModel personalDetailModel, 
			UserDetail userDetail, PersonalDetail personalDetail) {
		
		if(userDetail != null) {
			if(userDetail.getLastName() != null) {
				personalDetailModel.setLastName(userDetail.getLastName().toUpperCase());
			}
			if(userDetail.getFirstName() != null) {
				personalDetailModel.setFirstName(userDetail.getFirstName().toUpperCase());
			}
			personalDetailModel.setBirthDate(userDetail.getDateOfBirth());
		}
		if(personalDetail != null) {
			personalDetailModel.setLastName(personalDetail.getLastName());
			personalDetailModel.setFirstName(personalDetail.getFirstName());
			personalDetailModel.setMiddleName(personalDetail.getMiddleName());
			personalDetailModel.setMothersName(personalDetail.getMotherName());
			personalDetailModel.setLastNameRegional(personalDetail.getLastNameRegional());
			personalDetailModel.setFirstNameRegional(personalDetail.getFirstNameRegional());
			personalDetailModel.setMiddleNameRegional(personalDetail.getMiddleNameRegional());
			personalDetailModel.setIsNameChanged(personalDetail.getIsNameChanged());
			personalDetailModel.setNewLastName(personalDetail.getNewLastName());
			personalDetailModel.setNewFirstName(personalDetail.getNewFirstName());
			personalDetailModel.setNewMiddleName(personalDetail.getNewMiddleName());
			personalDetailModel.setNameChangeReason(personalDetail.getNameChangeReason());
			
			
			personalDetailModel.setAdharNo(personalDetail.getAdharNo());
			personalDetailModel.setGender(personalDetail.getGender());
			personalDetailModel.setPlaceOfBirth(personalDetail.getPlaceOfBirth());
			personalDetailModel.setMaritalStatus(personalDetail.getMaritalStatus());
			personalDetailModel.setBloodGroup(personalDetail.getBloodGroup());
			personalDetailModel.setEducationGapInYrs(personalDetail.getEducationGapInYrs());
			
			personalDetailModel.setFathersLastName(personalDetail.getFathersLastName());
			personalDetailModel.setFathersFirstName(personalDetail.getFathersFirstName());
			personalDetailModel.setFathersMiddleName(personalDetail.getFathersMiddleName());
			personalDetailModel.setMothersLastName(personalDetail.getMothersLastName());
			personalDetailModel.setMothersFirstName(personalDetail.getMothersFirstName());
			personalDetailModel.setMothersMiddleName(personalDetail.getMothersMiddleName());
			personalDetailModel.setParentsEmailId(personalDetail.getParentsEmailId());
			personalDetailModel.setParentsContactNo(personalDetail.getParentsContactNo());
			
			personalDetailModel.setCountryOfCitizenship(personalDetail.getCountryOfCitizenship());
			personalDetailModel.setDomiciledIn(personalDetail.getDomiciledIn());
			personalDetailModel.setPassportNo(personalDetail.getPassportNo());
			personalDetailModel.setPassportIssuePlace(personalDetail.getPassportIssuePlace());
			personalDetailModel.setPassportIssueDate(personalDetail.getPassportIssueDate());
			personalDetailModel.setPassportExpiryDate(personalDetail.getPassportExpiryDate());
			personalDetailModel.setPassportIssuingAuthority(personalDetail.getPassportIssuingAuthority());
			personalDetailModel.setPassportIssuingCountry(personalDetail.getPassportIssuingCountry());
			personalDetailModel.setVisaType(personalDetail.getVisaType());
			personalDetailModel.setVisaValidUpto(personalDetail.getVisaValidUpto());
			personalDetailModel.setVisaSponsoringAgency(personalDetail.getVisaSponsoringAgency());
			personalDetailModel.setResidentialPermitNo(personalDetail.getResidentialPermitNo());
		}
		personalDetailModel.setBloodGroupList(BloodGroup.getEnumList());
		personalDetailModel.setMaritalStatusList(MaritalStatus.getEnumList());
		personalDetailModel.setNameChangeReasonList(NameChangeReason.getEnumList());
		personalDetailModel.setPassportIssuingAuthorityList(PassportIssuingAuthority.getEnumList());
		personalDetailModel.setVisaTypeList(VisaType.getEnumList());
		personalDetailModel.setVisaSponsoringAgencyList(VisaSponsoringAgency.getEnumList());
		personalDetailModel.setCountryList(geoLocationService.getCountryList());
		personalDetailModel.setStateList(geoLocationService.getStateListByCountryName(StaticConstants.StrINDIA));
		return personalDetailModel;
	}

	private PersonalDetail setPersonalDetailObject(PersonalDetail personalDetail, PersonalDetailModel personalDetailModel/*, Address address*/) {
		if(personalDetailModel.getLastName() != null) {
			personalDetail.setLastName(personalDetailModel.getLastName().toUpperCase());
		} else {
			personalDetail.setLastName(null);
		}
		if(personalDetailModel.getFirstName() != null) {
			personalDetail.setFirstName(personalDetailModel.getFirstName().toUpperCase());
		} else {
			personalDetail.setFirstName(null);
		}
		if(personalDetailModel.getMiddleName() != null) {
			personalDetail.setMiddleName(personalDetailModel.getMiddleName().toUpperCase());
		} else {
			personalDetail.setMiddleName(null);
		}
		if(personalDetailModel.getMothersName() != null) {
			personalDetail.setMotherName(personalDetailModel.getMothersName().toUpperCase());
		} else {
			personalDetail.setMotherName(null);
		}
		personalDetail.setLastNameRegional(personalDetailModel.getLastNameRegional());
		personalDetail.setFirstNameRegional(personalDetailModel.getFirstNameRegional());
		personalDetail.setMiddleNameRegional(personalDetailModel.getMiddleNameRegional());
		personalDetail.setIsNameChanged(personalDetailModel.getIsNameChanged());
		if(personalDetailModel.getNewLastName() != null) {
			personalDetail.setNewLastName(personalDetailModel.getNewLastName().toUpperCase());
		} else {
			personalDetail.setNewLastName(null);
		}
		if(personalDetailModel.getNewFirstName() != null) {
			personalDetail.setNewFirstName(personalDetailModel.getNewFirstName().toUpperCase());
		} else {
			personalDetail.setNewFirstName(null);
		}
		if(personalDetailModel.getNewMiddleName() != null) {
			personalDetail.setNewMiddleName(personalDetailModel.getNewMiddleName().toUpperCase());
		} else {
			personalDetail.setNewMiddleName(null);
		}
		personalDetail.setNameChangeReason(personalDetailModel.getNameChangeReason());
		
		personalDetail.setAdharNo(personalDetailModel.getAdharNo());		
		personalDetail.setBloodGroup(personalDetailModel.getBloodGroup());
		personalDetail.setGender(personalDetailModel.getGender());
		personalDetail.setMaritalStatus(personalDetailModel.getMaritalStatus());
		personalDetail.setPlaceOfBirth(personalDetailModel.getPlaceOfBirth());
		personalDetail.setEducationGapInYrs(personalDetailModel.getEducationGapInYrs());
		
		if(personalDetailModel.getFathersLastName() != null) {
			personalDetail.setFathersLastName(personalDetailModel.getFathersLastName().toUpperCase());
		} else {
			personalDetail.setFathersLastName(null);
		}
		if(personalDetailModel.getFathersFirstName() != null) {
			personalDetail.setFathersFirstName(personalDetailModel.getFathersFirstName().toUpperCase());
		} else {
			personalDetail.setFathersFirstName(null);
		}
		if(personalDetailModel.getFathersMiddleName() != null) {
			personalDetail.setFathersMiddleName(personalDetailModel.getFathersMiddleName().toUpperCase());
		} else {
			personalDetail.setFathersMiddleName(null);
		}
		if(personalDetailModel.getMothersLastName() != null) {
			personalDetail.setMothersLastName(personalDetailModel.getMothersLastName().toUpperCase());
		} else {
			personalDetail.setMothersLastName(null);
		}
		if(personalDetailModel.getMothersFirstName() != null) {
			personalDetail.setMothersFirstName(personalDetailModel.getMothersFirstName().toUpperCase());
		} else {
			personalDetail.setMothersFirstName(null);
		}
		if(personalDetailModel.getMothersMiddleName() != null) {
			personalDetail.setMothersMiddleName(personalDetailModel.getMothersMiddleName().toUpperCase());
		} else {
			personalDetail.setMothersMiddleName(null);
		}
		personalDetail.setParentsEmailId(personalDetailModel.getParentsEmailId());
		personalDetail.setParentsContactNo(personalDetailModel.getParentsContactNo());
		
		personalDetail.setCountryOfCitizenship(personalDetailModel.getCountryOfCitizenship());
		personalDetail.setDomiciledIn(personalDetailModel.getDomiciledIn());
		personalDetail.setPassportNo(personalDetailModel.getPassportNo());
		personalDetail.setPassportIssuePlace(personalDetailModel.getPassportIssuePlace());
		personalDetail.setPassportIssueDate(personalDetailModel.getPassportIssueDate());
		personalDetail.setPassportExpiryDate(personalDetailModel.getPassportExpiryDate());
		personalDetail.setPassportIssuingAuthority(personalDetailModel.getPassportIssuingAuthority());
		personalDetail.setPassportIssuingCountry(personalDetailModel.getPassportIssuingCountry());
		personalDetail.setVisaType(personalDetailModel.getVisaType());
		personalDetail.setVisaValidUpto(personalDetailModel.getVisaValidUpto());
		personalDetail.setVisaSponsoringAgency(personalDetailModel.getVisaSponsoringAgency());
		personalDetail.setResidentialPermitNo(personalDetailModel.getResidentialPermitNo());
				
		return personalDetail;
	}
}
