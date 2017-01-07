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
@Table(name="Cities")
public class City {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="CityId")
	private Integer cityId;

	@Column(name="CityName")
	private String cityName;
	
	@ManyToOne
	@JoinColumn(name="FK_StateId", nullable=false)
	private State state;

	//CityId
	public Integer getCityId() {
		return cityId;
	}

	public void setCityId(Integer cityId) {
		this.cityId = cityId;
	}

	//CityName
	public String getCityName() {
		return cityName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

	//State
	public State getState() {
		return state;
	}

	public void setState(State state) {
		this.state = state;
	}
}
