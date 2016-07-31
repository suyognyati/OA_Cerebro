package com.data.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="Address")
public class Address {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int AddressId;
	private String FlatNo;
	private String Street;
	private String Area;
	private String PinCode;
	private String City;
	private String State;
	
	//Address Id
	public int getAddressId() {
		return AddressId;
	}
	public void setAddressId(int addressId) {
		AddressId = addressId;
	}
	
	//Flat No
	public String getFlatNo() {
		return FlatNo;
	}
	public void setFlatNo(String flatNo) {
		FlatNo = flatNo;
	}
	
	//Street
	public String getStreet() {
		return Street;
	}
	public void setStreet(String street) {
		Street = street;
	}
	
	//Area
	public String getArea() {
		return Area;
	}
	public void setArea(String area) {
		Area = area;
	}
	
	//Pin Code
	public String getPinCode() {
		return PinCode;
	}
	public void setPinCode(String pinCode) {
		PinCode = pinCode;
	}
	
	//City
	public String getCity() {
		return City;
	}
	public void setCity(String city) {
		City = city;
	}
	
	//State
	public String getState() {
		return State;
	}
	public void setState(String state) {
		State = state;
	}
	
}
