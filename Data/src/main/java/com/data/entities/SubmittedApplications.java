package com.data.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="SubmittedApplications")
public class SubmittedApplications {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="ApplicationId")
	private Integer applicationId;
	
	@Column(name="FormNo")
	private String formNo;
	
	@ManyToOne
	@JoinColumn(name="FK_CollegeProgramMap")
	private CollegeProgramMap collegeProgramMap;
	
	@ManyToOne
	@JoinColumn(name="FK_User")
	private User user;
	
	@Column(name="Date")
	private String date;
	
	@Column(name="ApplicationStatus")
	private Integer applicationStatus;
	
	@Column(name="StatusComments")
	private String statusComments;

		public Integer getApplicationId() {
			return applicationId;
		}
	
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

		public String getDate() {
			return date;
		}
	
		public void setDate(String date) {
			this.date = date;
		}
	
		public Integer getApplicationStatus() {
			return applicationStatus;
		}
	
		public void setApplicationStatus(Integer applicationStatus) {
			this.applicationStatus = applicationStatus;
		}
	
		public String getStatusComments() {
			return statusComments;
		}
	
		public void setStatusComments(String statusComments) {
			this.statusComments = statusComments;
		}
}
