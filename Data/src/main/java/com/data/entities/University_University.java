package com.data.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="University_Universities")
public class University_University {
	@Id
	@Column(name="BoardUniversityId")
	private Integer boardUniversityId;
	
	@Column(name="UniversityName")
	private String universityName;
	
	@Column(name="Address")
	private String address;
	
	@Column(name="IsCentralGovt")
	private Boolean isCentralGovt;
	
	@ManyToOne
	@JoinColumn(name="FK_State")
	@JsonIgnore
	private State state;

		public Integer getUniversityId() {
			return boardUniversityId;
		}
	
		public void setUniversityId(Integer boardUniversityId) {
			this.boardUniversityId = boardUniversityId;
		}
	
		public String getUniversityName() {
			return universityName;
		}
	
		public void setUniversityName(String universityName) {
			this.universityName = universityName;
		}
	
		public String getAddress() {
			return address;
		}
	
		public void setAddress(String address) {
			this.address = address;
		}
	
		public Boolean getIsCentralGovt() {
			return isCentralGovt;
		}
	
		public void setIsCentralGovt(Boolean isCentralGovt) {
			this.isCentralGovt = isCentralGovt;
		}
	
		public State getState() {
			return state;
		}
	
		public void setState(State state) {
			this.state = state;
		}
}
