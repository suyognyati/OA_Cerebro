package com.web.services.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.data.entities.Address;
import com.data.entities.CollegeFeeMap;
import com.data.entities.CollegeProgramFeeMap;
import com.data.entities.CollegeProgramMap;
import com.data.entities.Enums;
import com.data.entities.OccupationReservation;
import com.data.entities.PersonalDetail;
import com.data.entities.User;
import com.data.entities.UserDetail;
import com.data.services.AddressService;
import com.data.services.CollegeFeeMapDao;
import com.data.services.CollegeProgramFeeMapDao;
import com.data.services.CollegeProgramMapService;
import com.data.services.OccupationReservationService;
import com.data.services.PersonalDetailService;
import com.data.services.UserDetailService;
import com.web.model.ApplicationFeeModel;
import com.web.model.ApplicationFeeModel.FeeDetail;
import com.web.model.PrintApplicationModel;
import com.web.services.ApplicationConfirmationRCService;
import com.web.staticandconstants.StaticMethods;

@Service("PrintApplicationRCService")
public class ApplicationConfirmationRCServiceImpl implements ApplicationConfirmationRCService {
	
	@Autowired
	UserDetailService userDetailService; 
	
	@Autowired
	PersonalDetailService personalDetailService;

	@Autowired
	AddressService addressService;
	
	@Autowired
	OccupationReservationService occupationReservationService;
	
	@Autowired
	CollegeProgramMapService collegeProgramMapService;
	
	@Autowired
	CollegeProgramFeeMapDao collegeProgramFeeMapDao;
	
	@Autowired
	CollegeFeeMapDao collegeFeeMapDao;
	
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
	
	@Override
	public ApplicationFeeModel getFeeStructure(Integer collegeProgramMapId) {
		CollegeProgramMap collegeProgramMap = collegeProgramMapService.getById(collegeProgramMapId);
		ApplicationFeeModel applicationFeeModel = null;
		Integer year = StaticMethods.GetCourseStartYear();
		//Getting fee details of particular program 
		List<CollegeProgramFeeMap> collegeProgramFeeMapList = collegeProgramFeeMapDao.getByCollegeProgramAndYear(collegeProgramMap.getCollege(), collegeProgramMap.getProgram(), year);
		//If fee details for particular program not available then getting it for entire college
		if(collegeProgramFeeMapList != null && collegeProgramFeeMapList.size() > 0) {
			applicationFeeModel = setApplicationFeeModel(collegeProgramFeeMapList, null);
		} else {
			List<CollegeFeeMap> collegeFeeMapList = collegeFeeMapDao.getByCollegeAndYear(collegeProgramMap.getCollege(), year);
			applicationFeeModel = setApplicationFeeModel(null, collegeFeeMapList);			
		}
		
		applicationFeeModel.setCollege(collegeProgramMap.getCollege());
		applicationFeeModel.setProgram(collegeProgramMap.getProgram());
		return applicationFeeModel;
	}
	
	//Private functions for getPrintApplicationDetail
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
			if(occupationAndReservation.getOccupation() != null
					&& Enums.Occupation.get(occupationAndReservation.getOccupation()) != null) {
				printApplicationModel.setOccupation(Enums.Occupation.get(occupationAndReservation.getOccupation()).getValue());
			}
			printApplicationModel.setGuardianAnnualIncome(occupationAndReservation.getGuardianAnnualIncome());
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
	
	//Private function for getFeeStructure
	private ApplicationFeeModel setApplicationFeeModel(List<CollegeProgramFeeMap> collegeProgramFeeMapList, List<CollegeFeeMap> collegeFeeMapList) {
		ApplicationFeeModel applicationFeeModel = new ApplicationFeeModel();
		List<FeeDetail> feeDetailList = new ArrayList<FeeDetail>();
		
		Integer vendorAmount = 0;
		Integer totalAmount = 0;
		
		if(collegeProgramFeeMapList != null) {
			for(CollegeProgramFeeMap collegeProgramFeeMap : collegeProgramFeeMapList) {
				FeeDetail feeDetail = applicationFeeModel.new FeeDetail();
				feeDetail.setProgramFeeId(collegeProgramFeeMap.getId());
				feeDetail.setDisplayTitle(collegeProgramFeeMap.getFeeType().getDisplayTitle());
				feeDetail.setFeeHead(collegeProgramFeeMap.getFeeType().getFeeHead());
				Integer amount = collegeProgramFeeMap.getAmount();
				feeDetail.setAmount(amount);
				Boolean displayPurpose = collegeProgramFeeMap.getOnlyForDisplayPurpose();
				feeDetail.setOnlyForDisplayPurpose(displayPurpose);
				feeDetailList.add(feeDetail);
				if(!displayPurpose)
					vendorAmount += amount;
				totalAmount += amount;
			}
		} else {
			for(CollegeFeeMap collegeFeeMap : collegeFeeMapList) {
				FeeDetail feeDetail = applicationFeeModel.new FeeDetail();
				feeDetail.setFeeId(collegeFeeMap.getId());
				feeDetail.setDisplayTitle(collegeFeeMap.getFeeType().getDisplayTitle());
				feeDetail.setFeeHead(collegeFeeMap.getFeeType().getFeeHead());
				Integer amount = collegeFeeMap.getAmount();
				feeDetail.setAmount(amount);
				Boolean displayPurpose = collegeFeeMap.getOnlyForDisplayPurpose();
				feeDetail.setOnlyForDisplayPurpose(displayPurpose);
				feeDetailList.add(feeDetail);
				if(!displayPurpose)
					vendorAmount += amount;
				totalAmount += amount;
			}
		}
		
		applicationFeeModel.setVendorAmount(vendorAmount);
		applicationFeeModel.setTotalAmount(totalAmount);		
		applicationFeeModel.setFeeDetailList(feeDetailList);
		
		return applicationFeeModel; 
	}
}