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
@Table(name="CollegeFeeDetail")
public class CollegeFeeDetail {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="FeeDetailId")
	private Integer feeDetailId;
	
	@Column(name="FeeHead")
	private String feeHead;
	
	@ManyToOne
	@JoinColumn(name="FK_CollegeProgramFee")
	private CollegeProgramFeeMap collegeProgramFee;

		public Integer getFeeDetailId() {
			return feeDetailId;
		}
	
		public void setFeeDetailId(Integer feeDetailId) {
			this.feeDetailId = feeDetailId;
		}
	
		public String getFeeHead() {
			return feeHead;
		}
	
		public void setFeeHead(String feeHead) {
			this.feeHead = feeHead;
		}
	
		public CollegeProgramFeeMap getCollegeProgramFee() {
			return collegeProgramFee;
		}
	
		public void setCollegeProgramFee(CollegeProgramFeeMap collegeProgramFee) {
			this.collegeProgramFee = collegeProgramFee;
		}
}
