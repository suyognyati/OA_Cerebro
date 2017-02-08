package com.web.model;

import java.util.ArrayList;
import java.util.List;

import com.data.entities.Country;
import com.data.entities.Enums;
import com.data.entities.Enums.KeyValuePair;
import com.data.entities.State;

public class EducationModel {
	
	private QualificationDetail qualificationDetail;
	
	public QualificationDetail getQualificationDetail() {
		return qualificationDetail;
	}

	public void setQualificationDetail(QualificationDetail qualificationDetail) {
		this.qualificationDetail = qualificationDetail;
	}

	public class Qualification {
		private String name;
		private Integer qualificationMainLevel;
		private Integer qualificationSubLevel;
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
			
			public Integer getQualificationSubLevel() {
				qualificationSubLevel = 0;
				return qualificationSubLevel;
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
		public Integer qualificationMainLevel;
		public Integer qualificationSubLevel;
		
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
			public Integer getQualificationMainLevel() {
				return qualificationMainLevel;
			}
			public void setQualificationMainLevel(Integer qualificationMainLevel) {
				this.qualificationMainLevel = qualificationMainLevel;
			}
			public Integer getQualificationSubLevel() {
				return qualificationSubLevel;
			}
			public void setQualificationSubLevel(Integer qualificationSubLevel) {
				this.qualificationSubLevel = qualificationSubLevel;
			}
	}
	
	public class QualificationDetail {
		private String country;
		private State state;
		private Integer nameOfBoard;
		private Integer nameOfUniversity;
		private String foreignBody_AreaStdCodePhone;
		private String foreignBody_EmailId;
		private String foreignBody_URL;
		private Integer resultStatus;
		private Integer stream;
		private Integer noOfAttempts;
		private String qualificationName;
		private String specialSubject;
		private String otherBodyName;
		private String schoolCollegeAddress;
		private Integer certifyingBody;
		private Boolean isLocalBody;
		private String schoolCollegeName;
		private Integer passingMonth;
		private Integer passingYear;
		private String examSeatNo;
		private String marksheetNo;
		private Integer evaluationType;
		private Integer marksObtain;
		private Integer totalMarks;
		private Float percentage;
		private String grade;
		private Integer cgpa;
		private Integer qualificationMainLevel;
		private Integer qualificationSubLevel;
		private List<Enums.KeyValuePair> resultStatusList;
		private List<Enums.KeyValuePair> certifyingBodyList;
		private List<Enums.KeyValuePair> monthList;
		private List<Integer> yearList;
		private List<Country> countryList;
		private List<State> stateList;
		
			public String getCountry() {
				return country;
			}
			public void setCountry(String country) {
				this.country = country;
			}
			public State getState() {
				return state;
			}
			public void setState(State state) {
				this.state = state;
			}
			public Integer getNameOfBoard() {
				return nameOfBoard;
			}
			public void setNameOfBoard(Integer nameOfBoard) {
				this.nameOfBoard = nameOfBoard;
			}
			public Integer getNameOfUniversity() {
				return nameOfUniversity;
			}
			public void setNameOfUniversity(Integer nameOfUniversity) {
				this.nameOfUniversity = nameOfUniversity;
			}
			public String getForeignBody_AreaStdCodePhone() {
				return foreignBody_AreaStdCodePhone;
			}
			public void setForeignBody_AreaStdCodePhone(String foreignBody_AreaStdCodePhone) {
				this.foreignBody_AreaStdCodePhone = foreignBody_AreaStdCodePhone;
			}
			public String getForeignBody_EmailId() {
				return foreignBody_EmailId;
			}
			public void setForeignBody_EmailId(String foreignBody_EmailId) {
				this.foreignBody_EmailId = foreignBody_EmailId;
			}
			public String getForeignBody_URL() {
				return foreignBody_URL;
			}
			public void setForeignBody_URL(String foreignBody_URL) {
				this.foreignBody_URL = foreignBody_URL;
			}
			public Integer getResultStatus() {
				return resultStatus;
			}
			public void setResultStatus(Integer resultStatus) {
				this.resultStatus = resultStatus;
			}
			public Integer getStream() {
				return stream;
			}
			public void setStream(Integer stream) {
				this.stream = stream;
			}
			public Integer getNoOfAttempts() {
				return noOfAttempts;
			}
			public void setNoOfAttempts(Integer noOfAttempts) {
				this.noOfAttempts = noOfAttempts;
			}
			public String getQualificationName() {
				return qualificationName;
			}
			public void setQualificationName(String qualificationName) {
				this.qualificationName = qualificationName;
			}
			public String getSpecialSubject() {
				return specialSubject;
			}
			public void setSpecialSubject(String specialSubject) {
				this.specialSubject = specialSubject;
			}
			public String getOtherBodyName() {
				return otherBodyName;
			}
			public void setOtherBodyName(String otherBodyName) {
				this.otherBodyName = otherBodyName;
			}
			public String getSchoolCollegeAddress() {
				return schoolCollegeAddress;
			}
			public void setSchoolCollegeAddress(String schoolCollegeAddress) {
				this.schoolCollegeAddress = schoolCollegeAddress;
			}
			public Integer getCertifyingBody() {
				return certifyingBody;
			}
			public void setCertifyingBody(Integer certifyingBody) {
				this.certifyingBody = certifyingBody;
			}
			public Boolean getIsLocalBody() {
				return isLocalBody != null ? isLocalBody : true;
			}
			public void setIsLocalBody(Boolean isLocalBody) {
				this.isLocalBody = isLocalBody;
			}
			public String getSchoolCollegeName() {
				return schoolCollegeName;
			}
			public void setSchoolCollegeName(String schoolCollegeName) {
				this.schoolCollegeName = schoolCollegeName;
			}
			public Integer getPassingMonth() {
				return passingMonth;
			}
			public void setPassingMonth(Integer passingMonth) {
				this.passingMonth = passingMonth;
			}
			public Integer getPassingYear() {
				return passingYear;
			}
			public void setPassingYear(Integer passingYear) {
				this.passingYear = passingYear;
			}
			public String getExamSeatNo() {
				return examSeatNo;
			}
			public void setExamSeatNo(String examSeatNo) {
				this.examSeatNo = examSeatNo;
			}
			public String getMarksheetNo() {
				return marksheetNo;
			}
			public void setMarksheetNo(String marksheetNo) {
				this.marksheetNo = marksheetNo;
			}
			public Integer getEvaluationType() {
				return evaluationType != null ? evaluationType : 1;
			}
			public void setEvaluationType(Integer evaluationType) {
				this.evaluationType = evaluationType;
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
			public Float getPercentage() {
				return percentage;
			}
			public void setPercentage(Float percentage) {
				this.percentage = percentage;
			}
			public String getGrade() {
				return grade;
			}
			public void setGrade(String grade) {
				this.grade = grade;
			}
			public Integer getCgpa() {
				return cgpa;
			}
			public void setCgpa(Integer cgpa) {
				this.cgpa = cgpa;
			}
			public Integer getQualificationMainLevel() {
				return qualificationMainLevel;
			}
			public void setQualificationMainLevel(Integer qualificationMainLevel) {
				this.qualificationMainLevel = qualificationMainLevel;
			}
			public Integer getQualificationSubLevel() {
				return qualificationSubLevel;
			}
			public void setQualificationSubLevel(Integer qualificationSubLevel) {
				this.qualificationSubLevel = qualificationSubLevel;
			}
			public List<KeyValuePair> getResultStatusList() {
				return resultStatusList;
			}
			public void setResultStatusList(List<KeyValuePair> resultStatusList) {
				this.resultStatusList = resultStatusList;
			}
			public List<KeyValuePair> getCertifyingBodyList() {
				return certifyingBodyList;
			}
			public void setCertifyingBodyList(List<KeyValuePair> certifyingBodyList) {
				this.certifyingBodyList = certifyingBodyList;
			}
			public List<KeyValuePair> getMonthList() {
				return monthList;
			}
			public void setMonthList(List<KeyValuePair> monthList) {
				this.monthList = monthList;
			}
			public List<Integer> getYearList() {
				return yearList;
			}
			public void setYearListRange(Integer currentYear) {
				List<Integer> yearList = new ArrayList<Integer>();
				for(int i = 1965; i <= currentYear; i++) {
					yearList.add(i);
				}
				this.yearList = yearList;
			}
			public List<Country> getCountryList() {
				return countryList;
			}
			public void setCountryList(List<Country> countryList) {
				this.countryList = countryList;
			}
			public List<State> getStateList() {
				return stateList;
			}
			public void setStateList(List<State> stateList) {
				this.stateList = stateList;
			}
	}
}
