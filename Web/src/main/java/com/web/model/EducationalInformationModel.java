package com.web.model;

import com.data.entities.Enums;
import com.data.entities.Enums.FirstAttemptType;
import com.data.entities.Enums.MathsTypeType;

public class EducationalInformationModel {
	private String state;
	private String board;
	private String schoolName;
	private String schoolPlace;
	private int firstAttempt;
	private int mathsType;
	private String passingYear;
	private String passingMonth;
	private String totalMarksObtained;
	private String outOfMarks;
	private String gradeObtained;
	private String seatNo;
	
	
	/**
	 * @return the state
	 */
	public String getState() {
		return state;
	}
	/**
	 * @param state the state to set
	 */
	public void setState(String state) {
		this.state = state;
	}
	/**
	 * @return the board
	 */
	public String getBoard() {
		return board;
	}
	/**
	 * @param board the board to set
	 */
	public void setBoard(String board) {
		this.board = board;
	}
	/**
	 * @return the schoolName
	 */
	public String getSchoolName() {
		return schoolName;
	}
	/**
	 * @param schoolName the schoolName to set
	 */
	public void setSchoolName(String schoolName) {
		this.schoolName = schoolName;
	}
	/**
	 * @return the schollPlace
	 */
	public String getSchoolPlace() {
		return schoolPlace;
	}
	/**
	 * @param schollPlace the schollPlace to set
	 */
	public void setSchoolPlace(String schoolPlace) {
		this.schoolPlace = schoolPlace;
	}
	/**
	 * @return the firstAttempt
	 */
	public FirstAttemptType getFirstAttempt() {
		FirstAttemptType firstAttempt = Enums.FirstAttemptTypes[this.firstAttempt - 1];
		return firstAttempt;
	}
	/**
	 * @param firstAttempt the firstAttempt to set
	 */
	public void setFirstAttempt(FirstAttemptType firstAttempt) {
		this.firstAttempt = firstAttempt.getValue();
	}
	/**
	 * @return the mathsType
	 */
	public MathsTypeType getMathsType() {
		MathsTypeType mathsType = Enums.MathsTypeTypes[this.mathsType - 1];
		return mathsType;
	}
	/**
	 * @param mathsType the mathsType to set
	 */
	public void setMathsType(MathsTypeType mathsType) {
		this.mathsType = mathsType.getValue();
	}
	/**
	 * @return the passingYear
	 */
	public String getPassingYear() {
		return passingYear;
	}
	/**
	 * @param passingYear the passingYear to set
	 */
	public void setPassingYear(String passingYear) {
		this.passingYear = passingYear;
	}
	/**
	 * @return the passingMonth
	 */
	public String getPassingMonth() {
		return passingMonth;
	}
	/**
	 * @param passingMonth the passingMonth to set
	 */
	public void setPassingMonth(String passingMonth) {
		this.passingMonth = passingMonth;
	}
	/**
	 * @return the totalMarksObtained
	 */
	public String getTotalMarksObtained() {
		return totalMarksObtained;
	}
	/**
	 * @param totalMarksObtained the totalMarksObtained to set
	 */
	public void setTotalMarksObtained(String totalMarksObtained) {
		this.totalMarksObtained = totalMarksObtained;
	}
	/**
	 * @return the outOfMarks
	 */
	public String getOutOfMarks() {
		return outOfMarks;
	}
	/**
	 * @param outOfMarks the outOfMarks to set
	 */
	public void setOutOfMarks(String outOfMarks) {
		this.outOfMarks = outOfMarks;
	}
	/**
	 * @return the gradeObtained
	 */
	public String getGradeObtained() {
		return gradeObtained;
	}
	/**
	 * @param gradeObtained the gradeObtained to set
	 */
	public void setGradeObtained(String gradeObtained) {
		this.gradeObtained = gradeObtained;
	}
	/**
	 * @return the seatNo
	 */
	public String getSeatNo() {
		return seatNo;
	}
	/**
	 * @param seatNo the seatNo to set
	 */
	public void setSeatNo(String seatNo) {
		this.seatNo = seatNo;
	}
	
	
}
