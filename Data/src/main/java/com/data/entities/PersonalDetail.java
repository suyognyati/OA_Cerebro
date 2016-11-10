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
	
	@Column(name="Gender")
	private int gender;

	@Column(name="Domicil")
	private String domicil;

	@Column(name="PlaceOfBirth")
	private String placeOfBirth;

	@Column(name="MaritalStatus")
	private int maritalStatus;

	@JoinColumn(name="FK_User")
	@OneToOne(cascade=CascadeType.ALL)
	private User user;
	
	@JoinColumn(name="FK_Address")
	@OneToOne(cascade=CascadeType.ALL)
	private Address address;

	@JoinColumn(name="FK_BloodGroup")
	@ManyToOne(cascade=CascadeType.ALL)
	private BloodGroup bloodGroup;

	//PersonalDetailId
	public int getPersonalDetailId() {
		return personalDetailId;
	}
	public void setPersonalDetailId(final int personalDetailId) {
		this.personalDetailId = personalDetailId;
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