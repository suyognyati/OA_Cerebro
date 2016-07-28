package com.data.entities;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.data.entities.Enums.GenderType;

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
	private int UserId;
	private int Gender;
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
	public int getUserId() {
		return UserId;
	}
	public void setUserId(final int userId) {
		UserId = userId;
	}

	//Gender
	public int getGender() {
		return Gender;
	}
	public void setGender(final GenderType gender) {
		Gender = gender.getValue();
	}

	//BloodGroup
	public BloodGroup getBloodGroup() {
		return BloodGroup;
	}
	public void setBloodGroup(final BloodGroup bloodGroup) {
		BloodGroup = bloodGroup;
	}
}