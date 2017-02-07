package com.data.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.data.entities.Country;

@Repository("countryJpaRepository")
public interface CountryJpaRepository extends JpaRepository<Country, Integer> {
	List<Country> findByCountryName(String countryName);
	Country findByCountryId(Integer countryId);
}
