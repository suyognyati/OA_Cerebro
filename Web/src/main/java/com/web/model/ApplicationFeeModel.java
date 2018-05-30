package com.web.model;

import java.util.List;

import com.data.entities.College;
import com.data.entities.University_Program;

public class ApplicationFeeModel {
	
	College college;
	University_Program program;
	List<FeeDetail> feeDetailList;
	Float vendorAmount;
	Float totalAmount;
	Integer applicationId;

		public College getCollege() {
			return college;
		}
		public void setCollege(College college) {
			this.college = college;
		}
		public University_Program getProgram() {
			return program;
		}
		public void setProgram(University_Program program) {
			this.program = program;
		}
		public List<FeeDetail> getFeeDetailList() {
			return feeDetailList;
		}
		public void setFeeDetailList(List<FeeDetail> feeDetailList) {
			this.feeDetailList = feeDetailList;
		}
		public Float getVendorAmount() {
			return vendorAmount;
		}
		public void setVendorAmount(Float vendorAmount) {
			this.vendorAmount = vendorAmount;
		}
		public Float getTotalAmount() {
			return totalAmount;
		}
		public void setTotalAmount(Float totalAmount) {
			this.totalAmount = totalAmount;
		}
		public Integer getApplicationId() {
			return applicationId;
		}
		public void setApplicationId(Integer applicationId) {
			this.applicationId = applicationId;
		}
	
	
	public class FeeDetail {
		private Integer feeId;
		private Integer programFeeId;
		private Float amount;
		private Boolean onlyForDisplayPurpose;
		private Integer year;
		private String displayTitle;
		private String feeHead;
		
		
			public Integer getFeeId() {
				return feeId;
			}
			public void setFeeId(Integer feeId) {
				this.feeId = feeId;
			}
			public Integer getProgramFeeId() {
				return programFeeId;
			}
			public void setProgramFeeId(Integer programFeeId) {
				this.programFeeId = programFeeId;
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
			public String getDisplayTitle() {
				return displayTitle;
			}
			public void setDisplayTitle(String displayTitle) {
				this.displayTitle = displayTitle;
			}
			public String getFeeHead() {
				return feeHead;
			}
			public void setFeeHead(String feeHead) {
				this.feeHead = feeHead;
			}		
	}
	

}
