package com.data.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * The persistent class for the BloodGroup database table.
 * 
 */

@Entity
@Table(name="BloodGroups")
public class BloodGroup {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="BloodGroupId")
	private int bloodGroupId;

	@Column(name="BloodGroupName")
	private String bloodGroupName;
	
	//BloodGroupId
	public int getBloodGroupId() {
		return bloodGroupId;
	}
	public void setBloodGroupId(int bloodGroupId) {
		this.bloodGroupId = bloodGroupId;
	}
	
	//BolldGroupName
	public String getBloodGroupName() {
		return bloodGroupName;
	}
	public void setBloodGroupName(String bloodGroupName) {
		this.bloodGroupName = bloodGroupName;
	}
}
