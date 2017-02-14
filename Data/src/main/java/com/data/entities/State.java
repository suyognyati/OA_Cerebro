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
	private List<Board> boardList;
	
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
		public List<Board> getBoardList() {
			return boardList;
		}
		public void setBoardList(List<Board> boardList) {
			this.boardList = boardList;
		}
	
}
