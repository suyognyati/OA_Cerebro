package com.data.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity
@Table(name="Address")
public class Address {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="AddressId")
	private Integer addressId;
	
		//Address Id
		public Integer getAddressId() {
			return addressId;
		}
		public void setAddressId(Integer addressId) {
			this.addressId = addressId;
		}
		
		
//******************** REGION CORRESPONDENCE ADDRESS
	
	@Column(name="FlatNo")
	private String flatNo;
	
	@Column(name="Street")
	private String street;
	
	@Column(name="Area")
	private String area;
	
	@Column(name="Landmark")
	private String landmark;
	
	@Column(name="PinCode")
	private String pinCode;
	
	@Column(name="City")
	private String city;
	
	@Column(name="District")
	private String district;
	
	@ManyToOne
	@JoinColumn(name="FK_State")
	private State state;
	
	@ManyToOne
	@JoinColumn(name="FK_Country")
	private Country country;
	
	@Column(name="LocationArea")
	private Integer locationArea;
	
		//Flat No
		public String getFlatNo() {
			return flatNo;
		}
		public void setFlatNo(String flatNo) {
			this.flatNo = flatNo;
		}
		
		//Street
		public String getStreet() {
			return street;
		}
		public void setStreet(String street) {
			this.street = street;
		}
		
		//Area
		public String getArea() {
			return area;
		}
		public void setArea(String area) {
			this.area = area;
		}
		
		//Landmark
		public String getLandmark() {
			return landmark;
		}
		public void setLandmark(String landmark) {
			this.landmark = landmark;
		}
	
		//Pin Code
		public String getPinCode() {
			return pinCode;
		}
		public void setPinCode(String pinCode) {
			this.pinCode = pinCode;
		}
		
		//City
		public String getCity() {
			return city;
		}
		public void setCity(String city) {
			this.city = city;
		}
		
		//State
		public State getState() {
			return state;
		}
		public void setState(State state) {
			this.state = state;
		}
		
		//District
		public String getDistrict() {
			return district;
		}
		public void setDistrict(String district) {
			this.district = district;
		}
		
		//Country
		public Country getCountry() {
			return country;
		}
		public void setCountry(Country country) {
			this.country = country;
		}
		
		//Location Area
		public Integer getLocationArea() {
			return locationArea;
		}
		public void setLocationArea(Integer locationArea) {
			this.locationArea = locationArea;
		}
		
//END REGION ********************

//******************** REGION PERMANENT ADDRESS
	
	@Column(name="IsNotSameAsCorrespondence")
	private Boolean IsNotSameAsCorrespondence;
	
	@Column(name="FlatNoPermanent")
	private String flatNoPermanent;
	
	@Column(name="StreetPermanent")
	private String streetPermanent;
	
	@Column(name="AreaPermanent")
	private String areaPermanent;
	
	@Column(name="LandmarkPermanent")
	private String landmarkPermanent;
	
	@Column(name="PinCodePermanent")
	private String pinCodePermanent;
	
	@Column(name="CityPermanent")
	private String cityPermanent;
	
	@Column(name="DistrictPermanent")
	private String districtPermanent;
	
	@ManyToOne
	@JoinColumn(name="FK_StatePermanent")
	private State statePermanent;
	
	@ManyToOne
	@JoinColumn(name="FK_CountryPermanent")
	private Country countryPermanent;

	@Column(name="LocationAreaPermanent")
	private Integer locationAreaPermanent;
	
		//IsNotSameAsCorrespondence
		public Boolean getIsNotSameAsCorrespondence() {
			return IsNotSameAsCorrespondence;
		}
		public void setIsNotSameAsCorrespondence(Boolean isNotSameAsCorrespondence) {
			IsNotSameAsCorrespondence = isNotSameAsCorrespondence;
		}
		
		//FlatNoPermanent
		public String getFlatNoPermanent() {
			return flatNoPermanent;
		}
		public void setFlatNoPermanent(String flatNoPermanent) {
			this.flatNoPermanent = flatNoPermanent;
		}
		
		//StreetPermanent
		public String getStreetPermanent() {
			return streetPermanent;
		}
		public void setStreetPermanent(String streetPermanent) {
			this.streetPermanent = streetPermanent;
		}
		
		//AreaPermanent
		public String getAreaPermanent() {
			return areaPermanent;
		}
		public void setAreaPermanent(String areaPermanent) {
			this.areaPermanent = areaPermanent;
		}
		
		//LandmarkPermanent
		public String getLandmarkPermanent() {
			return landmarkPermanent;
		}
		public void setLandmarkPermanent(String landmarkPermanent) {
			this.landmarkPermanent = landmarkPermanent;
		}
		
		//PinCodePermanent
		public String getPinCodePermanent() {
			return pinCodePermanent;
		}
		public void setPinCodePermanent(String pinCodePermanent) {
			this.pinCodePermanent = pinCodePermanent;
		}
		
		//CityPermanent
		public String getCityPermanent() {
			return cityPermanent;
		}
		public void setCityPermanent(String cityPermanent) {
			this.cityPermanent = cityPermanent;
		}
		
		//DistrictPermanent
		public String getDistrictPermanent() {
			return districtPermanent;
		}
		public void setDistrictPermanent(String districtPermanent) {
			this.districtPermanent = districtPermanent;
		}
		
		//StatePermanent
		public State getStatePermanent() {
			return statePermanent;
		}
		public void setStatePermanent(State statePermanent) {
			this.statePermanent = statePermanent;
		}
		
		//CountryPermanent
		public Country getCountryPermanent() {
			return countryPermanent;
		}
		public void setCountryPermanent(Country countryPermanent) {
			this.countryPermanent = countryPermanent;
		}
		
		//LecationAreaPermanent
		public Integer getLocationAreaPermanent() {
			return locationAreaPermanent;
		}
		public void setLocationAreaPermanent(Integer locationAreaPermanent) {
			this.locationAreaPermanent = locationAreaPermanent;
		}
		
//END REGION ********************
	
	@JoinColumn(name="FK_Student", nullable = false)
	@OneToOne
	Student student;

		//Student
		public Student getStudent() {
			return student;
		}
		public void setStudent(Student student) {
			this.student = student;
		}		
}
