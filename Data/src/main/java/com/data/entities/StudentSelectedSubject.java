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
@Table(name="StudentSelectedSubjects")
public class StudentSelectedSubject {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)	
	@Column(name="Id")
	private Integer Id;
	
	@ManyToOne
	@JoinColumn(name="FK_Subject")
	private University_Subject subject;
	
	@ManyToOne
	@JoinColumn(name="FK_Student")
	private UserDetail student;
	
	@ManyToOne
	@JoinColumn(name="FK_CollegeProgramMap")
	private CollegeProgramMap collegeProgramMap;
	
	@ManyToOne
	@JoinColumn(name="FK_Application")
	private Application application;

		public Integer getId() {
			return Id;
		}	
		public void setId(Integer id) {
			Id = id;
		}	
		public University_Subject getSubject() {
			return subject;
		}	
		public void setSubject(University_Subject subject) {
			this.subject = subject;
		}	
		public UserDetail getStudent() {
			return student;
		}	
		public void setStudent(UserDetail student) {
			this.student = student;
		}	
		public CollegeProgramMap getCollegeProgramMap() {
			return collegeProgramMap;
		}	
		public void setCollegeProgramMap(CollegeProgramMap collegeProgramMap) {
			this.collegeProgramMap = collegeProgramMap;
		}	
		public Application getApplication() {
			return application;
		}	
		public void setApplication(Application application) {
			this.application = application;
		}
		
}
