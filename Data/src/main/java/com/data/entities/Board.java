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
	
		public State getState() {
			return state;
		}	
		public void setState(State state) {
			this.state = state;
		}
}
