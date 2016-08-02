package com.data.entities;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="EducationalInformation")
public class EducationalInformation {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int EducationInformationId;
	@OneToOne(cascade=CascadeType.ALL)
	private User UserId;
	private String State;
	private String Board;
	private String SchoolName;
	private String SchoolPlace;
	private int FirstAttempt;
	private int MathsType;
	private String PassingYear;
	private String PassingMonth;
	private String TotalMarksObtained;
	private String OutOfMarks;
	private String GradeObtained;
	private String SeatNo;
	
	public int getEducationInformationId() {
		return EducationInformationId;
	}
	public void setEducationInformationId(int educationInformationId) {
		EducationInformationId = educationInformationId;
	}
	public User getUserId() {
		return UserId;
	}
	public void setUserId(User userId) {
		UserId = userId;
	}
	public String getState() {
		return State;
	}
	public void setState(String state) {
		State = state;
	}
	public String getBoard() {
		return Board;
	}
	public void setBoard(String board) {
		Board = board;
	}
	public String getSchoolName() {
		return SchoolName;
	}
	public void setSchoolName(String schoolName) {
		SchoolName = schoolName;
	}
	public String getSchoolPlace() {
		return SchoolPlace;
	}
	public void setSchoolPlace(String schoolPlace) {
		SchoolPlace = schoolPlace;
	}
	public int getFirstAttempt() {
		return FirstAttempt;
	}
	public void setFirstAttempt(int firstAttempt) {
		FirstAttempt = firstAttempt;
	}
	public int getMathsType() {
		return MathsType;
	}
	public void setMathsType(int mathsType) {
		MathsType = mathsType;
	}
	public String getPassingYear() {
		return PassingYear;
	}
	public void setPassingYear(String passingYear) {
		PassingYear = passingYear;
	}
	public String getPassingMonth() {
		return PassingMonth;
	}
	public void setPassingMonth(String passingMonth) {
		PassingMonth = passingMonth;
	}
	public String getTotalMarksObtained() {
		return TotalMarksObtained;
	}
	public void setTotalMarksObtained(String totalMarksObtained) {
		TotalMarksObtained = totalMarksObtained;
	}
	public String getOutOfMarks() {
		return OutOfMarks;
	}
	public void setOutOfMarks(String outOfMarks) {
		OutOfMarks = outOfMarks;
	}
	public String getGradeObtained() {
		return GradeObtained;
	}
	public void setGradeObtained(String gradeObtained) {
		GradeObtained = gradeObtained;
	}
	public String getSeatNo() {
		return SeatNo;
	}
	public void setSeatNo(String seatNo) {
		SeatNo = seatNo;
	}
	
	
}
