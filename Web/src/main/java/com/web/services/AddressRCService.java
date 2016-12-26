package com.web.services;

import com.web.model.AddressModel;

public interface AddressRCService {
	AddressModel getAddress();
	Boolean saveAddress(AddressModel addressModel);
}
