package com.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.data.entities.Address;
import com.data.entities.User;

@Repository("addressJpaRepository")
public interface AddressJpaRepository extends JpaRepository<Address, Integer> {
	Address findByUser(User user);
}
