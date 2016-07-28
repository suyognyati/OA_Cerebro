package com.data.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * The persistent class for the BasicDetails database table.
 *
 */

@Entity
@Table(name="BasicDetails")
public class BasicDetail {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int BasicDetailId;
	private int UserId;
	private String FirstName;
	private String LastName;
	private String MidleName;
	private String MotherName;
	private String DateOfBirth;
	private String Email;
	private String MobileNo;
	private String OtherContact;
	
	//BasicDetailId
	public int getBasicDetailId() {
		return BasicDetailId;
	}
	public void setBasicDetailId(int basicDetailId) {
		BasicDetailId = basicDetailId;
	}
	
	//UserId
	public int getUserId() {
		return UserId;
	}
	public void setUserId(int userId) {
		UserId = userId;
	}
	
	//FirstName
	public String getFirstName() {
		return FirstName;
	}
	public void setFirstName(String firstName) {
		FirstName = firstName;
	}
	
	//LastName
	public String getLastName() {
		return LastName;
	}
	public void setLastName(String lastName) {
		LastName = lastName;
	}
	
	//MidleName
	public String getMidleName() {
		return MidleName;
	}
	public void setMidleName(String midleName) {
		MidleName = midleName;
	}
	
	//MotherName
	public String getMotherName() {
		return MotherName;
	}
	public void setMotherName(String motherName) {
		MotherName = motherName;
	}
	
	//DateOfBirth
	public String getDateOfBirth() {
		return DateOfBirth;
	}
	public void setDateOfBirth(String dateOfBirth) {
		DateOfBirth = dateOfBirth;
	}
	
	//Email
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		Email = email;
	}
	
	//MobileNo
	public String getMobileNo() {
		return MobileNo;
	}
	public void setMobileNo(String mobileNo) {
		MobileNo = mobileNo;
	}
	
	//OtherContact
	public String getOtherContact() {
		return OtherContact;
	}
	public void setOtherContact(String otherContact) {
		OtherContact = otherContact;
	}
	
}
