package com.data.services;

import com.data.entities.Address;
import com.data.entities.UserDetail;

public interface AddressService {
	Address getByUserDetail(UserDetail userDetail);
	Boolean save(Address address);
}
