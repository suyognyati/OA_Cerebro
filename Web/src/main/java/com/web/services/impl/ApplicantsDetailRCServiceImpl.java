package com.web.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.data.entities.Enums;
import com.data.entities.PersonalDetail;
import com.data.entities.User;
import com.data.entities.UserDetail;
import com.data.services.PersonalDetailService;
import com.data.services.UserDetailService;
import com.web.model.ApplicantsModel;
import com.web.services.ApplicantsRCService;

@Service("ApplicantsRCService")
public class ApplicantsDetailRCServiceImpl implements ApplicantsRCService {

	@Autowired
	PersonalDetailService personalDetailService;
	
	@Autowired
	UserDetailService userDetailService; 
	
	ApplicantsModel applicantsModel = null;
	
	@Override
	public ApplicantsModel getApplicantDetail(User user) {
		if(applicantsModel == null)
			applicantsModel = new ApplicantsModel();
		
		getPersonalDetail(user);
		
		return applicantsModel;
	}
	
	private void getPersonalDetail(User user) {
		
		UserDetail userDetail = userDetailService.getByUser(user);
		PersonalDetail personalDetail = personalDetailService.getByUser(user);
		
		if(userDetail != null) {
			applicantsModel.setBirthDate(userDetail.getDateOfBirth());
		}
		if(personalDetail != null) {
			if(personalDetail.getLastName() != null) {
				applicantsModel.setLastName(personalDetail.getLastName().toUpperCase());
			}
			if(personalDetail.getFirstName() != null) {
				applicantsModel.setFirstName(personalDetail.getFirstName().toUpperCase());
			}
			if(personalDetail.getFirstName() != null) {
				applicantsModel.setMiddleName(personalDetail.getMiddleName().toUpperCase());
			}
			applicantsModel.setMothersName(personalDetail.getMotherName());
			applicantsModel.setLastNameRegional(personalDetail.getLastNameRegional());
			applicantsModel.setFirstNameRegional(personalDetail.getFirstNameRegional());
			applicantsModel.setMiddleNameRegional(personalDetail.getMiddleNameRegional());
			applicantsModel.setIsNameChanged(personalDetail.getIsNameChanged());
			applicantsModel.setNewLastName(personalDetail.getNewLastName());
			applicantsModel.setNewFirstName(personalDetail.getNewFirstName());
			applicantsModel.setNewMiddleName(personalDetail.getNewMiddleName());
			applicantsModel.setNameChangeReason(Enums.NameChangeReason.get(personalDetail.getNameChangeReason()).getValue());			
			
			applicantsModel.setAdharNo(personalDetail.getAdharNo());
			applicantsModel.setGender(Enums.Gender.get(personalDetail.getGender()).getValue());
			applicantsModel.setPlaceOfBirth(personalDetail.getPlaceOfBirth());
			applicantsModel.setMaritalStatus(Enums.MaritalStatus.get(personalDetail.getMaritalStatus()).getValue());
			applicantsModel.setBloodGroup(Enums.BloodGroup.get(personalDetail.getBloodGroup()).getValue());
			applicantsModel.setEducationGapInYrs(personalDetail.getEducationGapInYrs());
			
			applicantsModel.setFathersLastName(personalDetail.getFathersLastName());
			applicantsModel.setFathersFirstName(personalDetail.getFathersFirstName());
			applicantsModel.setFathersMiddleName(personalDetail.getFathersMiddleName());
			applicantsModel.setMothersLastName(personalDetail.getMothersLastName());
			applicantsModel.setMothersFirstName(personalDetail.getMothersFirstName());
			applicantsModel.setMothersMiddleName(personalDetail.getMothersMiddleName());
			applicantsModel.setParentsEmailId(personalDetail.getParentsEmailId());
			applicantsModel.setParentsContactNo(personalDetail.getParentsContactNo());
			
			applicantsModel.setCountryOfCitizenship(personalDetail.getCountryOfCitizenship());
			applicantsModel.setDomiciledIn(personalDetail.getDomiciledIn());
			applicantsModel.setPassportNo(personalDetail.getPassportNo());
			applicantsModel.setPassportIssuePlace(personalDetail.getPassportIssuePlace());
			applicantsModel.setPassportIssueDate(personalDetail.getPassportIssueDate());
			applicantsModel.setPassportExpiryDate(personalDetail.getPassportExpiryDate());
			applicantsModel.setPassportIssuingAuthority(Enums.PassportIssuingAuthority.get(personalDetail.getPassportIssuingAuthority()).getValue());
			applicantsModel.setPassportIssuingCountry(personalDetail.getPassportIssuingCountry());
			applicantsModel.setVisaType(Enums.VisaType.get(personalDetail.getVisaType()).getValue());
			applicantsModel.setVisaValidUpto(personalDetail.getVisaValidUpto());
			applicantsModel.setVisaSponsoringAgency(personalDetail.getVisaSponsoringAgency());
			applicantsModel.setResidentialPermitNo(personalDetail.getResidentialPermitNo());
		}
	}

}
