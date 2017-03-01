package com.data.entities;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="Countries")
public class Country {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="CountryId")
	private Integer countryId;

	@Column(name="CountryShortName")
	private String countryShortName;
	
	@Column(name="CountryName")
	private String countryName;
	
	/*@OneToMany(mappedBy = "country", fetch = FetchType.EAGER)
	private List<State> stateList;*/

	//CountryId
	public Integer getCountryId() {
		return countryId;
	}

	public void setCountryId(Integer countryId) {
		this.countryId = countryId;
	}

	//CountryShortName
	public String getCountryShortName() {
		return countryShortName;
	}

	public void setCountryShortName(String countryShortName) {
		this.countryShortName = countryShortName;
	}

	//CountryName
	public String getCountryName() {
		return countryName;
	}

	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}	
	
	/*//StateList
	public List<State> getStateList() {
		return stateList;
	}

	public void setStateList(List<State> stateList) {
		this.stateList = stateList;
	}*/
	
}
