package com.data.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="Board")
public class Board {
	@Id
	@Column(name="BoardId")
	private Integer boardId;
	
	@Column(name="BoardName")
	private String boardName;
	
	@Column(name="BoardCode")
	private Integer boardCode;
	
	@Column(name="ForSSC")
	Boolean forSSC;
	
	@Column(name="ForHSC")
	Boolean forHSC;
	
	@Column(name="ForDiploma")
	Boolean forDiploma;
	
	@ManyToOne
	@JoinColumn(name="FK_State")
	@JsonIgnore
	private State state;

		public Integer getBoardId() {
			return boardId;
		}	
		public void setBoardId(Integer boardId) {
			this.boardId = boardId;
		}
	
		public String getBoardName() {
			return boardName;
		}	
		public void setBoardName(String boardName) {
			this.boardName = boardName;
		}
	
		public Integer getBoardCode() {
			return boardCode;
		}	
		public void setBoardCode(Integer boardCode) {
			this.boardCode = boardCode;
		}
		
		public Boolean getForSSC() {
			return forSSC;
		}
		public void setForSSC(Boolean forSSC) {
			this.forSSC = forSSC;
		}
		
		public Boolean getForHSC() {
			return forHSC;
		}
		public void setForHSC(Boolean forHSC) {
			this.forHSC = forHSC;
		}
		
		public Boolean getForDiploma() {
			return forDiploma;
		}
		public void setForDiploma(Boolean forDiploma) {
			this.forDiploma = forDiploma;
		}
		
		public State getState() {
			return state;
		}	
		public void setState(State state) {
			this.state = state;
		}
}
