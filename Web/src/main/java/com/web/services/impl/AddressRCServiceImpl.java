package com.web.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.data.entities.Address;
import com.data.entities.Enums;
import com.data.services.AddressService;
import com.data.services.GeoLocationsService;
import com.web.model.AddressModel;
import com.web.services.AddressRCService;
import com.web.session.Session;
import com.web.staticandconstants.StaticConstants;

@Service("AddressRCService")
public class AddressRCServiceImpl implements AddressRCService {

	@Autowired
	Session userSession;
	
	@Autowired
	AddressService addressService;
	
	@Autowired
	GeoLocationsService geoLocationService;
	
	public AddressModel getAddress() {
		AddressModel addressModel = new AddressModel();
		Address address = addressService.getByStudent(userSession.getStudent().getStudent());
		if(address != null) {
			addressModel = setAddressModelObject(addressModel, address);
		}
		addressModel.setCountryList(geoLocationService.getCountryList());
		addressModel.setStateList(geoLocationService.getStateListByCountryName(StaticConstants.StrINDIA));
		addressModel.setLocationAreaList(Enums.LocationArea.getEnumList());
		return addressModel;
	}
	
	public Boolean saveAddress(AddressModel addressModel) {
		Address address = addressService.getByStudent(userSession.getStudent().getStudent());
		if(address == null) {
			address = new Address();
			address.setStudent(userSession.getStudent().getStudent());
		}
		address = setAddressObject(address, addressModel);
		addressService.save(address);
		return true;
	}
	
	private AddressModel setAddressModelObject(AddressModel addressModel, Address address) {
		
		addressModel.setAddressId(address.getAddressId());
		addressModel.setFlatNo(address.getFlatNo());
		addressModel.setStreet(address.getStreet());
		addressModel.setArea(address.getArea());
		addressModel.setLandmark(address.getLandmark());
		addressModel.setPinCode(address.getPinCode());
		addressModel.setCity(address.getCity());
		addressModel.setDistrict(address.getDistrict());
		addressModel.setState(address.getState());
		addressModel.setCountry(address.getCountry());
		addressModel.setLocationArea(address.getLocationArea());

		addressModel.setIsSameAsCorrespondence(address.getIsNotSameAsCorrespondence());
		
		addressModel.setFlatNoPermanent(address.getFlatNoPermanent());
		addressModel.setStreetPermanent(address.getStreetPermanent());
		addressModel.setAreaPermanent(address.getAreaPermanent());
		addressModel.setLandmarkPermanent(address.getLandmarkPermanent());
		addressModel.setPinCodePermanent(address.getPinCodePermanent());
		addressModel.setCityPermanent(address.getCityPermanent());
		addressModel.setDistrictPermanent(address.getDistrictPermanent());
		addressModel.setStatePermanent(address.getStatePermanent());
		addressModel.setCountryPermanent(address.getCountryPermanent());
		addressModel.setLocationAreaPermanent(address.getLocationAreaPermanent());
		
		return addressModel;
	}
	
	private Address setAddressObject(Address address, AddressModel addressModel) {
		
		address.setFlatNo(addressModel.getFlatNo());
		address.setStreet(addressModel.getStreet());
		address.setArea(addressModel.getArea());
		address.setLandmark(addressModel.getLandmark());
		address.setPinCode(addressModel.getPinCode());
		address.setCity(addressModel.getCity());
		address.setDistrict(addressModel.getDistrict());
		address.setState(addressModel.getState());
		address.setCountry(addressModel.getCountry());
		address.setLocationArea(addressModel.getLocationArea());

		address.setIsNotSameAsCorrespondence(addressModel.getIsSameAsCorrespondence());
		
		if(addressModel.getIsSameAsCorrespondence() != null && addressModel.getIsSameAsCorrespondence()) {		
			address.setFlatNoPermanent(addressModel.getFlatNo());
			address.setStreetPermanent(addressModel.getStreet());
			address.setAreaPermanent(addressModel.getArea());
			address.setLandmarkPermanent(addressModel.getLandmark());
			address.setPinCodePermanent(addressModel.getPinCode());
			address.setCityPermanent(addressModel.getCity());
			address.setDistrictPermanent(addressModel.getDistrict());
			address.setStatePermanent(addressModel.getState());
			address.setCountryPermanent(addressModel.getCountry());
			address.setLocationAreaPermanent(addressModel.getLocationArea());
		}
		else {
			address.setFlatNoPermanent(addressModel.getFlatNoPermanent());
			address.setStreetPermanent(addressModel.getStreetPermanent());
			address.setAreaPermanent(addressModel.getAreaPermanent());
			address.setLandmarkPermanent(addressModel.getLandmarkPermanent());
			address.setPinCodePermanent(addressModel.getPinCodePermanent());
			address.setCityPermanent(addressModel.getCityPermanent());
			address.setDistrictPermanent(addressModel.getDistrictPermanent());
			address.setStatePermanent(addressModel.getStatePermanent());
			address.setCountryPermanent(addressModel.getCountryPermanent());
			address.setLocationAreaPermanent(addressModel.getLocationAreaPermanent());
		}
		
		return address;
	}
	
}
