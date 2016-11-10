package com.web.model;

import java.util.List;

import com.data.entities.BloodGroup;
import com.data.entities.Enums;
import com.data.entities.Enums.MaritalStatusType;

public class PersonalDetailModel {
	private String lastName;
	private String firstName;
	private String middleName;
	private String mothersName;
	private String birthDate;
	private String email;
	private String mobileNo;
	private String otherContactNo;
	private int gender;
	private int bloodGroup;
	private String placeOfBirth;
	private String domiciledIn;
	private int maritalStatus;
	private String flatNo;
	private String street;
	private String area;
	private String pinCode;
	private String city;
	private String state;
	private List<BloodGroup> bloodGroups;
	
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
	
	// BirthDate getter setter
	public String getBirthDate() {
		return birthDate;
	}
	public void setBirthDate(String birthDate) {
		this.birthDate = birthDate;
	}
	
	// Email getter setter
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	// MobileNo getter setter
	public String getMobileNo() {
		return mobileNo;
	}
	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}
	
	// OtherContactNo getter setter
	public String getOtherContactNo() {
		return otherContactNo;
	}
	public void setOtherContactNo(String otherContactNo) {
		this.otherContactNo = otherContactNo;
	}
	
	//Gender getter setter
	public int getGender() {
		return this.gender;
	}
	public void setGender(int genderval) {
		this.gender = genderval;
	}
	
	//Blood Group getter setter
	public int getBloodGroup() {
		return bloodGroup;
	}
	public void setBloodGroup(int bloodGroup) {
		this.bloodGroup = bloodGroup;
	}
	
	//Place of Birth getter setter
	public String getPlaceOfBirth() {
		return placeOfBirth;
	}
	public void setPlaceOfBirth(String placeOfBirth) {
		this.placeOfBirth = placeOfBirth;
	}
	
	//Domiciled In getter setter
	public String getDomiciledIn() {
		return domiciledIn;
	}
	public void setDomiciledIn(String domiciledIn) {
		this.domiciledIn = domiciledIn;
	}
	
	//Marrital Status getter setter
	public MaritalStatusType getMaritalStatus() {
		MaritalStatusType maritalStatus = Enums.MaritalStatusTypes[this.maritalStatus - 1];
		return maritalStatus;
	}
	public void setMaritalStatus(MaritalStatusType maritalStatus) {
		this.maritalStatus = maritalStatus.getValue();
	}
	
	//Flat No getter setter
	public String getFlatNo() {
		return flatNo;
	}
	public void setFlatNo(String flatNo) {
		this.flatNo = flatNo;
	}
	
	//Street getter setter
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	
	//Area getter setter
	public String getArea() {
		return area;
	}
	public void setArea(String area) {
		this.area = area;
	}
	
	//Pin Code getter setter
	public String getPinCode() {
		return pinCode;
	}
	public void setPinCode(String pinCode) {
		this.pinCode = pinCode;
	}
	
	//City getter setter
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	
	//State getter setter
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public List<BloodGroup> getBloodGroups() {
		return bloodGroups;
	}
	public void setBloodGroups(List<BloodGroup> bloodGroups) {
		this.bloodGroups = bloodGroups;
	}	
}
