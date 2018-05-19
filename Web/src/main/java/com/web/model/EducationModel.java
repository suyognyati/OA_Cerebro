package com.web.model;

import java.util.ArrayList;
import java.util.List;

import com.data.entities.Board;
import com.data.entities.Country;
import com.data.entities.Enums;
import com.data.entities.Enums.KeyValuePair;
import com.data.entities.QualificationProgram;
import com.data.entities.QualificationLevel;
import com.data.entities.State;
import com.data.entities.University;

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
		private Integer qualificationGroup;
		private Integer qualificationGroupLevel;
		private Integer qualificationGroupLevelCount;
		private Boolean isMultireferedAvailableUnderQualificationGroup;
		private List<SubQualification> subQualificationList;
		private Boolean areAllQualificationAdded;
		
			public String getName() {
				return name;
			}
			public void setName(String name) {
				this.name = name;
			}
			
			public Integer getQualificationGroup() {
				return qualificationGroup;
			}
			public void setQualificationGroup(Integer qualificationGroup) {
				this.qualificationGroup = qualificationGroup;
			}
			
			public Integer getQualificationGroupLevel() {
				qualificationGroupLevel = 0;
				return qualificationGroupLevel;
			}

			public Integer getQualificationGroupLevelCount() {
				return qualificationGroupLevelCount;
			}
			public void setQualificationGroupLevelCount(Integer qualificationGroupLevelCount) {
				this.qualificationGroupLevelCount = qualificationGroupLevelCount;
			}			

			public Boolean getIsMultireferedAvailableUnderQualificationGroup() {
				return isMultireferedAvailableUnderQualificationGroup;
			}
			public void setIsMultireferedAvailableUnderQualificationGroup(Boolean isMultireferedAvailableUnderQualificationGroup) {
				this.isMultireferedAvailableUnderQualificationGroup = isMultireferedAvailableUnderQualificationGroup;
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
			
			public Boolean getAreAllQualificationAdded() {
				return areAllQualificationAdded;
			}
			public void setAreAllQualificationAdded(Boolean areAllQualificationAdded) {
				this.areAllQualificationAdded = areAllQualificationAdded;
			}
			
	}
	
	public class SubQualification {
		private Integer subQualificationId;
		private String name;
		private String boardOrUniversity;
		public String facultyOrCollegeName;
		public String passingMonth;
		public Integer passingYear;
		public Integer marksObtain;
		public Integer totalMarks;
		public Integer qualificationGroup;
		public Integer qualificationGroupLevel;
		public QualificationLevel qualificationLevel;
		public QualificationProgram qualificationProgram;
		
			public Integer getSubQualificationId() {
				return subQualificationId;
			}
			public void setSubQualificationId(Integer subQualificationId) {
				this.subQualificationId = subQualificationId;
			}
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
			public Integer getQualificationGroup() {
				return qualificationGroup;
			}
			public void setQualificationGroup(Integer qualificationGroup) {
				this.qualificationGroup = qualificationGroup;
			}
			public Integer getQualificationGroupLevel() {
				return qualificationGroupLevel;
			}
			public void setQualificationGroupLevel(Integer qualificationGroupLevel) {
				this.qualificationGroupLevel = qualificationGroupLevel;
			}
			public QualificationLevel getQualificationLevel() {
				return qualificationLevel;
			}
			public void setQualificationLevel(QualificationLevel qualificationLevel) {
				this.qualificationLevel = qualificationLevel;
			}
			public QualificationProgram getQualificationProgram() {
				return qualificationProgram;
			}
			public void setQualificationProgram(QualificationProgram qualificationProgram) {
				this.qualificationProgram = qualificationProgram;
			}
	}
	
	public class QualificationDetail {
		private Integer qualificationId;
		private Country country;
		private State state;
		private Board board;
		private University university;
		private String foreignBody_BoardUniversityName;
		private String foreignBody_AreaStdCodePhone;
		private String foreignBody_EmailId;
		private String foreignBody_URL;
		private Integer resultStatus;
		private Integer stream;
		private Integer noOfAttempts;
		private Integer academicYear;
		private String qualificationName;
		private String specialSubject;
		private String otherBodyName;
		private String schoolCollegeAddress;
		private Integer certifyingBody;
		private Integer isLocalBody;
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
		private Float cgpa;
		private Integer qualificationGroup;
		private Integer qualificationGroupLevel;
		private QualificationLevel qualificationLevel;
		private QualificationProgram qualificationProgram;
		private List<Enums.KeyValuePair> resultStatusList;
		private List<Enums.KeyValuePair> certifyingBodyList;
		private List<Enums.KeyValuePair> monthList;
		private List<Enums.KeyValuePair> streamList;
		private List<Enums.KeyValuePair> academicYearList;
		private List<Integer> yearList;
		private List<Country> countryList;
		private List<State> stateList;
		private List<Board> allIndiaBoardList;
		private List<QualificationLevel> qualificationGroupLevelList;
		private List<QualificationProgram> qualificationProgramList;
		
			
			public Integer getQualificationId() {
				return qualificationId;
			}
			public void setQualificationId(Integer qualificationId) {
				this.qualificationId = qualificationId;
			}
			public Country getCountry() {
				return country;
			}
			public void setCountry(Country country) {
				this.country = country;
			}
			public State getState() {
				return state;
			}
			public void setState(State state) {
				this.state = state;
			}
			public Board getBoard() {
				return board;
			}
			public void setBoard(Board board) {
				this.board = board;
			}
			public University getUniversity() {
				return university;
			}
			public void setUniversity(University university) {
				this.university = university;
			}
			public String getForeignBody_BoardUniversityName() {
				return foreignBody_BoardUniversityName;
			}
			public void setForeignBody_BoardUniversityName(String foreignBody_BoardUniversityName) {
				this.foreignBody_BoardUniversityName = foreignBody_BoardUniversityName;
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
				return resultStatus != null ? resultStatus : 1;
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
			public Integer getAcademicYear() {
				return academicYear;
			}
			public void setAcademicYear(Integer academicYear) {
				this.academicYear = academicYear;
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
			public Integer getIsLocalBody() {
				return isLocalBody != null ? isLocalBody : 1;
			}
			public void setIsLocalBody(Integer isLocalBody) {
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
			public Float getCgpa() {
				return cgpa;
			}
			public void setCgpa(Float cgpa) {
				this.cgpa = cgpa;
			}
			public Integer getQualificationGroup() {
				return qualificationGroup;
			}
			public void setQualificationGroup(Integer qualificationGroup) {
				this.qualificationGroup = qualificationGroup;
			}
			public Integer getQualificationGroupLevel() {
				return qualificationGroupLevel;
			}
			public void setQualificationGroupLevel(Integer qualificationGroupLevel) {
				this.qualificationGroupLevel = qualificationGroupLevel;
			}
			public QualificationLevel getQualificationLevel() {
				return qualificationLevel;
			}
			public void setQualificationLevel(QualificationLevel qualificationLevel) {
				this.qualificationLevel = qualificationLevel;
			}
			public QualificationProgram getQualificationProgram() {
				return qualificationProgram;
			}
			public void setQualificationProgram(QualificationProgram qualificationProgram) {
				this.qualificationProgram = qualificationProgram;
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
			public List<Enums.KeyValuePair> getStreamList() {
				return streamList;
			}
			public void setStreamList(List<Enums.KeyValuePair> streamList) {
				this.streamList = streamList;
			}
			public List<Enums.KeyValuePair> getAcademicYearList() {
				return academicYearList;
			}
			public void setAcademicYearList(List<Enums.KeyValuePair> academicYearList) {
				this.academicYearList = academicYearList;
			}
			public List<Integer> getYearList() {
				return yearList;
			}
			public void setYearListRange(Integer currentYear) {
				List<Integer> yearList = new ArrayList<Integer>();
				for(int i = currentYear; i >= 1965; i--) {
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
			public List<Board> getAllIndiaBoardList() {
				return allIndiaBoardList;
			}
			public void setAllIndiaBoardList(List<Board> allIndiaBoardList) {
				this.allIndiaBoardList = allIndiaBoardList;
			}
			public List<QualificationLevel> getqualificationGroupLevelList() {
				return qualificationGroupLevelList;
			}
			public void setqualificationGroupLevelList(List<QualificationLevel> qualificationGroupLevelList) {
				this.qualificationGroupLevelList = qualificationGroupLevelList;
			}
			public List<QualificationProgram> getQualificationProgramList() {
				return qualificationProgramList;
			}
			public void setQualificationProgramList(List<QualificationProgram> qualificationProgramList) {
				this.qualificationProgramList = qualificationProgramList;
			}
	}
}
