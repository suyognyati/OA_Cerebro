package com.data.entities;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.data.entities.Enums.FirstAttemptType;
import com.data.entities.Enums.MathsTypeType;

@Entity
@Table(name="EducationalInformation")
public class EducationalInformation {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int EducationInformationId;
	@OneToOne(cascade=CascadeType.ALL)
	private BasicDetail UserId;
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
	
	//EducationInformationId
	public int getEducationInformationId() {
		return EducationInformationId;
	}
	public void setEducationInformationId(final int educationInformationId) {
		EducationInformationId = educationInformationId;
	}
	
	//UserId
	public BasicDetail getUserId() {
		return UserId;
	}
	public void setUserId(final BasicDetail userId) {
		UserId = userId;
	}
	
	//State
	public String getState() {
		return State;
	}
	public void setState(String state) {
		State = state;
	}
	
	//Board
	public String getBoard() {
		return Board;
	}
	public void setBoard(String board) {
		Board = board;
	}
	
	//SchoolName
	public String getSchoolName() {
		return SchoolName;
	}
	public void setSchoolName(String schoolName) {
		SchoolName = schoolName;
	}
	
	//SchoolPlace
	public String getSchoolPlace() {
		return SchoolPlace;
	}
	public void setSchoolPlace(String schoolPlace) {
		SchoolPlace = schoolPlace;
	}
	
	//FirstAttempt
	public FirstAttemptType getFirstAttempt() {
		FirstAttemptType firstAttempt = Enums.FirstAttemptTypes[this.FirstAttempt - 1];
		return firstAttempt;
	}
	public void setFirstAttempt(final FirstAttemptType firstAttempt) {
		this.FirstAttempt = firstAttempt.getValue();
	}
	
	//MathsType
	public MathsTypeType getMathsType() {
		MathsTypeType mathsType = Enums.MathsTypeTypes[this.MathsType - 1];
		return mathsType;
	}
	public void setMathsType(final MathsTypeType mathsType) {
		this.MathsType = mathsType.getValue();
	}
	
	//PassingYear
	public String getPassingYear() {
		return PassingYear;
	}
	public void setPassingYear(String passingYear) {
		PassingYear = passingYear;
	}
	
	//PassingMonth
	public String getPassingMonth() {
		return PassingMonth;
	}
	public void setPassingMonth(String passingMonth) {
		PassingMonth = passingMonth;
	}
	
	//TotalMarksObtained
	public String getTotalMarksObtained() {
		return TotalMarksObtained;
	}
	public void setTotalMarksObtained(String totalMarksObtained) {
		TotalMarksObtained = totalMarksObtained;
	}
	
	//OutOfMarks
	public String getOutOfMarks() {
		return OutOfMarks;
	}
	public void setOutOfMarks(String outOfMarks) {
		OutOfMarks = outOfMarks;
	}
	
	//GradeObtained
	public String getGradeObtained() {
		return GradeObtained;
	}
	public void setGradeObtained(String gradeObtained) {
		GradeObtained = gradeObtained;
	}
	
	//SeatNo
	public String getSeatNo() {
		return SeatNo;
	}
	public void setSeatNo(String seatNo) {
		SeatNo = seatNo;
	}
	
	
}
