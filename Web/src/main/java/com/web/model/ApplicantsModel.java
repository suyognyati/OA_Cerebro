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
}
