package com.web.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.data.entities.Address;
import com.data.services.AddressService;
import com.web.model.AddressModel;
import com.web.services.AddressRCService;
import com.web.session.Session;

@Service("AddressRCService")
public class AddressRCServiceImpl implements AddressRCService {

	@Autowired
	Session userSession;
	
	@Autowired
	AddressService addressService;
	
	public AddressModel getAddress() {
		AddressModel addressModel = new AddressModel();
		Address address = addressService.getByUser(userSession.getCurrentUser());
		if(address != null) {
			addressModel = setAddressModelObject(addressModel, address);
		}
		return addressModel;
	}
	
	public Boolean saveAddress(AddressModel addressModel) {
		Address address = addressService.getByUser(userSession.getCurrentUser());
		if(address == null) {
			address = new Address();
			address.setUser(userSession.getCurrentUser());
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

		addressModel.setIsNotSameAsCorrespondence(address.getIsNotSameAsCorrespondence());
		
		addressModel.setFlatNoPermenent(address.getFlatNoPermenent());
		addressModel.setStreetPermenent(address.getStreetPermenent());
		addressModel.setAreaPermenent(address.getAreaPermenent());
		addressModel.setLandmarkPermenent(address.getLandmarkPermenent());
		addressModel.setPinCodePermenent(address.getPinCodePermenent());
		addressModel.setCityPermenent(address.getCityPermenent());
		addressModel.setDistrictPermenent(address.getDistrictPermenent());
		addressModel.setStatePermenent(address.getStatePermenent());
		addressModel.setCountryPermenent(address.getCountryPermenent());
		
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

		address.setIsNotSameAsCorrespondence(addressModel.getIsNotSameAsCorrespondence());
		
		if(addressModel.getIsNotSameAsCorrespondence()) {		
			address.setFlatNoPermenent(addressModel.getFlatNoPermenent());
			address.setStreetPermenent(addressModel.getStreetPermenent());
			address.setAreaPermenent(addressModel.getAreaPermenent());
			address.setLandmarkPermenent(addressModel.getLandmarkPermenent());
			address.setPinCodePermenent(addressModel.getPinCodePermenent());
			address.setCityPermenent(addressModel.getCityPermenent());
			address.setDistrictPermenent(addressModel.getDistrictPermenent());
			address.setStatePermenent(addressModel.getStatePermenent());
			address.setCountryPermenent(addressModel.getCountryPermenent());
		}
		else {
			address.setFlatNoPermenent(addressModel.getFlatNo());
			address.setStreetPermenent(addressModel.getStreet());
			address.setAreaPermenent(addressModel.getArea());
			address.setLandmarkPermenent(addressModel.getLandmark());
			address.setPinCodePermenent(addressModel.getPinCode());
			address.setCityPermenent(addressModel.getCity());
			address.setDistrictPermenent(addressModel.getDistrict());
			address.setStatePermenent(addressModel.getState());
			address.setCountryPermenent(addressModel.getCountry());
		}
		
		return address;
	}
	
}
