package com.web.model;

import java.util.List;

import com.data.entities.Enums;

public class GenerateMeritListModel {

	private Integer formNo;
	private String studentName;
	private String category;
	private Float marksObtain;
	private Integer totalMarks;
	private List<Enums.KeyValuePair> reservationList;
	
	
	public Integer getFormNo() {
		return formNo;
	}
	public void setFormNo(Integer formNo) {
		this.formNo = formNo;
	}
	
	public String getStudentName() {
		return studentName;
	}
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}
	
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	
	public Float getMarksObtain() {
		return marksObtain;
	}
	public void setMarksObtain(Float marksObtain) {
		this.marksObtain = marksObtain;
	}
	
	public Integer getTotalMarks() {
		return totalMarks;
	}
	public void setTotalMarks(Integer totalMarks) {
		this.totalMarks = totalMarks;
	}
	
	public List<Enums.KeyValuePair> getReservationList() {
		return reservationList;
	}
	public void setReservationList(List<Enums.KeyValuePair> reservationList) {
		this.reservationList = reservationList;
	}	
	
}
