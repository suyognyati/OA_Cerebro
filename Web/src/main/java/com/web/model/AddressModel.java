package com.web.model;

public class AddressModel {
	private int addressId;
	
		//Address Id
		public int getAddressId() {
			return addressId;
		}
		public void setAddressId(int addressId) {
			this.addressId = addressId;
		}
		
		
//******************** REGION CORRESPONDENCE ADDRESS
	
	private String flatNo;
	private String street;
	private String area;
	private String landmark;
	private String pinCode;
	private String city;
	private String district;
	private String state;
	private String country;
	
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
		public String getState() {
			return state;
		}
		public void setState(String state) {
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
		public String getCountry() {
			return country;
		}
		public void setCountry(String country) {
			this.country = country;
		}
		
//END REGION ********************

//******************** REGION PERMENENT ADDRESS
	
	private Boolean IsNotSameAsCorrespondence;
	private String flatNoPermenent;
	private String streetPermenent;
	private String areaPermenent;
	private String landmarkPermenent;
	private String pinCodePermenent;
	private String cityPermenent;
	private String districtPermenent;
	private String statePermenent;
	private String countryPermenent;

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
		public String getStatePermenent() {
			return statePermenent;
		}
		public void setStatePermenent(String statePermenent) {
			this.statePermenent = statePermenent;
		}
		
		//CountryPermenent
		public String getCountryPermenent() {
			return countryPermenent;
		}
		public void setCountryPermenent(String countryPermenent) {
			this.countryPermenent = countryPermenent;
		}
		
//END REGION ********************
}
