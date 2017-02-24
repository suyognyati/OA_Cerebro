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
		
//END REGION ********************

//******************** REGION PERMENENT ADDRESS
	
	@Column(name="IsNotSameAsCorrespondence")
	private Boolean IsNotSameAsCorrespondence;
	
	@Column(name="FlatNoPermenent")
	private String flatNoPermenent;
	
	@Column(name="StreetPermenent")
	private String streetPermenent;
	
	@Column(name="AreaPermenent")
	private String areaPermenent;
	
	@Column(name="LandmarkPermenent")
	private String landmarkPermenent;
	
	@Column(name="PinCodePermenent")
	private String pinCodePermenent;
	
	@Column(name="CityPermenent")
	private String cityPermenent;
	
	@Column(name="DistrictPermenent")
	private String districtPermenent;
	
	@ManyToOne
	@JoinColumn(name="FK_StatePermenent")
	private State statePermenent;
	
	@ManyToOne
	@JoinColumn(name="FK_CountryPermenent")
	private Country countryPermenent;

		//IsNotSameAsCorrespondence
		public Boolean getIsNotSameAsCorrespondence() {
			return IsNotSameAsCorrespondence;
		}
		public void setIsNotSameAsCorrespondence(Boolean isNotSameAsCorrespondence) {
			IsNotSameAsCorrespondence = isNotSameAsCorrespondence;
		}
		
		//FlatNoPermenent
		public String getFlatNoPermenent() {
			return flatNoPermenent;
		}
		public void setFlatNoPermenent(String flatNoPermenent) {
			this.flatNoPermenent = flatNoPermenent;
		}
		
		//StreetPermenent
		public String getStreetPermenent() {
			return streetPermenent;
		}
		public void setStreetPermenent(String streetPermenent) {
			this.streetPermenent = streetPermenent;
		}
		
		//AreaPermenent
		public String getAreaPermenent() {
			return areaPermenent;
		}
		public void setAreaPermenent(String areaPermenent) {
			this.areaPermenent = areaPermenent;
		}
		
		//LandmarkPermenent
		public String getLandmarkPermenent() {
			return landmarkPermenent;
		}
		public void setLandmarkPermenent(String landmarkPermenent) {
			this.landmarkPermenent = landmarkPermenent;
		}
		
		//PinCodePermenent
		public String getPinCodePermenent() {
			return pinCodePermenent;
		}
		public void setPinCodePermenent(String pinCodePermenent) {
			this.pinCodePermenent = pinCodePermenent;
		}
		
		//CityPermenent
		public String getCityPermenent() {
			return cityPermenent;
		}
		public void setCityPermenent(String cityPermenent) {
			this.cityPermenent = cityPermenent;
		}
		
		//DistrictPermenent
		public String getDistrictPermenent() {
			return districtPermenent;
		}
		public void setDistrictPermenent(String districtPermenent) {
			this.districtPermenent = districtPermenent;
		}
		
		//StatePermenent
		public State getStatePermenent() {
			return statePermenent;
		}
		public void setStatePermenent(State statePermenent) {
			this.statePermenent = statePermenent;
		}
		
		//CountryPermenent
		public Country getCountryPermenent() {
			return countryPermenent;
		}
		public void setCountryPermenent(Country countryPermenent) {
			this.countryPermenent = countryPermenent;
		}
		
//END REGION ********************
	
	@JoinColumn(name="FK_User")
	@OneToOne
	User user;

		//User
		public User getUser() {
			return user;
		}
		public void setUser(User user) {
			this.user = user;
		}		
}
