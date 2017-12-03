package com.web.model;

import com.data.entities.Country;
import com.data.entities.State;

public class ApplicantsModel {

//******************** NAME
	
	private String lastName;
	private String firstName;
	private String middleName;
	private String mothersName;
	private String firstNameRegional;
	private String lastNameRegional;
	private String middleNameRegional;
	private Boolean isNameChanged;
	private String newFirstName;
	private String newLastName;
	private String newMiddleName;
	private String nameChangeReason;
	
//******************** OTHER DETAIL
	
	private String birthDate;
	private String gender;
	private String bloodGroup;
	private String placeOfBirth;
	private String maritalStatus;
	private String adharNo;
	private Integer educationGapInYrs;

//******************** FAMILY DETAIL

	private String fathersLastName;
	private String fathersFirstName;
	private String fathersMiddleName;
	private String mothersLastName;
	private String mothersFirstName;
	private String mothersMiddleName;
	private String parentsEmailId;
	private String parentsContactNo;
	
//******************** NATIONALITY DETAIL
	
	private Country countryOfCitizenship; 
	private State domiciledIn;
	private String passportNo;
	private String passportIssuePlace;
	private String passportIssueDate;
	private String passportExpiryDate;
	private String passportIssuingAuthority;
	private Country passportIssuingCountry;
	private String visaType;
	private String visaValidUpto;
	private Integer visaSponsoringAgency;
	private String residentialPermitNo;
	
//******************** ADDRESS DETAIL
	
	private Boolean IsSameAsCorrespondence;
	private String flatNo;
	private String street;
	private String area;
	private String landmark;
	private String pinCode;
	private String city;
	private String district;
	private State state;
	private Country country;
	private String locationArea;
	private String flatNoPermanent;
	private String streetPermanent;
	private String areaPermanent;
	private String landmarkPermanent;
	private String pinCodePermanent;
	private String cityPermanent;
	private String districtPermanent;
	private State statePermanent;
	private Country countryPermanent;
	private String locationAreaPermanent;

//******************** OCCUPATION	

	private Boolean isSelfEmployed;
	private String experienceYrs;
	private String experienceMonths;
	private String occupation;
	private String selfAnnualIncome;
	private Boolean isLeaveWithoutPay;
	private String guardianAnnualIncome;
	private Boolean isEligibleForEBC;
	private String caste;
	private String category;
	private String religion;
	private String motherTongue;
	private String speciallyAbled;
	
	
		public String getLastName() {
			return lastName;
		}
		public void setLastName(String lastName) {
			this.lastName = lastName;
		}
		public String getFirstName() {
			return firstName;
		}
		public void setFirstName(String firstName) {
			this.firstName = firstName;
		}
		public String getMiddleName() {
			return middleName;
		}
		public void setMiddleName(String middleName) {
			this.middleName = middleName;
		}
		public String getMothersName() {
			return mothersName;
		}
		public void setMothersName(String mothersName) {
			this.mothersName = mothersName;
		}
		public String getFirstNameRegional() {
			return firstNameRegional;
		}
		public void setFirstNameRegional(String firstNameRegional) {
			this.firstNameRegional = firstNameRegional;
		}
		public String getLastNameRegional() {
			return lastNameRegional;
		}
		public void setLastNameRegional(String lastNameRegional) {
			this.lastNameRegional = lastNameRegional;
		}
		public String getMiddleNameRegional() {
			return middleNameRegional;
		}
		public void setMiddleNameRegional(String middleNameRegional) {
			this.middleNameRegional = middleNameRegional;
		}
		public Boolean getIsNameChanged() {
			return isNameChanged;
		}
		public void setIsNameChanged(Boolean isNameChanged) {
			this.isNameChanged = isNameChanged;
		}
		public String getNewFirstName() {
			return newFirstName;
		}
		public void setNewFirstName(String newFirstName) {
			this.newFirstName = newFirstName;
		}
		public String getNewLastName() {
			return newLastName;
		}
		public void setNewLastName(String newLastName) {
			this.newLastName = newLastName;
		}
		public String getNewMiddleName() {
			return newMiddleName;
		}
		public void setNewMiddleName(String newMiddleName) {
			this.newMiddleName = newMiddleName;
		}
		public String getNameChangeReason() {
			return nameChangeReason;
		}
		public void setNameChangeReason(String nameChangeReason) {
			this.nameChangeReason = nameChangeReason;
		}
		public String getBirthDate() {
			return birthDate;
		}
		public void setBirthDate(String birthDate) {
			this.birthDate = birthDate;
		}
		public String getGender() {
			return gender;
		}
		public void setGender(String gender) {
			this.gender = gender;
		}
		public String getBloodGroup() {
			return bloodGroup;
		}
		public void setBloodGroup(String bloodGroup) {
			this.bloodGroup = bloodGroup;
		}
		public String getPlaceOfBirth() {
			return placeOfBirth;
		}
		public void setPlaceOfBirth(String placeOfBirth) {
			this.placeOfBirth = placeOfBirth;
		}
		public String getMaritalStatus() {
			return maritalStatus;
		}
		public void setMaritalStatus(String maritalStatus) {
			this.maritalStatus = maritalStatus;
		}
		public String getAdharNo() {
			return adharNo;
		}
		public void setAdharNo(String adharNo) {
			this.adharNo = adharNo;
		}
		public Integer getEducationGapInYrs() {
			return educationGapInYrs;
		}
		public void setEducationGapInYrs(Integer educationGapInYrs) {
			this.educationGapInYrs = educationGapInYrs;
		}
		public String getFathersLastName() {
			return fathersLastName;
		}
		public void setFathersLastName(String fathersLastName) {
			this.fathersLastName = fathersLastName;
		}
		public String getFathersFirstName() {
			return fathersFirstName;
		}
		public void setFathersFirstName(String fathersFirstName) {
			this.fathersFirstName = fathersFirstName;
		}
		public String getFathersMiddleName() {
			return fathersMiddleName;
		}
		public void setFathersMiddleName(String fathersMiddleName) {
			this.fathersMiddleName = fathersMiddleName;
		}
		public String getMothersLastName() {
			return mothersLastName;
		}
		public void setMothersLastName(String mothersLastName) {
			this.mothersLastName = mothersLastName;
		}
		public String getMothersFirstName() {
			return mothersFirstName;
		}
		public void setMothersFirstName(String mothersFirstName) {
			this.mothersFirstName = mothersFirstName;
		}
		public String getMothersMiddleName() {
			return mothersMiddleName;
		}
		public void setMothersMiddleName(String mothersMiddleName) {
			this.mothersMiddleName = mothersMiddleName;
		}
		public String getParentsEmailId() {
			return parentsEmailId;
		}
		public void setParentsEmailId(String parentsEmailId) {
			this.parentsEmailId = parentsEmailId;
		}
		public String getParentsContactNo() {
			return parentsContactNo;
		}
		public void setParentsContactNo(String parentsContactNo) {
			this.parentsContactNo = parentsContactNo;
		}
		public Country getCountryOfCitizenship() {
			return countryOfCitizenship;
		}
		public void setCountryOfCitizenship(Country countryOfCitizenship) {
			this.countryOfCitizenship = countryOfCitizenship;
		}
		public State getDomiciledIn() {
			return domiciledIn;
		}
		public void setDomiciledIn(State domiciledIn) {
			this.domiciledIn = domiciledIn;
		}
		public String getPassportNo() {
			return passportNo;
		}
		public void setPassportNo(String passportNo) {
			this.passportNo = passportNo;
		}
		public String getPassportIssuePlace() {
			return passportIssuePlace;
		}
		public void setPassportIssuePlace(String passportIssuePlace) {
			this.passportIssuePlace = passportIssuePlace;
		}
		public String getPassportIssueDate() {
			return passportIssueDate;
		}
		public void setPassportIssueDate(String passportIssueDate) {
			this.passportIssueDate = passportIssueDate;
		}
		public String getPassportExpiryDate() {
			return passportExpiryDate;
		}
		public void setPassportExpiryDate(String passportExpiryDate) {
			this.passportExpiryDate = passportExpiryDate;
		}
		public String getPassportIssuingAuthority() {
			return passportIssuingAuthority;
		}
		public void setPassportIssuingAuthority(String passportIssuingAuthority) {
			this.passportIssuingAuthority = passportIssuingAuthority;
		}
		public Country getPassportIssuingCountry() {
			return passportIssuingCountry;
		}
		public void setPassportIssuingCountry(Country passportIssuingCountry) {
			this.passportIssuingCountry = passportIssuingCountry;
		}
		public String getVisaType() {
			return visaType;
		}
		public void setVisaType(String visaType) {
			this.visaType = visaType;
		}
		public String getVisaValidUpto() {
			return visaValidUpto;
		}
		public void setVisaValidUpto(String visaValidUpto) {
			this.visaValidUpto = visaValidUpto;
		}
		public Integer getVisaSponsoringAgency() {
			return visaSponsoringAgency;
		}
		public void setVisaSponsoringAgency(Integer visaSponsoringAgency) {
			this.visaSponsoringAgency = visaSponsoringAgency;
		}
		public String getResidentialPermitNo() {
			return residentialPermitNo;
		}
		public void setResidentialPermitNo(String residentialPermitNo) {
			this.residentialPermitNo = residentialPermitNo;
		}
		public Boolean getIsSameAsCorrespondence() {
			return IsSameAsCorrespondence;
		}
		public void setIsSameAsCorrespondence(Boolean isSameAsCorrespondence) {
			IsSameAsCorrespondence = isSameAsCorrespondence;
		}
		public String getFlatNo() {
			return flatNo;
		}
		public void setFlatNo(String flatNo) {
			this.flatNo = flatNo;
		}
		public String getStreet() {
			return street;
		}
		public void setStreet(String street) {
			this.street = street;
		}
		public String getArea() {
			return area;
		}
		public void setArea(String area) {
			this.area = area;
		}
		public String getLandmark() {
			return landmark;
		}
		public void setLandmark(String landmark) {
			this.landmark = landmark;
		}
		public String getPinCode() {
			return pinCode;
		}
		public void setPinCode(String pinCode) {
			this.pinCode = pinCode;
		}
		public String getCity() {
			return city;
		}
		public void setCity(String city) {
			this.city = city;
		}
		public String getDistrict() {
			return district;
		}
		public void setDistrict(String district) {
			this.district = district;
		}
		public State getState() {
			return state;
		}
		public void setState(State state) {
			this.state = state;
		}
		public Country getCountry() {
			return country;
		}
		public void setCountry(Country country) {
			this.country = country;
		}
		public String getLocationArea() {
			return locationArea;
		}
		public void setLocationArea(String locationArea) {
			this.locationArea = locationArea;
		}
		public String getFlatNoPermanent() {
			return flatNoPermanent;
		}
		public void setFlatNoPermanent(String flatNoPermanent) {
			this.flatNoPermanent = flatNoPermanent;
		}
		public String getStreetPermanent() {
			return streetPermanent;
		}
		public void setStreetPermanent(String streetPermanent) {
			this.streetPermanent = streetPermanent;
		}
		public String getAreaPermanent() {
			return areaPermanent;
		}
		public void setAreaPermanent(String areaPermanent) {
			this.areaPermanent = areaPermanent;
		}
		public String getLandmarkPermanent() {
			return landmarkPermanent;
		}
		public void setLandmarkPermanent(String landmarkPermanent) {
			this.landmarkPermanent = landmarkPermanent;
		}
		public String getPinCodePermanent() {
			return pinCodePermanent;
		}
		public void setPinCodePermanent(String pinCodePermanent) {
			this.pinCodePermanent = pinCodePermanent;
		}
		public String getCityPermanent() {
			return cityPermanent;
		}
		public void setCityPermanent(String cityPermanent) {
			this.cityPermanent = cityPermanent;
		}
		public String getDistrictPermanent() {
			return districtPermanent;
		}
		public void setDistrictPermanent(String districtPermanent) {
			this.districtPermanent = districtPermanent;
		}
		public State getStatePermanent() {
			return statePermanent;
		}
		public void setStatePermanent(State statePermanent) {
			this.statePermanent = statePermanent;
		}
		public Country getCountryPermanent() {
			return countryPermanent;
		}
		public void setCountryPermanent(Country countryPermanent) {
			this.countryPermanent = countryPermanent;
		}
		public String getLocationAreaPermanent() {
			return locationAreaPermanent;
		}
		public void setLocationAreaPermanent(String locationAreaPermanent) {
			this.locationAreaPermanent = locationAreaPermanent;
		}
		public Boolean getIsSelfEmployed() {
			return isSelfEmployed;
		}
		public void setIsSelfEmployed(Boolean isSelfEmployed) {
			this.isSelfEmployed = isSelfEmployed;
		}
		public String getExperienceYrs() {
			return experienceYrs;
		}
		public void setExperienceYrs(String experienceYrs) {
			this.experienceYrs = experienceYrs;
		}
		public String getExperienceMonths() {
			return experienceMonths;
		}
		public void setExperienceMonths(String experienceMonths) {
			this.experienceMonths = experienceMonths;
		}
		public String getOccupation() {
			return occupation;
		}
		public void setOccupation(String occupation) {
			this.occupation = occupation;
		}
		public String getSelfAnnualIncome() {
			return selfAnnualIncome;
		}
		public void setSelfAnnualIncome(String selfAnnualIncome) {
			this.selfAnnualIncome = selfAnnualIncome;
		}
		public Boolean getIsLeaveWithoutPay() {
			return isLeaveWithoutPay;
		}
		public void setIsLeaveWithoutPay(Boolean isLeaveWithoutPay) {
			this.isLeaveWithoutPay = isLeaveWithoutPay;
		}
		public String getGuardianAnnualIncome() {
			return guardianAnnualIncome;
		}
		public void setGuardianAnnualIncome(String guardianAnnualIncome) {
			this.guardianAnnualIncome = guardianAnnualIncome;
		}
		public Boolean getIsEligibleForEBC() {
			return isEligibleForEBC;
		}
		public void setIsEligibleForEBC(Boolean isEligibleForEBC) {
			this.isEligibleForEBC = isEligibleForEBC;
		}
		public String getCaste() {
			return caste;
		}
		public void setCaste(String caste) {
			this.caste = caste;
		}
		public String getCategory() {
			return category;
		}
		public void setCategory(String category) {
			this.category = category;
		}
		public String getReligion() {
			return religion;
		}
		public void setReligion(String religion) {
			this.religion = religion;
		}
		public String getMotherTongue() {
			return motherTongue;
		}
		public void setMotherTongue(String motherTongue) {
			this.motherTongue = motherTongue;
		}
		public String getSpeciallyAbled() {
			return speciallyAbled;
		}
		public void setSpeciallyAbled(String speciallyAbled) {
			this.speciallyAbled = speciallyAbled;
		}
}
