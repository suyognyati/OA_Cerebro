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
	@Column(name="Id")
	private Integer id;
	
	@Column(name="Amount")
	private Float amount;
	
	@Column(name="OnlyForDisplayPurpose")
	private Boolean onlyForDisplayPurpose;
	
	@Column(name="Year")
	private Integer year;
	
	@ManyToOne
	@JoinColumn(name="FK_College")
	private College college;
	
	@ManyToOne
	@JoinColumn(name="FK_FeeType")
	private FeeType feeType;
	
	@ManyToOne
	@JoinColumn(name="FK_Program")
	private University_Program program;

		public Integer getId() {
			return id;
		}
	
		public void setId(Integer feeId) {
			this.id = feeId;
		}
	
		public Float getAmount() {
			return amount;
		}
	
		public void setAmount(Float amount) {
			this.amount = amount;
		}
	
		public Boolean getOnlyForDisplayPurpose() {
			return onlyForDisplayPurpose;
		}

		public void setOnlyForDisplayPurpose(Boolean onlyForDisplayPurpose) {
			this.onlyForDisplayPurpose = onlyForDisplayPurpose;
		}

		public Integer getYear() {
			return year;
		}

		public void setYear(Integer year) {
			this.year = year;
		}

		public College getCollege() {
			return college;
		}

		public void setCollege(College college) {
			this.college = college;
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
