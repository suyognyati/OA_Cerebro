package com.data.entities;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.data.entities.Enums.FirstAttemptType;
import com.data.entities.Enums.MathsTypeType;

@Entity
@Table(name="EducationalInformation")
public class EducationalInformation {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="EducationInformationId")
	private int educationInformationId;
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="FK_UserId")
	private UserDetail userDetail;

	@Column(name="State")
	private String state;

	@Column(name="Board")
	private String board;

	@Column(name="SchoolName")
	private String schoolName;

	@Column(name="SchoolPlace")
	private String schoolPlace;

	@Column(name="FirstAttempt")
	private int firstAttempt;

	@Column(name="MathsType")
	private int mathsType;

	@Column(name="PassingYear")
	private String passingYear;

	@Column(name="PassingMonth")
	private String passingMonth;

	@Column(name="TotalMarksObtained")
	private String totalMarksObtained;

	@Column(name="OutOfMarks")
	private String outOfMarks;

	@Column(name="GradeObtained")
	private String gradeObtained;

	@Column(name="SeatNo")
	private String seatNo;
	
	//EducationInformationId
	public int getEducationInformationId() {
		return educationInformationId;
	}
	public void setEducationInformationId(final int educationInformationId) {
		this.educationInformationId = educationInformationId;
	}
	
	//UserId
	public UserDetail getUserId() {
		return userDetail;
	}
	public void setUserId(final UserDetail userId) {
		this.userDetail = userId;
	}
	
	//State
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	
	//Board
	public String getBoard() {
		return board;
	}
	public void setBoard(String board) {
		this.board = board;
	}
	
	//SchoolName
	public String getSchoolName() {
		return schoolName;
	}
	public void setSchoolName(String schoolName) {
		this.schoolName = schoolName;
	}
	
	//SchoolPlace
	public String getSchoolPlace() {
		return schoolPlace;
	}
	public void setSchoolPlace(String schoolPlace) {
		this.schoolPlace = schoolPlace;
	}
	
	//FirstAttempt
	public FirstAttemptType getFirstAttempt() {
		FirstAttemptType firstAttempt = Enums.FirstAttemptTypes[this.firstAttempt - 1];
		return firstAttempt;
	}
	public void setFirstAttempt(final FirstAttemptType firstAttempt) {
		this.firstAttempt = firstAttempt.getValue();
	}
	
	//MathsType
	public MathsTypeType getMathsType() {
		MathsTypeType mathsType = Enums.MathsTypeTypes[this.mathsType - 1];
		return mathsType;
	}
	public void setMathsType(final MathsTypeType mathsType) {
		this.mathsType = mathsType.getValue();
	}
	
	//PassingYear
	public String getPassingYear() {
		return passingYear;
	}
	public void setPassingYear(String passingYear) {
		this.passingYear = passingYear;
	}
	
	//PassingMonth
	public String getPassingMonth() {
		return passingMonth;
	}
	public void setPassingMonth(String passingMonth) {
		this.passingMonth = passingMonth;
	}
	
	//TotalMarksObtained
	public String getTotalMarksObtained() {
		return totalMarksObtained;
	}
	public void setTotalMarksObtained(String totalMarksObtained) {
		this.totalMarksObtained = totalMarksObtained;
	}
	
	//OutOfMarks
	public String getOutOfMarks() {
		return outOfMarks;
	}
	public void setOutOfMarks(String outOfMarks) {
		this.outOfMarks = outOfMarks;
	}
	
	//GradeObtained
	public String getGradeObtained() {
		return gradeObtained;
	}
	public void setGradeObtained(String gradeObtained) {
		this.gradeObtained = gradeObtained;
	}
	
	//SeatNo
	public String getSeatNo() {
		return seatNo;
	}
	public void setSeatNo(String seatNo) {
		this.seatNo = seatNo;
	}
	
	
}
