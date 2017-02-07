package com.data.services;

import java.util.List;

import com.data.entities.Country;
import com.data.entities.State;

public interface GeoLocationsService {
	Country getCountryById(Integer countryId);
	Country getCountryByName(String countryName);
	List<Country> getCountryList();
	List<State> getStateListByCountryName(String countryName);
	List<State> getStateListByCountryId(Integer countryId);
}
