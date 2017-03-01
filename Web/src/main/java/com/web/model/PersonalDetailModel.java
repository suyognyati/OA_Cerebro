package com.web.model;

import java.util.List;

import com.data.entities.Country;
import com.data.entities.Enums;
import com.data.entities.State;

public class PersonalDetailModel {
	
//******************** REGION NAME	
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
	private Integer nameChangeReason;
	private List<Enums.KeyValuePair> nameChangeReasonList;
	
		// LastName getter setter
		public String getLastName() {
			return lastName;
		}
		public void setLastName(String lastName) {
			this.lastName = lastName;
		}
		
		// FirstName getter setter
		public String getFirstName() {
			return firstName;
		}
		public void setFirstName(String firstName) {
			this.firstName = firstName;
		}
		
		// MiddleName getter setter
		public String getMiddleName() {
			return middleName;
		}
		public void setMiddleName(String middleName) {
			this.middleName = middleName;
		}
		
		// MotherName getter setter
		public String getMothersName() {
			return mothersName;
		}
		public void setMothersName(String mothersName) {
			this.mothersName = mothersName;
		}
	
		// FirstNameRegional getter setter
		public String getFirstNameRegional() {
			return firstNameRegional;
		}
		public void setFirstNameRegional(String firstNameRegional) {
			this.firstNameRegional = firstNameRegional;
		}
		
		// LastNameRegional getter setter
		public String getLastNameRegional() {
			return lastNameRegional;
		}
		public void setLastNameRegional(String lastNameRegional) {
			this.lastNameRegional = lastNameRegional;
		}
		
		// MiddleNameRegional getter setter
		public String getMiddleNameRegional() {
			return middleNameRegional;
		}
		public void setMiddleNameRegional(String middleNameRegional) {
			this.middleNameRegional = middleNameRegional;
		}
		
		// IsNameChanged getter setter
		public Boolean getIsNameChanged() {
			return isNameChanged;
		}
		public void setIsNameChanged(Boolean isNameChanged) {
			this.isNameChanged = isNameChanged;
		}

		// NewFirstName getter setter
		public String getNewFirstName() {
			return newFirstName;
		}
		public void setNewFirstName(String newFirstName) {
			this.newFirstName = newFirstName;
		}

		// NewLastName getter setter
		public String getNewLastName() {
			return newLastName;
		}
		public void setNewLastName(String newLastName) {
			this.newLastName = newLastName;
		}
		
		// NewMiddleName getter setter
		public String getNewMiddleName() {
			return newMiddleName;
		}
		public void setNewMiddleName(String newMiddleName) {
			this.newMiddleName = newMiddleName;
		}

		// NameChangeReason getter setter

		public Integer getNameChangeReason() {
			return nameChangeReason;
		}
		public void setNameChangeReason(Integer nameChangeReason) {
			this.nameChangeReason = nameChangeReason;
		}

		//Marital Status List getter setter
		public List<Enums.KeyValuePair> getNameChangeReasonList() {
			return nameChangeReasonList;
		}
		public void setNameChangeReasonList(List<Enums.KeyValuePair> nameChangeReasonList) {
			this.nameChangeReasonList = nameChangeReasonList;
		}

//END REGION ********************
		
//******************** REGION OTHER DETAIL
		
	private String birthDate;
	private Integer gender;
	private Integer bloodGroup;
	private String placeOfBirth;
	private Integer maritalStatus;
	private String adharNo;
	private List<Enums.KeyValuePair> bloodGroupList;
	private List<Enums.KeyValuePair> maritalStatusList;
	
		// BirthDate getter setter
		public String getBirthDate() {
			return birthDate;
		}
		public void setBirthDate(String birthDate) {
			this.birthDate = birthDate;
		}
		
		//Gender getter setter
		public Integer getGender() {
			return this.gender;
		}
		public void setGender(Integer genderval) {
			this.gender = genderval;
		}
		
		//Blood Group getter setter
		public Integer getBloodGroup() {
			return bloodGroup;
		}
		public void setBloodGroup(Integer bloodGroup) {
			this.bloodGroup = bloodGroup;
		}
		
		//Place of Birth getter setter
		public String getPlaceOfBirth() {
			return placeOfBirth;
		}
		public void setPlaceOfBirth(String placeOfBirth) {
			this.placeOfBirth = placeOfBirth;
		}
		
		//Marrital Status getter setter
		public Integer getMaritalStatus() {
			return maritalStatus;
		}
		public void setMaritalStatus(Integer maritalStatus) {
			this.maritalStatus = maritalStatus;
		}
	
		//Adhar No getter setter
		public String getAdharNo() {
			return adharNo;
		}
		public void setAdharNo(String adharNo) {
			this.adharNo = adharNo;
		}
		
		//Blood Group List getter setter
		public List<Enums.KeyValuePair> getBloodGroupList() {
			return bloodGroupList;
		}
		public void setBloodGroupList(List<Enums.KeyValuePair> bloodGroupList) {
			this.bloodGroupList = bloodGroupList;
		}
		
		//Marital Status List getter setter
		public List<Enums.KeyValuePair> getMaritalStatusList() {
			return maritalStatusList;
		}
		public void setMaritalStatusList(List<Enums.KeyValuePair> maritalStatusList) {
			this.maritalStatusList = maritalStatusList;
		}
		
//END REGION ********************	

//******************** REGION FAMILY DETAIL

	private String fathersLastName;
	private String fathersFirstName;
	private String fathersMiddleName;
	private String mothersLastName;
	private String mothersFirstName;
	private String mothersMiddleName;
	private String parentsEmailId;
	private String parentsContactNo;
	
	
		//FathersLastName
		public String getFathersLastName() {
			return fathersLastName;
		}
		public void setFathersLastName(String fathersLastName) {
			this.fathersLastName = fathersLastName;
		}
		
		//FathersFirstName
		public String getFathersFirstName() {
			return fathersFirstName;
		}
		public void setFathersFirstName(String fathersFirstName) {
			this.fathersFirstName = fathersFirstName;
		}
		
		//FathersMiddleNAme
		public String getFathersMiddleName() {
			return fathersMiddleName;
		}
		public void setFathersMiddleName(String fathersMiddleName) {
			this.fathersMiddleName = fathersMiddleName;
		}
		
		//MothersLastName
		public String getMothersLastName() {
			return mothersLastName;
		}
		public void setMothersLastName(String mothersLastName) {
			this.mothersLastName = mothersLastName;
		}
		
		//MothersFirstName
		public String getMothersFirstName() {
			return mothersFirstName;
		}
		public void setMothersFirstName(String mothersFirstName) {
			this.mothersFirstName = mothersFirstName;
		}
		
		//M<othersMiddleName
		public String getMothersMiddleName() {
			return mothersMiddleName;
		}
		public void setMothersMiddleName(String mothersMiddleName) {
			this.mothersMiddleName = mothersMiddleName;
		}
		
		//ParentsEmailId
		public String getParentsEmailId() {
			return parentsEmailId;
		}
		public void setParentsEmailId(String parentsEmailId) {
			this.parentsEmailId = parentsEmailId;
		}
		
		//ParentsContactNo
		public String getParentsContactNo() {
			return parentsContactNo;
		}
		public void setParentsContactNo(String parentsContactNo) {
			this.parentsContactNo = parentsContactNo;
		}
			
//END REGION ********************	

//******************** REGION NATIONALITY DETAIL
	
	private Country countryOfCitizenship; 
	private State domiciledIn;
	private String passportNo;
	private String passportIssuePlace;
	private String passportIssueDate;
	private String passportExpiryDate;
	private Integer passportIssuingAuthority;
	private Country passportIssuingCountry;
	private Integer visaType;
	private String visaValidUpto;
	private Integer visaSponsoringAgency;
	private String residentialPermitNo;
	private List<Enums.KeyValuePair> passportIssuingAuthorityList;
	private List<Enums.KeyValuePair> visaTypeList;
	private List<Enums.KeyValuePair> visaSponsoringAgencyList;
	private List<Country> countryList;
	private List<State> stateList;

		//Citizenship country getter setter
		public Country getCountryOfCitizenship() {
			return countryOfCitizenship;
		}
		public void setCountryOfCitizenship(Country countryOfCitizenship) {
			this.countryOfCitizenship = countryOfCitizenship;
		}
		
		//Domiciled In getter setter
		public State getDomiciledIn() {
			return domiciledIn;
		}
		public void setDomiciledIn(State domiciledIn) {
			this.domiciledIn = domiciledIn;
		}
		
		//Passport no getter setter
		public String getPassportNo() {
			return passportNo;
		}
		public void setPassportNo(String passportNo) {
			this.passportNo = passportNo;
		}
		
		//Passport issue place getter setter
		public String getPassportIssuePlace() {
			return passportIssuePlace;
		}
		public void setPassportIssuePlace(String passportIssuePlace) {
			this.passportIssuePlace = passportIssuePlace;
		}
		
		//Passport issue date getter setter
		public String getPassportIssueDate() {
			return passportIssueDate;
		}
		public void setPassportIssueDate(String passportIssueDate) {
			this.passportIssueDate = passportIssueDate;
		}
		
		//Passport expiry date getter setter
		public String getPassportExpiryDate() {
			return passportExpiryDate;
		}
		public void setPassportExpiryDate(String passportExpiryDate) {
			this.passportExpiryDate = passportExpiryDate;
		}
		
		//Passport issuing authority getter setter
		public Integer getPassportIssuingAuthority() {
			return passportIssuingAuthority;
		}
		public void setPassportIssuingAuthority(Integer passportIssuingAuthority) {
			this.passportIssuingAuthority = passportIssuingAuthority;
		}
		
		//Passport issuing country getter setter
		public Country getPassportIssuingCountry() {
			return passportIssuingCountry;
		}
		public void setPassportIssuingCountry(Country passportIssuingCountry) {
			this.passportIssuingCountry = passportIssuingCountry;
		}
		
		//Visa type getter setter
		public Integer getVisaType() {
			return visaType;
		}
		public void setVisaType(Integer visaType) {
			this.visaType = visaType;
		}
		
		//Visa valid upto getter setter
		public String getVisaValidUpto() {
			return visaValidUpto;
		}
		public void setVisaValidUpto(String visaValidUpto) {
			this.visaValidUpto = visaValidUpto;
		}
		
		//Visa sponsoring agency getter setter
		public Integer getVisaSponsoringAgency() {
			return visaSponsoringAgency;
		}
		public void setVisaSponsoringAgency(Integer visaSponsoringAgency) {
			this.visaSponsoringAgency = visaSponsoringAgency;
		}
		
		//Residential permit no getter setter
		public String getResidentialPermitNo() {
			return residentialPermitNo;
		}
		public void setResidentialPermitNo(String residentialPermitNo) {
			this.residentialPermitNo = residentialPermitNo;
		}
		
		//List of passport issuing authority getter setter
		public List<Enums.KeyValuePair> getPassportIssuingAuthorityList() {
			return passportIssuingAuthorityList;
		}
		public void setPassportIssuingAuthorityList(List<Enums.KeyValuePair> passportIssuingAuthorityList) {
			this.passportIssuingAuthorityList = passportIssuingAuthorityList;
		}
		
		//List of visa type getter setter
		public List<Enums.KeyValuePair> getVisaTypeList() {
			return visaTypeList;
		}
		public void setVisaTypeList(List<Enums.KeyValuePair> visaTypeList) {
			this.visaTypeList = visaTypeList;
		}
		
		//List of visa sponsoring agency getter setter
		public List<Enums.KeyValuePair> getVisaSponsoringAgencyList() {
			return visaSponsoringAgencyList;
		}
		public void setVisaSponsoringAgencyList(List<Enums.KeyValuePair> visaSponsoringAgencyList) {
			this.visaSponsoringAgencyList = visaSponsoringAgencyList;
		}
		
		//List of country getter setter
		public List<Country> getCountryList() {
			return countryList;
		}
		public void setCountryList(List<Country> countryList) {
			this.countryList = countryList;
		}
		
		//List of state getter setter
		public List<State> getStateList() {
			return stateList;
		}
		public void setStateList(List<State> stateList) {
			this.stateList = stateList;
		}

//END REGION ********************

}
