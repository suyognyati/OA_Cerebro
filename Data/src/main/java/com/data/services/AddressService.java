package com.data.services;

import com.data.entities.Address;
import com.data.entities.User;

public interface AddressService {
	Address getByUser(User user);
	Boolean save(Address address);
}
