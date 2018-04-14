package com.web.model;

import java.util.List;

import com.data.entities.Enums;
import com.data.poco.AppliedStudentPOCO;

public class GenerateMeritListModel {

	private String programCode;
	private String programName;
	private List<AppliedStudentPOCO> appliedStudentList;
	private List<Enums.KeyValuePair> reservationList;
	
	
	public String getProgramCode() {
		return programCode;
	}
	public void setProgramCode(String programCode) {
		this.programCode = programCode;
	}
	
	public String getProgramName() {
		return programName;
	}
	public void setProgramName(String programName) {
		this.programName = programName;
	}
	
	public List<Enums.KeyValuePair> getReservationList() {
		return reservationList;
	}
	public List<AppliedStudentPOCO> getAppliedStudentList() {
		return appliedStudentList;
	}
	
	public void setAppliedStudentList(List<AppliedStudentPOCO> appliedStudentList) {
		this.appliedStudentList = appliedStudentList;
	}
	public void setReservationList(List<Enums.KeyValuePair> reservationList) {
		this.reservationList = reservationList;
	}	
	
}
