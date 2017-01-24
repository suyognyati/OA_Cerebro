package com.web.model;

import java.util.List;

public class EducationModel {
	
	public class Qualification {
		private String name;
		private Integer qualificationMainLevel;
		private List<SubQualification> subQualificationList;
		
			public String getName() {
				return name;
			}
			public void setName(String name) {
				this.name = name;
			}
			
			public Integer getQualificationMainLevel() {
				return qualificationMainLevel;
			}
			public void setQualificationMainLevel(Integer qualificationMainLevel) {
				this.qualificationMainLevel = qualificationMainLevel;
			}
			
			/**
			 * @return Sub list of main qualification
			 * */
			public List<SubQualification> getSubQualificationList() {
				return subQualificationList;
			}
			public void setSubQualificationList(List<SubQualification> subQualificationList) {
				this.subQualificationList = subQualificationList;
			}		
	}
	
	public class SubQualification {
		private String name;
		private String boardOrUniversity;
		public String facultyOrCollegeName;
		public String passingMonth;
		public Integer passingYear;
		public Integer marksObtain;
		public Integer totalMarks;
		
			public String getName() {
				return name;
			}
			public void setName(String name) {
				this.name = name;
			}
			public String getBoardOrUniversity() {
				return boardOrUniversity;
			}
			public void setBoardOrUniversity(String boardOrUniversity) {
				this.boardOrUniversity = boardOrUniversity;
			}
			public String getFacultyOrCollegeName() {
				return facultyOrCollegeName;
			}
			public void setFacultyOrCollegeName(String facultyOrCollegeName) {
				this.facultyOrCollegeName = facultyOrCollegeName;
			}
			public String getPassingMonth() {
				return passingMonth;
			}
			public void setPassingMonth(String passingMonth) {
				this.passingMonth = passingMonth;
			}
			public Integer getPassingYear() {
				return passingYear;
			}
			public void setPassingYear(Integer passingYear) {
				this.passingYear = passingYear;
			}
			public Integer getMarksObtain() {
				return marksObtain;
			}
			public void setMarksObtain(Integer marksObtain) {
				this.marksObtain = marksObtain;
			}
			public Integer getTotalMarks() {
				return totalMarks;
			}
			public void setTotalMarks(Integer totalMarks) {
				this.totalMarks = totalMarks;
			}		
	}
	
	/*private String state;
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
	
	
	*//**
	 * @return the state
	 *//*
	public String getState() {
		return state;
	}
	*//**
	 * @param state the state to set
	 *//*
	public void setState(String state) {
		this.state = state;
	}
	*//**
	 * @return the board
	 *//*
	public String getBoard() {
		return board;
	}
	*//**
	 * @param board the board to set
	 *//*
	public void setBoard(String board) {
		this.board = board;
	}
	*//**
	 * @return the schoolName
	 *//*
	public String getSchoolName() {
		return schoolName;
	}
	*//**
	 * @param schoolName the schoolName to set
	 *//*
	public void setSchoolName(String schoolName) {
		this.schoolName = schoolName;
	}
	*//**
	 * @return the schollPlace
	 *//*
	public String getSchoolPlace() {
		return schoolPlace;
	}
	*//**
	 * @param schollPlace the schollPlace to set
	 *//*
	public void setSchoolPlace(String schoolPlace) {
		this.schoolPlace = schoolPlace;
	}
	*//**
	 * @return the firstAttempt
	 *//*
	public int getFirstAttempt() {
		return firstAttempt;
	}
	*//**
	 * @param firstAttempt the firstAttempt to set
	 *//*
	public void setFirstAttempt(int firstAttempt) {
		this.firstAttempt = firstAttempt;
	}
	*//**
	 * @return the mathsType
	 *//*
	public int getMathsType() {
		return mathsType;
	}
	*//**
	 * @param mathsType the mathsType to set
	 *//*
	public void setMathsType(int mathsType) {
		this.mathsType = mathsType;
	}
	*//**
	 * @return the passingYear
	 *//*
	public String getPassingYear() {
		return passingYear;
	}
	*//**
	 * @param passingYear the passingYear to set
	 *//*
	public void setPassingYear(String passingYear) {
		this.passingYear = passingYear;
	}
	*//**
	 * @return the passingMonth
	 *//*
	public String getPassingMonth() {
		return passingMonth;
	}
	*//**
	 * @param passingMonth the passingMonth to set
	 *//*
	public void setPassingMonth(String passingMonth) {
		this.passingMonth = passingMonth;
	}
	*//**
	 * @return the totalMarksObtained
	 *//*
	public String getTotalMarksObtained() {
		return totalMarksObtained;
	}
	*//**
	 * @param totalMarksObtained the totalMarksObtained to set
	 *//*
	public void setTotalMarksObtained(String totalMarksObtained) {
		this.totalMarksObtained = totalMarksObtained;
	}
	*//**
	 * @return the outOfMarks
	 *//*
	public String getOutOfMarks() {
		return outOfMarks;
	}
	*//**
	 * @param outOfMarks the outOfMarks to set
	 *//*
	public void setOutOfMarks(String outOfMarks) {
		this.outOfMarks = outOfMarks;
	}
	*//**
	 * @return the gradeObtained
	 *//*
	public String getGradeObtained() {
		return gradeObtained;
	}
	*//**
	 * @param gradeObtained the gradeObtained to set
	 *//*
	public void setGradeObtained(String gradeObtained) {
		this.gradeObtained = gradeObtained;
	}
	*//**
	 * @return the seatNo
	 *//*
	public String getSeatNo() {
		return seatNo;
	}
	*//**
	 * @param seatNo the seatNo to set
	 *//*
	public void setSeatNo(String seatNo) {
		this.seatNo = seatNo;
	}*/
	
	
}
