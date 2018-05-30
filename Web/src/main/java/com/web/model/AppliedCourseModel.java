package com.web.model;

import java.util.Date;
import java.util.List;

import com.data.entities.CollegeProgramMap;
import com.data.entities.Enums;
import com.data.entities.University_Subject;
import com.data.entities.User;

public class AppliedCourseModel {

	/* Apply for course */
	Integer collegeProgramId;
	List<University_Subject> selectedSubjectList;
	Integer selectedAllowedQualification;
	/* Get applied courses */
	private Integer applicationId;
	private String formNo;
	private CollegeProgramMap collegeProgramMap;
	private User user;	
	private Date date;
	private Enums.KeyValuePair applicationStatus;
	private String statusComments;
	
		/* Apply for course */
	
		public Integer getCollegeProgramId() {
			return collegeProgramId;
		}
		public void setCollegeProgramId(Integer collegeProgramId) {
			this.collegeProgramId = collegeProgramId;
		}
		
		public List<University_Subject> getSelectedSubjectList() {
			return selectedSubjectList;
		}
		public void setSelectedSubjectList(List<University_Subject> selectedSubjectList) {
			this.selectedSubjectList = selectedSubjectList;
		}
		public Integer getSelectedAllowedQualification() {
			return selectedAllowedQualification;
		}
		public void setSelectedAllowedQualification(Integer selectedAllowedQualification) {
			this.selectedAllowedQualification = selectedAllowedQualification;
		}
		public Integer getApplicationId() {
			return applicationId;
		}
		
		/* Get applied courses */
		
		public void setApplicationId(Integer applicationId) {
			this.applicationId = applicationId;
		}
		
		public String getFormNo() {
			return formNo;
		}
		public void setFormNo(String formNo) {
			this.formNo = formNo;
		}
		
		public CollegeProgramMap getCollegeProgramMap() {
			return collegeProgramMap;
		}
		public void setCollegeProgramMap(CollegeProgramMap collegeProgramMap) {
			this.collegeProgramMap = collegeProgramMap;
		}
		
		public User getUser() {
			return user;
		}
		public void setUser(User user) {
			this.user = user;
		}
		
		public Date getDate() {
			return date;
		}
		public void setDate(Date date) {
			this.date = date;
		}
		
		public Enums.KeyValuePair getApplicationStatus() {
			return applicationStatus;
		}
		public void setApplicationStatus(Enums.KeyValuePair applicationStatus) {
			this.applicationStatus = applicationStatus;
		}
		public String getStatusComments() {
			return statusComments;
		}
		public void setStatusComments(String statusComments) {
			this.statusComments = statusComments;
		}	
}
