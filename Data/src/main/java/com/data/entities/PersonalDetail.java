package com.data.entities;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.data.entities.Enums.GenderType;
import com.data.entities.Enums.MaritalStatusType;

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
	private int personalDetailId;
	
		//PersonalDetailId
		public int getPersonalDetailId() {
			return personalDetailId;
		}
		public void setPersonalDetailId(final int personalDetailId) {
			this.personalDetailId = personalDetailId;
		}
		
	
//******************** REGION NAME
	
	@Column(name="FirstName")
	private String firstName;
	
	@Column(name="LastName")
	private String lastName;
	
	@Column(name="RelationType")
	private int relationType;
	
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
	
	@Column(name="IsPreviousName")
	private Boolean isPreviousName;
	
	@Column(name="FirstNamePrevious")
	private String firstNamePrevious;
	
	@Column(name="LastNamePrevious")
	private String lastNamePrevious;
	
	@Column(name="MiddleNamePrevious")
	private String middleNamePrevious;
	
	@Column(name="NameChangeReason")
	private int nameChangeReason;
	
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
		public int getRelationType() {
			return relationType;
		}
		public void setRelationType(int relationType) {
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
		
		//IsPreviousName
		public Boolean getIsPreviousName() {
			return isPreviousName;
		}
		public void setIsPreviousName(Boolean isPreviousName) {
			this.isPreviousName = isPreviousName;
		}
		
		//FirstNamePrevious
		public String getFirstNamePrevious() {
			return firstNamePrevious;
		}
		public void setFirstNamePrevious(String firstNamePrevious) {
			this.firstNamePrevious = firstNamePrevious;
		}
		
		//LastNamePrevious
		public String getLastNamePrevious() {
			return lastNamePrevious;
		}
		public void setLastNamePrevious(String lastNamePrevious) {
			this.lastNamePrevious = lastNamePrevious;
		}
		
		//MiddleNamePrevious
		public String getMiddleNamePrevious() {
			return middleNamePrevious;
		}
		public void setMiddleNamePrevious(String middleNamePrevious) {
			this.middleNamePrevious = middleNamePrevious;
		}
		
		//NameChangeReason
		public int getNameChangeReason() {
			return nameChangeReason;
		}
		public void setNameChangeReason(int nameChangeReason) {
			this.nameChangeReason = nameChangeReason;
		}
	
//ENDREGION ********************

//******************** REGION SELFDETAIL
	
	@Column(name="AdharNo")
	private String adharNo;
	
	@Column(name="Gender")
	private int gender;

	@Column(name="PlaceOfBirth")
	private String placeOfBirth;

	@Column(name="MaritalStatus")
	private int maritalStatus;

	@JoinColumn(name="FK_BloodGroup")
	@ManyToOne
	private BloodGroup bloodGroup;
	
		//AdharNo
		public String getAdharNo() {
			return adharNo;
		}
		public void setAdharNo(String adharNo) {
			this.adharNo = adharNo;
		}
		
		//Gender
		public GenderType getGender() {
			GenderType gender = Enums.GenderTypes[this.gender - 1];
			return gender;
		}
		public void setGender(final GenderType gender) {
			this.gender = gender.getValue();
		}
		
		//PlaceOfBirth
		public String getPlaceOfBirth() {
			return placeOfBirth;
		}
		public void setPlaceOfBirth(String placeOfBirth) {
			this.placeOfBirth = placeOfBirth;
		}
		
		//MaritalStatus
		public MaritalStatusType getMaritalStatus() {
			MaritalStatusType maritalStatus = Enums.MaritalStatusTypes[this.maritalStatus - 1];
			return maritalStatus;
		}
		public void setMaritalStatus(MaritalStatusType maritalStatus) {
			this.maritalStatus = maritalStatus.getValue();
		}
		
		//BloodGroup
		public BloodGroup getBloodGroup() {
			return bloodGroup;
		}
		public void setBloodGroup(final BloodGroup bloodGroup) {
			this.bloodGroup = bloodGroup;
		}

//ENDREGION ********************

//******************** REGION NATIONALITY DETAIL
	
	@Column(name="Domicil")
	private String domicil;
	
		//Domicil
		public String getDomicil() {
			return domicil;
		}
		public void setDomicil(String domicil) {
			this.domicil = domicil;
		}

//REGION END ********************

	@JoinColumn(name="FK_User", nullable = false)
	@OneToOne
	private User user;
	
	@JoinColumn(name="FK_Address")
	@OneToOne(cascade=CascadeType.ALL)
	private Address address;

		//User
		public User getUser() {
			return user;
		}
		public void setUser(final User user) {
			this.user = user;
		}

		//Address
		public Address getAddress() {
			return address;
		}
		public void setAddress(Address address) {
			this.address = address;
		}
	
	
}