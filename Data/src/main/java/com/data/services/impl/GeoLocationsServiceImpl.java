package com.data.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.data.entities.Country;
import com.data.entities.State;
import com.data.repository.CountryJpaRepository;
import com.data.repository.StateJpaRepository;
import com.data.services.GeoLocationsService;

@Service("geoLocationsService")
public class GeoLocationsServiceImpl implements GeoLocationsService {

	@Autowired
	CountryJpaRepository countryJpaRepository;
	
	@Autowired
	StateJpaRepository stateJpaRepository;
	
	public Country getCountryByName(String countryName) {
		List<Country> countryList = countryJpaRepository.findByCountryName(countryName);
		if(countryList.isEmpty())
			return null;
		else
			return countryList.get(0);
	}
	
	public Country getCountryById(Integer countryId) {
		return countryJpaRepository.findByCountryId(countryId);
	}

	public List<Country> getCountryList() {
		return countryJpaRepository.findAll();
	}
	
	public List<State> getStateListByCountryName(String countryName) {
		Country country = getCountryByName(countryName);
		if(country != null)
			return stateJpaRepository.findByCountry(country);
		else
			return null;
	}

	public List<State> getStateListByCountryId(Integer countryId) {
		Country country = getCountryById(countryId);
		if(country != null)
			return stateJpaRepository.findByCountry(country);
		else
			return null;
	}

}
