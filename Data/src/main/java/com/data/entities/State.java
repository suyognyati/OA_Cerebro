package com.data.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="States")
public class State {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="StateId")
	private Integer stateId;

	@Column(name="StateName")
	private String stateName;
	
	@ManyToOne
	@JoinColumn(name="FK_CountryId", nullable=false)
	private Country country;
	
	
	//StateId
	public Integer getStateId() {
		return stateId;
	}
	public void setStateId(Integer stateId) {
		this.stateId = stateId;
	}
	
	//StateName
	public String getStateName() {
		return stateName;
	}
	public void setStateName(String stateName) {
		this.stateName = stateName;
	}
	
	//Country
	public Country getCountry() {
		return country;
	}
	public void setCountry(Country country) {
		this.country = country;
	}
	
}
