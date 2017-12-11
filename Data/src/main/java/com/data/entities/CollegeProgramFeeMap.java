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
@Table(name="CollegeProgramFeeMap")
public class CollegeProgramFeeMap {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="CollegeFeeId")
	private Integer feeId;
	
	@Column(name="Amount")
	private Integer amount;
	
	@Column(name="Year")
	private Integer year;
	
	@ManyToOne
	@JoinColumn(name="FK_FeeType")
	private FeeType feeType;
	
	@ManyToOne
	@JoinColumn(name="FK_Program")
	private University_Program program;

		public Integer getFeeId() {
			return feeId;
		}
	
		public void setFeeId(Integer feeId) {
			this.feeId = feeId;
		}
	
		public Integer getAmount() {
			return amount;
		}
	
		public void setAmount(Integer amount) {
			this.amount = amount;
		}
	
		public Integer getYear() {
			return year;
		}

		public void setYear(Integer year) {
			this.year = year;
		}

		public FeeType getFeeType() {
			return feeType;
		}
	
		public void setFeeType(FeeType feeType) {
			this.feeType = feeType;
		}
	
		public University_Program getProgram() {
			return program;
		}
	
		public void setProgram(University_Program program) {
			this.program = program;
		}
}
