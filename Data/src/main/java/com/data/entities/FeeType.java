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
	@Column(name="Id")
	private Integer id;
	
	@Column(name="FeeHead")
	private String feeHead;
	
	@Column(name="DisplayTitle")
	private String displayTitle;

		public Integer getId() {
			return id;
		}
	
		public void setId(Integer feeTypeId) {
			this.id = feeTypeId;
		}
	
		public String getFeeHead() {
			return feeHead;
		}
	
		public void setFeeHead(String feeTypeName) {
			this.feeHead = feeTypeName;
		}

		public String getDisplayTitle() {
			return displayTitle;
		}

		public void setDisplayTitle(String displayTitle) {
			this.displayTitle = displayTitle;
		}		
		
}
