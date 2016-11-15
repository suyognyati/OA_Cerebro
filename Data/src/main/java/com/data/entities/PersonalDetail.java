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
	
	@Column(name="FirstName")
	private String firstName;
	
	@Column(name="LastName")
	private String lastName;
	
	@Column(name="MiddleName")
	private String middleName;
	
	@Column(name="MotherName")
	private String motherName;
	
	@Column(name="OtherContact")
	private String otherContact;
	
	@Column(name="Gender")
	private int gender;

	@Column(name="Domicil")
	private String domicil;

	@Column(name="PlaceOfBirth")
	private String placeOfBirth;

	@Column(name="MaritalStatus")
	private int maritalStatus;

	@JoinColumn(name="FK_User", nullable = false)
	@OneToOne
	private User user;
	
	@JoinColumn(name="FK_Address")
	@OneToOne(cascade=CascadeType.ALL)
	private Address address;

	@JoinColumn(name="FK_BloodGroup")
	@ManyToOne
	private BloodGroup bloodGroup;

	//PersonalDetailId
	public int getPersonalDetailId() {
		return personalDetailId;
	}
	public void setPersonalDetailId(final int personalDetailId) {
		this.personalDetailId = personalDetailId;
	}

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
	
	//OtherContact
	public String getOtherContact() {
		return otherContact;
	}
	public void setOtherContact(String otherContact) {
		this.otherContact = otherContact;
	}
	
	//User
	public User getUser() {
		return user;
	}
	public void setUser(final User user) {
		this.user = user;
	}

	//Gender
	public GenderType getGender() {
		GenderType gender = Enums.GenderTypes[this.gender - 1];
		return gender;
	}
	public void setGender(final GenderType gender) {
		this.gender = gender.getValue();
	}

	//Domicil
	public String getDomicil() {
		return domicil;
	}
	public void setDomicil(String domicil) {
		this.domicil = domicil;
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
	
	//Address
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	
	//BloodGroup
	public BloodGroup getBloodGroup() {
		return bloodGroup;
	}
	public void setBloodGroup(final BloodGroup bloodGroup) {
		this.bloodGroup = bloodGroup;
	}
}