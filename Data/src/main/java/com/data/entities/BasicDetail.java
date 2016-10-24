package com.data.entities;

import javax.persistence.Column;
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
	@Column(name="BasicDetailId")
	private int basicDetailId;
	
	@Column(name="FirstName")
	private String firstName;
	
	@Column(name="LastName")
	private String lastName;
	
	@Column(name="MidleName")
	private String midleName;
	
	@Column(name="MotherName")
	private String motherName;
	
	@Column(name="DateOfBirth")
	private String dateOfBirth;
	
	@Column(name="Email")
	private String email;
	
	@Column(name="MobileNo")
	private String mobileNo;
	
	@Column(name="OtherContact")
	private String otherContact;
		
	//UserId
	public int getUserId() {
		return basicDetailId;
	}
	public void setUserId(int userId) {
		this.basicDetailId = userId;
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
	public String getMidleName() {
		return midleName;
	}
	public void setMidleName(String midleName) {
		this.midleName = midleName;
	}
	
	//MotherName
	public String getMotherName() {
		return motherName;
	}
	public void setMotherName(String motherName) {
		this.motherName = motherName;
	}
	
	//DateOfBirth
	public String getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	
	//Email
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	//MobileNo
	public String getMobileNo() {
		return mobileNo;
	}
	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}
	
	//OtherContact
	public String getOtherContact() {
		return otherContact;
	}
	public void setOtherContact(String otherContact) {
		this.otherContact = otherContact;
	}
	
}
