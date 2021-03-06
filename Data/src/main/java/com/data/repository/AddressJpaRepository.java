package com.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.data.entities.Address;
import com.data.entities.Student;

@Repository("addressJpaRepository")
public interface AddressJpaRepository extends JpaRepository<Address, Integer> {
	Address findByStudent(Student student);
}
