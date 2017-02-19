package com.data.entities;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Where;

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
	
	@OneToMany(mappedBy = "state", fetch = FetchType.EAGER)
	@Where(clause = "ForSSC = 1")
	private List<Board> sscBoardList;
	
	@OneToMany(mappedBy = "state", fetch = FetchType.EAGER)
	@Where(clause = "ForHSC = 1")
	private List<Board> hscBoardList;
	
	@OneToMany(mappedBy = "state", fetch = FetchType.EAGER)
	@Where(clause = "ForDiploma = 1")
	private List<Board> diplomaBoardList;
	
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
		
		//Board List
		public List<Board> getSscBoardList() {
			return sscBoardList;
		}
		public void setSscBoardList(List<Board> sscBoardList) {
			this.sscBoardList = sscBoardList;
		}
		public List<Board> getHscBoardList() {
			return hscBoardList;
		}
		public void setHscBoardList(List<Board> hscBoardList) {
			this.hscBoardList = hscBoardList;
		}
		public List<Board> getDiplomaBoardList() {
			return diplomaBoardList;
		}
		public void setDiplomaBoardList(List<Board> diplomaBoardList) {
			this.diplomaBoardList = diplomaBoardList;
		}
		
		
	
}
