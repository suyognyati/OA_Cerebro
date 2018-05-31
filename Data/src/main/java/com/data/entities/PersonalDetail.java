package com.data.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * The persistent class for the PersonalDetails database table.
 *
 */

@Entity
@Table(name="PersonalDetails")
public class PersonalDetail {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="PersonalDetailId")
	private Integer personalDetailId;
	
		//PersonalDetailId
		public Integer getPersonalDetailId() {
			return personalDetailId;
		}
		public void setPersonalDetailId(final Integer personalDetailId) {
			this.personalDetailId = personalDetailId;
		}
		
	
//******************** REGION NAME
	
	@Column(name="FirstName")
	private String firstName;
	
	@Column(name="LastName")
	private String lastName;
	
	@Column(name="RelationType")
	private Integer relationType;
	
	@Column(name="MiddleName")
	private String middleName;
	
	@Column(name="MotherName")
	private String motherName;
	
	@Column(name="FirstNameRegional")
	private String firstNameRegional;
	
	@Column(name="LastNameRegional")
	private String lastNameRegional;
	
	@Column(name="MiddleNameRegional")
	private String middleNameRegional;
	
	@Column(name="IsNameChanged")
	private Boolean isNameChanged;
	
	@Column(name="NewFirstName")
	private String newFirstName;
	
	@Column(name="NewLastName")
	private String newLastName;
	
	@Column(name="NewMiddleName")
	private String newMiddleName;
	
	@Column(name="NameChangeReason")
	private Integer nameChangeReason;
	
		//FirstName
		public String getFirstName() {
			return firstName;
		}
		public void setFirstName(String firstName) {
			this.firstName = firstName;
		}
		
		//LastName
		public String getLastName() {
			return lastName;
		}
		public void setLastName(String lastName) {
			this.lastName = lastName;
		}
		
		//RelationType
		public Integer getRelationType() {
			return relationType;
		}
		public void setRelationType(Integer relationType) {
			this.relationType = relationType;
		}
		
		//MidleName
		public String getMiddleName() {
			return middleName;
		}
		public void setMiddleName(String midleName) {
			this.middleName = midleName;
		}
		
		//MotherName
		public String getMotherName() {
			return motherName;
		}
		public void setMotherName(String motherName) {
			this.motherName = motherName;
		}
			
		//FirstNameRegional
		public String getFirstNameRegional() {
			return firstNameRegional;
		}
		public void setFirstNameRegional(String firstNameRegional) {
			this.firstNameRegional = firstNameRegional;
		}
		
		//LastNameRegional
		public String getLastNameRegional() {
			return lastNameRegional;
		}
		public void setLastNameRegional(String lastNameRegional) {
			this.lastNameRegional = lastNameRegional;
		}
		
		//MiddleNameRegional
		public String getMiddleNameRegional() {
			return middleNameRegional;
		}
		public void setMiddleNameRegional(String middleNameRegional) {
			this.middleNameRegional = middleNameRegional;
		}
		
		//IsNameChanged
		public Boolean getIsNameChanged() {
			return isNameChanged;
		}
		public void setIsNameChanged(Boolean isNameChanged) {
			this.isNameChanged = isNameChanged;
		}
		
		//NewFirstName
		public String getNewFirstName() {
			return newFirstName;
		}
		public void setNewFirstName(String newFirstName) {
			this.newFirstName = newFirstName;
		}
		
		//NewLastName
		public String getNewLastName() {
			return newLastName;
		}
		public void setNewLastName(String newLastName) {
			this.newLastName = newLastName;
		}
		
		//NewMiddleName
		public String getNewMiddleName() {
			return newMiddleName;
		}
		public void setNewMiddleName(String newMiddleName) {
			this.newMiddleName = newMiddleName;
		}
		
		//NameChangeReason
		public Integer getNameChangeReason() {
			return nameChangeReason;
		}
		public void setNameChangeReason(Integer nameChangeReason) {
			this.nameChangeReason = nameChangeReason;
		}
	
//ENDREGION ********************

//******************** REGION SELFDETAIL
	
	@Column(name="AdharNo")
	private String adharNo;
	
	@Column(name="Gender")
	private Integer gender;

	@Column(name="PlaceOfBirth")
	private String placeOfBirth;

	@Column(name="MaritalStatus")
	private Integer maritalStatus;

	@Column(name="BloodGroup")
	private Integer bloodGroup;
	
	@Column(name="EducationGapInYrs")
	private Integer educationGapInYrs;
	
		//AdharNo
		public String getAdharNo() {
			return adharNo;
		}
		public void setAdharNo(String adharNo) {
			this.adharNo = adharNo;
		}
		
		//Gender
		public Integer getGender() {
			return gender;
		}
		public void setGender(final Integer gender) {
			this.gender = gender;
		}
		
		//PlaceOfBirth
		public String getPlaceOfBirth() {
			return placeOfBirth;
		}
		public void setPlaceOfBirth(String placeOfBirth) {
			this.placeOfBirth = placeOfBirth;
		}
		
		//MaritalStatus
		public Integer getMaritalStatus() {
			return maritalStatus;
		}
		public void setMaritalStatus(Integer maritalStatus) {
			this.maritalStatus = maritalStatus;
		}
		
		//BloodGroup
		public Integer getBloodGroup() {
			return bloodGroup;
		}
		public void setBloodGroup(final Integer bloodGroup) {
			this.bloodGroup = bloodGroup;
		}
		
		//EducationGapInYrs
		public Integer getEducationGapInYrs() {
			return educationGapInYrs;
		}
		public void setEducationGapInYrs(Integer educationGapInYrs) {
			this.educationGapInYrs = educationGapInYrs;
		}

//ENDREGION ********************

//******************** REGION FAMILY DETAIL
		
	@Column(name="FathersLastName")
	private String fathersLastName;
	
	@Column(name="FathersFirstName")
	private String fathersFirstName;
	
	@Column(name="FathersMiddleName")
	private String fathersMiddleName;
	
	@Column(name="MothersLastName")
	private String mothersLastName;
	
	@Column(name="MothersFirstName")
	private String mothersFirstName;
	
	@Column(name="MothersMiddleName")
	private String mothersMiddleName;
	
	@Column(name="ParentsEmailId")
	private String parentsEmailId;
	
	@Column(name="ParentsContactNo")
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
		
		//FatherdsMiddleName
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
		
		//MotherdsFirstName
		public String getMothersFirstName() {
			return mothersFirstName;
		}
		public void setMothersFirstName(String mothersFirstName) {
			this.mothersFirstName = mothersFirstName;
		}
		
		//MothersMiddleName
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
		
//ENDREGION ********************		

//******************** REGION NATIONALITY DETAIL
	
		@ManyToOne
		@JoinColumn(name="FK_CountryOfCitizenship")
		private Country countryOfCitizenship; 
		
		@ManyToOne
		@JoinColumn(name="FK_DomiciledIn")
		private State domiciledIn;

		@Column(name="PassportNo")
		private String passportNo;

		@Column(name="PassportIssuePlace")
		private String passportIssuePlace;

		@Column(name="PassportIssueDate")
		private String passportIssueDate;

		@Column(name="PassportExpiryDate")
		private String passportExpiryDate;

		@Column(name="PassportIssuingAuthority")
		private Integer passportIssuingAuthority;

		@ManyToOne
		@JoinColumn(name="FK_PassportIssuingCountry")
		private Country passportIssuingCountry;

		@Column(name="VisaType")
		private Integer visaType;

		@Column(name="VisaValidUpto")
		private String visaValidUpto;

		@Column(name="VisaSponsoringAgency")
		private Integer visaSponsoringAgency;

		@Column(name="ResidentialPermitNo")
		private String residentialPermitNo;

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

//REGION END ********************

	@JoinColumn(name="FK_Student", nullable = false)
	@OneToOne
	private Student student;
	
	/*@JoinColumn(name="FK_Address")
	@OneToOne
	private Address address;*/

		//User
		public Student getStudent() {
			return student;
		}
		public void setStudent(final Student student) {
			this.student = student;
		}

		/*//Address
		public Address getAddress() {
			return address;
		}
		public void setAddress(Address address) {
			this.address = address;
		}*/
	
	
}