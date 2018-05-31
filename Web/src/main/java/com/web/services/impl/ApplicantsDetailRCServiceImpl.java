package com.web.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.data.entities.Address;
import com.data.entities.Enums;
import com.data.entities.OccupationReservation;
import com.data.entities.PersonalDetail;
import com.data.entities.User;
import com.data.entities.Student;
import com.data.services.AddressService;
import com.data.services.OccupationReservationService;
import com.data.services.PersonalDetailService;
import com.data.services.StudentService;
import com.web.model.ApplicantsModel;
import com.web.services.ApplicantsRCService;

@Service("ApplicantsRCService")
public class ApplicantsDetailRCServiceImpl implements ApplicantsRCService {

	@Autowired
	StudentService studentService; 
	
	@Autowired
	PersonalDetailService personalDetailService;
	
	@Autowired
	AddressService addressService;
	
	@Autowired
	OccupationReservationService occupationReservationService;
	
	ApplicantsModel applicantsModel = null;
	
	@Override
	public ApplicantsModel getApplicantDetail(User user) {
		if(applicantsModel == null)
			applicantsModel = new ApplicantsModel();
		
		getPersonalDetail(user);
		getAddress(user);
		getOccupation(user);
		
		return applicantsModel;
	}
	
	private void getPersonalDetail(User user) {
		
		Student student = user.getStudent();
		PersonalDetail personalDetail = personalDetailService.getByStudent(user.getStudent());
		
		if(student != null) {
			applicantsModel.setBirthDate(student.getDateOfBirth());
			applicantsModel.setMobileNo(student.getMobileNo());
			applicantsModel.setEmail(student.getEmail());
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
			if(personalDetail.getNameChangeReason() != null
					&& Enums.NameChangeReason.get(personalDetail.getNameChangeReason()) != null) {
				applicantsModel.setNameChangeReason(Enums.NameChangeReason.get(personalDetail.getNameChangeReason()).getValue());
			}
			
			applicantsModel.setAdharNo(personalDetail.getAdharNo());
			if(personalDetail.getGender() != null
					&& Enums.Gender.get(personalDetail.getGender()) != null) {
				applicantsModel.setGender(Enums.Gender.get(personalDetail.getGender()).getValue());
			}
			applicantsModel.setPlaceOfBirth(personalDetail.getPlaceOfBirth());
			if(personalDetail.getMaritalStatus() != null
					&& Enums.MaritalStatus.get(personalDetail.getMaritalStatus()) != null) {
				applicantsModel.setMaritalStatus(Enums.MaritalStatus.get(personalDetail.getMaritalStatus()).getValue());
			}
			if(personalDetail.getBloodGroup() != null
					&& Enums.BloodGroup.get(personalDetail.getBloodGroup()) != null) {
				applicantsModel.setBloodGroup(Enums.BloodGroup.get(personalDetail.getBloodGroup()).getValue());
			}
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
			if(personalDetail.getPassportIssuingAuthority() != null
					&& Enums.PassportIssuingAuthority.get(personalDetail.getPassportIssuingAuthority()) != null) {
				applicantsModel.setPassportIssuingAuthority(Enums.PassportIssuingAuthority.get(personalDetail.getPassportIssuingAuthority()).getValue());
			}
			applicantsModel.setPassportIssuingCountry(personalDetail.getPassportIssuingCountry());
			if(personalDetail.getVisaType() != null
					&& Enums.VisaType.get(personalDetail.getVisaType()) != null) {
				applicantsModel.setVisaType(Enums.VisaType.get(personalDetail.getVisaType()).getValue());
			}
			applicantsModel.setVisaValidUpto(personalDetail.getVisaValidUpto());
			applicantsModel.setVisaSponsoringAgency(personalDetail.getVisaSponsoringAgency());
			applicantsModel.setResidentialPermitNo(personalDetail.getResidentialPermitNo());
		}
	}

	private void getAddress(User user) {
		Address address = addressService.getByStudent(user.getStudent());
		
		if(address != null) {
			applicantsModel.setFlatNo(address.getFlatNo());
			applicantsModel.setStreet(address.getStreet());
			applicantsModel.setArea(address.getArea());
			applicantsModel.setLandmark(address.getLandmark());
			applicantsModel.setPinCode(address.getPinCode());
			applicantsModel.setCity(address.getCity());
			applicantsModel.setDistrict(address.getDistrict());
			applicantsModel.setState(address.getState());
			applicantsModel.setCountry(address.getCountry());
			if(address.getLocationArea() != null
					&& Enums.LocationArea.get(address.getLocationArea()) != null) {
				applicantsModel.setLocationArea(Enums.LocationArea.get(address.getLocationArea()).getValue());
			}
			
	
			applicantsModel.setIsSameAsCorrespondence(address.getIsNotSameAsCorrespondence());
			
			applicantsModel.setFlatNoPermanent(address.getFlatNoPermanent());
			applicantsModel.setStreetPermanent(address.getStreetPermanent());
			applicantsModel.setAreaPermanent(address.getAreaPermanent());
			applicantsModel.setLandmarkPermanent(address.getLandmarkPermanent());
			applicantsModel.setPinCodePermanent(address.getPinCodePermanent());
			applicantsModel.setCityPermanent(address.getCityPermanent());
			applicantsModel.setDistrictPermanent(address.getDistrictPermanent());
			applicantsModel.setStatePermanent(address.getStatePermanent());
			applicantsModel.setCountryPermanent(address.getCountryPermanent());
			if(address.getLocationAreaPermanent() != null
					&& Enums.LocationArea.get(address.getLocationAreaPermanent()) != null) {
				applicantsModel.setLocationAreaPermanent(Enums.LocationArea.get(address.getLocationAreaPermanent()).getValue());
			}
		}
	}
	
	private void getOccupation(User user) {
		OccupationReservation occupationAndReservation = occupationReservationService.getByStudent(user.getStudent());
				
		if(occupationAndReservation != null) {
			applicantsModel.setIsSelfEmployed(occupationAndReservation.getIsSelfEmployed());
			applicantsModel.setExperienceYrs(occupationAndReservation.getExperienceYrs());
			applicantsModel.setExperienceMonths(occupationAndReservation.getExperienceMonths());
			if(occupationAndReservation.getOccupation() != null
					&& Enums.Occupation.get(occupationAndReservation.getOccupation()) != null) {
				applicantsModel.setOccupation(Enums.Occupation.get(occupationAndReservation.getOccupation()).getValue());
			}
			applicantsModel.setSelfAnnualIncome(occupationAndReservation.getSelfAnnualIncome());
			applicantsModel.setIsLeaveWithoutPay(occupationAndReservation.getIsLeaveWithoutPay());
			applicantsModel.setGuardianAnnualIncome(occupationAndReservation.getGuardianAnnualIncome());
			applicantsModel.setIsEligibleForEBC(occupationAndReservation.getIsEligibleForEBC());
			applicantsModel.setCaste(occupationAndReservation.getCaste());
			if(occupationAndReservation.getCategory() != null
					&& Enums.Category.get(occupationAndReservation.getCategory()) != null) {
				applicantsModel.setCategory(Enums.Category.get(occupationAndReservation.getCategory()).getValue());
			}
			if(occupationAndReservation.getReligion() != null
					&& Enums.Religion.get(occupationAndReservation.getReligion()) != null) {
				applicantsModel.setReligion(Enums.Religion.get(occupationAndReservation.getReligion()).getValue());
			}
			if(occupationAndReservation.getMotherTongue() != null 
					&& Enums.MotherTongue.get(occupationAndReservation.getMotherTongue()) != null) {
				applicantsModel.setMotherTongue(Enums.MotherTongue.get(occupationAndReservation.getMotherTongue()).getValue());
			}
			if(occupationAndReservation.getSpeciallyAbled() != null
					&& Enums.SpeciallyAbled.get(occupationAndReservation.getSpeciallyAbled()) != null) {
					applicantsModel.setSpeciallyAbled(Enums.SpeciallyAbled.get(occupationAndReservation.getSpeciallyAbled()).getValue());
			}
		}
	}
	
}
