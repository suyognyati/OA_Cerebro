package com.data.entities;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
	private int PersonalDetailId;
	@OneToOne(cascade=CascadeType.ALL)
	private BasicDetail UserId;
	private int Gender;
	private String Domicil;
	private String PlaceOfBirth;
	private int MaritalStatus;
	@OneToOne(cascade=CascadeType.ALL)
	private Address Address;
	@ManyToOne(cascade=CascadeType.ALL)
	private BloodGroup BloodGroup;

	//PersonalDetailId
	public int getPersonalDetailId() {
		return PersonalDetailId;
	}
	public void setPersonalDetailId(final int personalDetailId) {
		PersonalDetailId = personalDetailId;
	}

	//UserId
	public BasicDetail getUserId() {
		return UserId;
	}
	public void setUserId(final BasicDetail userId) {
		UserId = userId;
	}

	//Gender
	public GenderType getGender() {
		GenderType gender = Enums.GenderTypes[this.Gender - 1];
		return gender;
	}
	public void setGender(final GenderType gender) {
		this.Gender = gender.getValue();
	}

	//Domicil
	public String getDomicil() {
		return Domicil;
	}
	public void setDomicil(String domicil) {
		Domicil = domicil;
	}
	
	//PlaceOfBirth
	public String getPlaceOfBirth() {
		return PlaceOfBirth;
	}
	public void setPlaceOfBirth(String placeOfBirth) {
		PlaceOfBirth = placeOfBirth;
	}
	
	//MaritalStatus
	public MaritalStatusType getMaritalStatus() {
		MaritalStatusType maritalStatus = Enums.MaritalStatusTypes[this.MaritalStatus - 1];
		return maritalStatus;
	}
	public void setMaritalStatus(MaritalStatusType maritalStatus) {
		this.MaritalStatus = maritalStatus.getValue();
	}
	
	//Address
	public Address getAddress() {
		return Address;
	}
	public void setAddress(Address address) {
		Address = address;
	}
	
	//BloodGroup
	public BloodGroup getBloodGroup() {
		return BloodGroup;
	}
	public void setBloodGroup(final BloodGroup bloodGroup) {
		BloodGroup = bloodGroup;
	}
}