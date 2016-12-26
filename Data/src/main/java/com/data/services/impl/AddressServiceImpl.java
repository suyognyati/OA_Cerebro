package com.data.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.data.entities.Address;
import com.data.entities.User;
import com.data.repository.AddressJpaRepository;
import com.data.services.AddressService;

@Service("addressService")
public class AddressServiceImpl implements AddressService {

	@Autowired 
	AddressJpaRepository addressJpaRepository;
	
	public Address getByUser(User user) {
		return addressJpaRepository.findByUser(user);
	}

	public Boolean save(Address address) {
		addressJpaRepository.save(address);
		return true;
	}

}
