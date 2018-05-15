package com.data.poco;

/**
* <h1>AppliedStudentPOCO</h1>
* This class is used to retrieved data from database by 
* <b>SubmittedApplications.getAllMeritStudents</b>
* This class gives data to generate merit list.
*/

public class AppliedStudentPOCO {

	private Integer applicationId;
	
	private Integer applicationStatus;
	
	private String date;
	
	private String formNo;
	
	private String statusComments;
	
	private Integer collegeProgramMap;	
	
	private Integer userDetailId;
	
	private Integer educationalInformationId;
	
	private String firstName;
	
	private String middleName;
	
	private String lastName;
	
	private Integer category;
	
	private String caste;
	
	private Integer evaluationType;
	
	private Integer marksObtain;
	
	private Integer totalMarks;
	
	public AppliedStudentPOCO(
			Integer applicationId, Integer applicationStatus, String date, String formNo, String statusComments, Integer collegeProgramMap, Integer userDetailId,
			Integer educationalInformationId, String firstName, String middleName, String lastName, Integer category, String caste,
			Integer evaluationType, Integer marksObtain, Integer totalMarks) {
		this.applicationId = applicationId;
		this.applicationStatus = applicationStatus;
		this.date = date;
		this.formNo = formNo;		
		this.statusComments = statusComments;
		this.collegeProgramMap = collegeProgramMap;
		this.userDetailId = userDetailId;
		this.educationalInformationId = educationalInformationId;
		this.firstName = firstName;
		this.middleName = middleName;
		this.lastName = lastName;
		this.category = category;
		this.caste = caste;
		this.evaluationType = evaluationType;
		this.marksObtain = marksObtain;
		this.totalMarks = totalMarks;
	}

	public Integer getApplicationId() {
		return applicationId;
	}

	public void setApplicationId(Integer applicationId) {
		this.applicationId = applicationId;
	}

	public Integer getApplicationStatus() {
		return applicationStatus;
	}

	public void setApplicationStatus(Integer applicationStatus) {
		this.applicationStatus = applicationStatus;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getFormNo() {
		return formNo;
	}

	public void setFormNo(String formNo) {
		this.formNo = formNo;
	}

	public String getStatusComments() {
		return statusComments;
	}

	public void setStatusComments(String statusComments) {
		this.statusComments = statusComments;
	}

	public Integer getCollegeProgramMap() {
		return collegeProgramMap;
	}

	public void setCollegeProgramMap(Integer collegeProgramMap) {
		this.collegeProgramMap = collegeProgramMap;
	}

	public Integer getUserDetailId() {
		return userDetailId;
	}

	public void setUserDetailId(Integer userDetailId) {
		this.userDetailId = userDetailId;
	}

	public Integer getEducationalInformationId() {
		return educationalInformationId;
	}

	public void setEducationalInformationId(Integer educationalInformationId) {
		this.educationalInformationId = educationalInformationId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getMiddleName() {
		return middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Integer getCategory() {
		return category;
	}

	public void setCategory(Integer category) {
		this.category = category;
	}

	public String getCaste() {
		return caste;
	}

	public void setCaste(String caste) {
		this.caste = caste;
	}

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
	
}
