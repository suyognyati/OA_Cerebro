package com.data.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * The persistent class for the BasicDetails database table.
 *
 */

@Entity
@Table(name="UserDetails")
public class UserDetail {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="UserDetailId")
	private int userDetailId;
	
	@Column(name="FirstName")
	private String firstName;
	
	@Column(name="LastName")
	private String lastName;
	
	@Column(name="DateOfBirth")
	private String dateOfBirth;
	
	@Column(name="Email")
	private String email;
	
	@Column(name="MobileNo")
	private String mobileNo;
	
	@OneToOne
	@JoinColumn(name="FK_User", nullable = false)
	private User user;
	
	//UserDetailId
	public int getUserDetailId() {
		return userDetailId;
	}
	public void setUserDetailId(int userId) {
		this.userDetailId = userId;
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
	
	//User
	public User getUser() {
		return user;
	}
	public void setUser(final User user) {
		this.user = user;
	}
	
}
