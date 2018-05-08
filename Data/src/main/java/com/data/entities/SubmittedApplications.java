package com.data.entities;

import javax.persistence.Column;
import javax.persistence.ColumnResult;
import javax.persistence.ConstructorResult;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedNativeQueries;
import javax.persistence.NamedNativeQuery;
import javax.persistence.SqlResultSetMapping;
import javax.persistence.SqlResultSetMappings;
import javax.persistence.Table;

import com.data.poco.AppliedStudentPOCO;

@SqlResultSetMappings({
	@SqlResultSetMapping(
		    name="appliedStudentPOCOMapping",
		    classes={
		        @ConstructorResult(
		            targetClass=AppliedStudentPOCO.class,
		            columns={
		                @ColumnResult(name="ApplicationId"),
		                @ColumnResult(name="ApplicationStatus"),
		                @ColumnResult(name="Date"),
		                @ColumnResult(name="FormNo"),
		                @ColumnResult(name="StatusComments"),
		                @ColumnResult(name="FK_CollegeProgramMap"),
		                @ColumnResult(name="FK_User"),
		                @ColumnResult(name="FK_EducationalInformation"),
		                @ColumnResult(name="FirstName"),
		                @ColumnResult(name="MiddleName"),
		                @ColumnResult(name="LastName"),
		                @ColumnResult(name="Category"),
		                @ColumnResult(name="Caste"),
		                @ColumnResult(name="EvaluationType"),
		                @ColumnResult(name="MarksObtain"),
		                @ColumnResult(name="TotalMarks")
		            }
		        )
		    }
		)
})

@NamedNativeQueries({
	@NamedNativeQuery(
			name = "SubmittedApplications.getAllMeritStudents",
			query = "SELECT sa.*, "
					+ "pd.MiddleName, pd.FirstName, pd.LastName, "
					+ "ors.Category, ors.Caste, "
					+ "ei.EvaluationType, ei.MarksObtain, ei.TotalMarks "
					+ "FROM SubmittedApplications as sa "
					+ "LEFT JOIN PersonalDetails as pd ON (sa.FK_User = pd.FK_User) "
					+ "LEFT JOIN OccupationReservation as ors ON (sa.FK_User = ors.FK_User) "
					+ "LEFT JOIN EducationalInformation as ei ON (sa.FK_EducationalInformation = ei.EducationalInformationId) "
					+ "WHERE FK_CollegeProgramMap = :collegeProgramMapId",
			resultSetMapping = "appliedStudentPOCOMapping")
})

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
	
	@ManyToOne
	@JoinColumn(name="FK_EducationalInformation")
	private EducationalInformation educationalInformation;
	
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

		public EducationalInformation getEducationalInformation() {
			return educationalInformation;
		}

		public void setEducationalInformation(EducationalInformation educationalInformation) {
			this.educationalInformation = educationalInformation;
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
