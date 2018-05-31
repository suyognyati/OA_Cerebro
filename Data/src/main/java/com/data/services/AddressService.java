package com.data.services;

import com.data.entities.Address;
import com.data.entities.Student;

public interface AddressService {
	Address getByStudent(Student student);
	Boolean save(Address address);
}
