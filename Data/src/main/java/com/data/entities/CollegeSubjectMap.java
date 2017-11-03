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
@Table(name="CollegeSubjectMap")
public class CollegeSubjectMap {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="CollegeSubjectId")
	Integer collegeSubjectId;
	
	@ManyToOne
	@JoinColumn(name="FK_College")
	College college;
	
	@ManyToOne
	@JoinColumn(name="FK_Program")
	University_Program program;

	@ManyToOne
	@JoinColumn(name="FK_Subject")
	University_Subject subject;

		public Integer getCollegeSubjectId() {
			return collegeSubjectId;
		}
	
		public void setCollegeSubjectId(Integer collegeSubjectId) {
			this.collegeSubjectId = collegeSubjectId;
		}
	
		public College getCollege() {
			return college;
		}
	
		public void setCollege(College college) {
			this.college = college;
		}
	
		public University_Program getProgram() {
			return program;
		}
	
		public void setProgram(University_Program program) {
			this.program = program;
		}
	
		public University_Subject getSubject() {
			return subject;
		}
	
		public void setSubject(University_Subject subject) {
			this.subject = subject;
		}
	
}
