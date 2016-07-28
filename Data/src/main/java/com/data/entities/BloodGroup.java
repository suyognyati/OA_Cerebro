package com.data.entities;

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
	private int BloodGroupId;
	private String BolldGroupName;
	
	//BloodGroupId
	public int getBloodGroupId() {
		return BloodGroupId;
	}
	public void setBloodGroupId(int bloodGroupId) {
		BloodGroupId = bloodGroupId;
	}
	
	//BolldGroupName
	public String getBolldGroupName() {
		return BolldGroupName;
	}
	public void setBolldGroupName(String bolldGroupName) {
		BolldGroupName = bolldGroupName;
	}
}
