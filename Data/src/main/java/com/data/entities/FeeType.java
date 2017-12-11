package com.data.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="FeeType")
public class FeeType {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="FeeTypeId")
	private Integer feeTypeId;
	
	@Column(name="FeeTypeName")
	private String feeTypeName;

		public Integer getFeeTypeId() {
			return feeTypeId;
		}
	
		public void setFeeTypeId(Integer feeTypeId) {
			this.feeTypeId = feeTypeId;
		}
	
		public String getFeeTypeName() {
			return feeTypeName;
		}
	
		public void setFeeTypeName(String feeTypeName) {
			this.feeTypeName = feeTypeName;
		}
}
