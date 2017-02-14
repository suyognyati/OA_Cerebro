package com.data.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="EducationalInformation")
public class EducationalInformation {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="EducationalInformationId")
	private Integer educationalInformationId;
	
	@OneToOne
	@JoinColumn(name="FK_UserId", nullable=false)
	private User user;

	@ManyToOne
	@JoinColumn(name="FK_Country")
	private Country country;

	@ManyToOne
	@JoinColumn(name="FK_State")
	private State state;

	@ManyToOne
	@JoinColumn(name="FK_Board")
	private Board board;
	
	@ManyToOne
	@JoinColumn(name="FK_University")
	private Board university;
	
	@Column(name="BoardUniversity_AreaStdCodePhone")
	private String boardUniversity_AreaStdCodePhone;
	
	@Column(name="BoardUniversity_EmailId")
	private String boardUniversity_EmailId;
	
	@Column(name="BoardUniversity_URL")
	private String boardUniversity_URL;
	
	@Column(name="ResultStatus")
	private Integer resultStatus;
	
	@Column(name="Stream")
	private Integer stream;
	
	@Column(name="NoOfAttempts")
	private Integer noOfAttempts;
	
	@Column(name="QualificationName")
	private String qualificationName;
	
	@ManyToOne
	@JoinColumn(name="FK_QualificationLevel", nullable=false)
	private QualificationLevel qualificationLevel;
	
	@Column(name="SpecialSubject")
	private String specialSubject;
	
	@Column(name="OtherBodyName")
	private String otherBodyName;
	
	@Column(name="SchoolCollegeAddress")
	private String schoolCollegeAddress;
	
	@Column(name="CertifyingBody")
	private Integer certifyingBody;
	
	@Column(name="IsLocalBody")
	private Boolean isLocalBody;
	
	@Column(name="SchoolCollegeName")
	private String schoolCollegeName;
	
	@Column(name="PassingMonth")
	private Integer passingMonth;
	
	@Column(name="PassingYear")
	private Integer passingYear;
	
	@Column(name="ExamSeatNo")
	private String examSeatNo;
	
	@Column(name="MarksheetNo")
	private String marksheetNo;
	
	@Column(name="EvaluationType")
	private Integer evaluationType;
	
	@Column(name="MarksObtain")
	private Integer marksObtain;
	
	@Column(name="TotalMarks")
	private Integer totalMarks;
	
	@Column(name="Percentage")
	private Float percentage;
	
	@Column(name="Grade")
	private String grade;
	
	@Column(name="CGPA")
	private Float cgpa;

		public Integer getEducationalInformationId() {
			return educationalInformationId;
		}
	
		public void setEducationalInformationId(Integer educationalInformationId) {
			this.educationalInformationId = educationalInformationId;
		}
	
		public User getUser() {
			return user;
		}
	
		/**
		 * @param user User of whose education information is required
		 * */
		public void setUser(User user) {
			this.user = user;
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
	
		/**
		 * @return It returns board name if exam is conducted under board
		 * */
		public Board getBoard() {
			return board;
		}

		public void setBoard(Board board) {
			this.board = board;
		}

		/**
		 * @return It returns university name if exam is conducted under university
		 * */
		public Board getUniversity() {
			return university;
		}

		public void setUniversity(Board university) {
			this.university = university;
		}
	
		public String getBoardUniversity_AreaStdCodePhone() {
			return boardUniversity_AreaStdCodePhone;
		}
	
		public void setBoardUniversity_AreaStdCodePhone(String boardUniversity_AreaStdCodePhone) {
			this.boardUniversity_AreaStdCodePhone = boardUniversity_AreaStdCodePhone;
		}
	
		public String getBoardUniversity_EmailId() {
			return boardUniversity_EmailId;
		}
	
		public void setBoardUniversity_EmailId(String boardUniversity_EmailId) {
			this.boardUniversity_EmailId = boardUniversity_EmailId;
		}
	
		public String getBoardUniversity_URL() {
			return boardUniversity_URL;
		}
	
		public void setBoardUniversity_URL(String boardUniversity_URL) {
			this.boardUniversity_URL = boardUniversity_URL;
		}
	
		/**
		 * @return It returns result status which can be 1 as Passed, 2 as Result Awaited, 3 as Failed
		 * */
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
	
		/**
		 * @return It returns level of qualification which starts from 10th and end to Highest qualification
		 * */
		public QualificationLevel getQualificationLevel() {
			return qualificationLevel;
		}

		public void setQualificationLevel(QualificationLevel qualificationLevel) {
			this.qualificationLevel = qualificationLevel;
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
	
		/**
		 * @return It returns certifying body which can be 1 as Board, 2 as University, 3 as Other
		 * */
		public Integer getCertifyingBody() {
			return certifyingBody;
		}
	
		/**
		 * @param certifyingBody It can have 3 values "Board, University, Other"
		 * */
		public void setCertifyingBody(Integer certifyingBody) {
			this.certifyingBody = certifyingBody;
		}
	
		/**
		 * @return It returns True for Indian else False
		 * */
		public Boolean getIsLocalBody() {
			return isLocalBody;
		}
	
		/**
		 * @param isLocalBody It can be true or false true denotes person is Indian or else Foreign
		 * */
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
	
		/**
		 * @return It returns evaluation type which can be 1 for Marks and 2 for Grades
		 * */
		public Integer getEvaluationType() {
			return evaluationType;
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
	
	
}
