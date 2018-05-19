package com.web.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.data.entities.Address;
import com.data.entities.Enums;
import com.data.entities.OccupationReservation;
import com.data.entities.PersonalDetail;
import com.data.entities.User;
import com.data.entities.UserDetail;
import com.data.services.AddressService;
import com.data.services.OccupationReservationService;
import com.data.services.PersonalDetailService;
import com.data.services.UserDetailService;
import com.web.model.PrintApplicationModel;
import com.web.services.PrintApplicationRCService;

@Service("PrintApplicationRCService")
public class PrintApplicationRCServiceImpl implements PrintApplicationRCService {
	
	@Autowired
	UserDetailService userDetailService; 
	
	@Autowired
	PersonalDetailService personalDetailService;

	@Autowired
	AddressService addressService;
	
	@Autowired
	OccupationReservationService occupationReservationService;
	
	PrintApplicationModel printApplicationModel = null;
	
	@Override
	public PrintApplicationModel getPrintApplicationDetail(User user) {
		if(printApplicationModel == null)
			printApplicationModel = new PrintApplicationModel();
		
		getPersonalDetail(user);
		getAddress(user);
		getOccupation(user);
		
		return printApplicationModel;
	}
	
	private void getPersonalDetail(User user) {
		UserDetail userDetail = user.getUserDetail();
		PersonalDetail personalDetail = personalDetailService.getByUserDetail(user.getUserDetail());
		
		if(userDetail != null) {
			printApplicationModel.setBirthDate(userDetail.getDateOfBirth());
			printApplicationModel.setMobileNo(userDetail.getMobileNo());
			printApplicationModel.setEmail(userDetail.getEmail());			
		}
		
		if(personalDetail != null) {
			if(personalDetail.getLastName() != null) {
				printApplicationModel.setLastName(personalDetail.getLastName().toUpperCase());
			}
			if(personalDetail.getFirstName() != null) {
				printApplicationModel.setFirstName(personalDetail.getFirstName().toUpperCase());
			}
			if(personalDetail.getFirstName() != null) {
				printApplicationModel.setMiddleName(personalDetail.getMiddleName().toUpperCase());
			}
		}
		
		printApplicationModel.setFathersLastName(personalDetail.getFathersLastName());
		printApplicationModel.setFathersFirstName(personalDetail.getFathersFirstName());
		printApplicationModel.setFathersMiddleName(personalDetail.getFathersMiddleName());
		printApplicationModel.setMothersLastName(personalDetail.getMothersLastName());
		printApplicationModel.setMothersFirstName(personalDetail.getMothersFirstName());
		printApplicationModel.setMothersMiddleName(personalDetail.getMothersMiddleName());
		printApplicationModel.setPlaceOfBirth(personalDetail.getPlaceOfBirth());
		
		if(personalDetail.getGender() != null
				&& Enums.Gender.get(personalDetail.getGender()) != null) {
			printApplicationModel.setGender(Enums.Gender.get(personalDetail.getGender()).getValue());
		}
		
		if(personalDetail.getMaritalStatus() != null
				&& Enums.MaritalStatus.get(personalDetail.getMaritalStatus()) != null) {
			printApplicationModel.setMaritalStatus(Enums.MaritalStatus.get(personalDetail.getMaritalStatus()).getValue());
		}
		
		if(personalDetail.getBloodGroup() != null
				&& Enums.BloodGroup.get(personalDetail.getBloodGroup()) != null) {
			printApplicationModel.setBloodGroup(Enums.BloodGroup.get(personalDetail.getBloodGroup()).getValue());
		}
		
		printApplicationModel.setCountryOfCitizenship(personalDetail.getCountryOfCitizenship());

	}
	
	private void getAddress(User user) {
		Address address = addressService.getByUserDetail(user.getUserDetail());
		
		if(address != null) {
			printApplicationModel.setFlatNo(address.getFlatNo());
			printApplicationModel.setStreet(address.getStreet());
			printApplicationModel.setArea(address.getArea());
			printApplicationModel.setLandmark(address.getLandmark());
			printApplicationModel.setPinCode(address.getPinCode());
			printApplicationModel.setCity(address.getCity());
			printApplicationModel.setDistrict(address.getDistrict());
			printApplicationModel.setState(address.getState());
			printApplicationModel.setCountry(address.getCountry());
			if(address.getLocationArea() != null
					&& Enums.LocationArea.get(address.getLocationArea()) != null) {
				printApplicationModel.setLocationArea(Enums.LocationArea.get(address.getLocationArea()).getValue());
			}	
			printApplicationModel.setFlatNoPermanent(address.getFlatNoPermanent());
			printApplicationModel.setStreetPermanent(address.getStreetPermanent());
			printApplicationModel.setAreaPermanent(address.getAreaPermanent());
			printApplicationModel.setLandmarkPermanent(address.getLandmarkPermanent());
			printApplicationModel.setPinCodePermanent(address.getPinCodePermanent());
			printApplicationModel.setCityPermanent(address.getCityPermanent());
			printApplicationModel.setDistrictPermanent(address.getDistrictPermanent());
			printApplicationModel.setStatePermanent(address.getStatePermanent());
			printApplicationModel.setCountryPermanent(address.getCountryPermanent());
			if(address.getLocationAreaPermanent() != null
					&& Enums.LocationArea.get(address.getLocationAreaPermanent()) != null) {
				printApplicationModel.setLocationAreaPermanent(Enums.LocationArea.get(address.getLocationAreaPermanent()).getValue());
			}
		}
	}
	
	private void getOccupation(User user) {
		OccupationReservation occupationAndReservation = occupationReservationService.getByUserDetail(user.getUserDetail());
	
		if(occupationAndReservation != null) {			
			printApplicationModel.setCaste(occupationAndReservation.getCaste());
			if(occupationAndReservation.getCategory() != null
					&& Enums.Category.get(occupationAndReservation.getCategory()) != null) {
				printApplicationModel.setCategory(Enums.Category.get(occupationAndReservation.getCategory()).getValue());
			}
			if(occupationAndReservation.getReligion() != null
					&& Enums.Religion.get(occupationAndReservation.getReligion()) != null) {
				printApplicationModel.setReligion(Enums.Religion.get(occupationAndReservation.getReligion()).getValue());
			}
			if(occupationAndReservation.getMotherTongue() != null 
					&& Enums.MotherTongue.get(occupationAndReservation.getMotherTongue()) != null) {
				printApplicationModel.setMotherTongue(Enums.MotherTongue.get(occupationAndReservation.getMotherTongue()).getValue());
			}
			if(occupationAndReservation.getSpeciallyAbled() != null
					&& Enums.SpeciallyAbled.get(occupationAndReservation.getSpeciallyAbled()) != null) {
				printApplicationModel.setSpeciallyAbled(Enums.SpeciallyAbled.get(occupationAndReservation.getSpeciallyAbled()).getValue());
			}
		}
	
	}
}