package com.web.model;

import java.util.List;

import com.data.entities.Country;
import com.data.entities.Enums;
import com.data.entities.State;

public class AddressModel {
	private Integer addressId;
	private Boolean IsSameAsCorrespondence;
	private List<Country> countryList;
	private List<State> stateList;
	private List<Enums.KeyValuePair> locationAreaList;
	
		//Address Id
		public Integer getAddressId() {
			return addressId;
		}
		public void setAddressId(int addressId) {
			this.addressId = addressId;
		}
		
		//IsSameAsCorrespondence
		public Boolean getIsSameAsCorrespondence() {
			return IsSameAsCorrespondence;
		}
		public void setIsSameAsCorrespondence(Boolean isSameAsCorrespondence) {
			IsSameAsCorrespondence = isSameAsCorrespondence;
		}
				
		//Country List
		public List<Country> getCountryList() {
			return countryList;
		}
		public void setCountryList(List<Country> countryList) {
			this.countryList = countryList;
		}
		
		//State List
		public List<State> getStateList() {
			return stateList;
		}
		public void setStateList(List<State> stateList) {
			this.stateList = stateList;
		}
		
		//Location Area List
		public List<Enums.KeyValuePair> getLocationAreaList() {
			return locationAreaList;
		}
		public void setLocationAreaList(List<Enums.KeyValuePair> locationAreaList) {
			this.locationAreaList = locationAreaList;
		}
		
		
//******************** REGION CORRESPONDENCE ADDRESS
	
	private String flatNo;
	private String street;
	private String area;
	private String landmark;
	private String pinCode;
	private String city;
	private String district;
	private State state;
	private Country country;
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
		
		//LocationArea
		public Integer getLocationArea() {
			return locationArea;
		}
		public void setLocationArea(Integer locationArea) {
			this.locationArea = locationArea;
		}
		
//END REGION ********************

//******************** REGION PERMANENT ADDRESS
	
	private String flatNoPermanent;
	private String streetPermanent;
	private String areaPermanent;
	private String landmarkPermanent;
	private String pinCodePermanent;
	private String cityPermanent;
	private String districtPermanent;
	private State statePermanent;
	private Country countryPermanent;
	private Integer locationAreaPermanent;

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
		
		//LocationAreaPermanent
		public Integer getLocationAreaPermanent() {
			return locationAreaPermanent;
		}
		public void setLocationAreaPermanent(Integer locationAreaPermanent) {
			this.locationAreaPermanent = locationAreaPermanent;
		}
		
//END REGION ********************
}
