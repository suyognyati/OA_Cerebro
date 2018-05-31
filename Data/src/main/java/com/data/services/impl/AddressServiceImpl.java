package com.data.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.data.entities.Address;
import com.data.entities.Student;
import com.data.repository.AddressJpaRepository;
import com.data.services.AddressService;

@Service("addressService")
public class AddressServiceImpl implements AddressService {

	@Autowired 
	AddressJpaRepository addressJpaRepository;
	
	public Address getByStudent(Student student) {
		return addressJpaRepository.findByStudent(student);
	}

	public Boolean save(Address address) {
		addressJpaRepository.save(address);
		return true;
	}

}
