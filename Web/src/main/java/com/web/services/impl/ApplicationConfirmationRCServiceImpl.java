package com.web.services.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.data.entities.Address;
import com.data.entities.Application;
import com.data.entities.CollegeFeeMap;
import com.data.entities.CollegeProgramFeeMap;
import com.data.entities.CollegeProgramMap;
import com.data.entities.Enums;
import com.data.entities.OccupationReservation;
import com.data.entities.PersonalDetail;
import com.data.entities.StudentSelectedSubject;
import com.data.entities.User;
import com.data.entities.Student;
import com.data.entities.VendorTransaction;
import com.data.services.AddressService;
import com.data.services.ApplicationService;
import com.data.services.CollegeFeeMapDao;
import com.data.services.CollegeProgramFeeMapDao;
import com.data.services.CollegeProgramMapService;
import com.data.services.OccupationReservationService;
import com.data.services.PersonalDetailService;
import com.data.services.StudentSelectedSubjectsDao;
import com.data.services.StudentService;
import com.web.model.ApplicationFeeModel;
import com.web.model.ApplicationFeeModel.FeeDetail;
import com.web.model.PrintApplicationModel;
import com.web.services.ApplicationConfirmationRCService;
import com.web.services.VendorTransactionsRCService;
import com.web.staticandconstants.StaticMethods;

@Service("PrintApplicationRCService")
public class ApplicationConfirmationRCServiceImpl implements ApplicationConfirmationRCService {
	
	@Autowired
	StudentService studentService; 
	
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
	
	@Autowired
	ApplicationService applicationService;
	
	@Autowired
	VendorTransactionsRCService vendorTransactionsRCService; 
	
	@Autowired
	StudentSelectedSubjectsDao studentSelectedSubjectsDao; 
	
	PrintApplicationModel printApplicationModel = null;
	
	@Override
	public PrintApplicationModel getPrintApplicationDetail(Integer collegeProgramMapId, Integer applicationId, User user) {
		if(printApplicationModel == null)
			printApplicationModel = new PrintApplicationModel();
		
		CollegeProgramMap collegeProgramMap = collegeProgramMapService.getById(collegeProgramMapId);
		printApplicationModel.setCollegeProgramMap(collegeProgramMap);
		
		Application application = applicationService.getById(applicationId);
		
		List<StudentSelectedSubject> studentSelectedSubject = studentSelectedSubjectsDao.getSelectedSubjectOfApplication(application, collegeProgramMap, user.getStudent());
		printApplicationModel.setStudentSelectedSubjectList(studentSelectedSubject);
		
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
	
	@Override
	public Boolean submitApplication(User vendor, Integer collegeProgramMapId, Integer applicationId) {
		//CollegeProgramMap collegeProgramMap = collegeProgramMapService.getById(collegeProgramMapId);
		Application application = applicationService.getById(applicationId);
		
		VendorTransaction vendorTransaction = null;
		
		if(application.getApplicationStatus() == Enums.ApplicationStatus.Partial.getId())
			vendorTransaction = vendorTransactionsRCService.payApplicationFee(collegeProgramMapId, vendor.getVendor());
		
		if(vendorTransaction != null) {
			application.setApplicationStatus(Enums.ApplicationStatus.Submitted.getId());
			application.setVendorTransaction(vendorTransaction);
			applicationService.save(application);
			return true;
		}
		
		return false;
	}
	
	//Private functions for getPrintApplicationDetail
	private void getPersonalDetail(User user) {
		Student student = user.getStudent();
		PersonalDetail personalDetail = personalDetailService.getByStudent(user.getStudent());
		
		if(student != null) {
			printApplicationModel.setBirthDate(student.getDateOfBirth());
			printApplicationModel.setMobileNo(student.getMobileNo());
			printApplicationModel.setEmail(student.getEmail());			
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
		Address address = addressService.getByStudent(user.getStudent());
		
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
		OccupationReservation occupationAndReservation = occupationReservationService.getByStudent(user.getStudent());
	
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
		
		Float vendorAmount = 0f;
		Float totalAmount = 0f;
		
		if(collegeProgramFeeMapList != null) {
			for(CollegeProgramFeeMap collegeProgramFeeMap : collegeProgramFeeMapList) {
				FeeDetail feeDetail = applicationFeeModel.new FeeDetail();
				feeDetail.setProgramFeeId(collegeProgramFeeMap.getId());
				feeDetail.setDisplayTitle(collegeProgramFeeMap.getFeeType().getDisplayTitle());
				feeDetail.setFeeHead(collegeProgramFeeMap.getFeeType().getFeeHead());
				Float amount = collegeProgramFeeMap.getAmount();
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
				Float amount = collegeFeeMap.getAmount();
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