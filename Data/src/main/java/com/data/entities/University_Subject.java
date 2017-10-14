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
@Table(name="University_Subjects")
public class University_Subject {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="SubjectId")
	private Integer universitySubjectId;
	
	@Column(name="SubjectCode")
	private Integer universitySubjectCode;
	
	@Column(name="SubjectName")
	private Integer universitySubjectName;
	
	@Column(name="SubjectType")
	private Integer universitySubjectType;
	
	@ManyToOne
	@JoinColumn(name="FK_ProgramId")
	University_Program universityProgram;

		public Integer getUniversitySubjectId() {
			return universitySubjectId;
		}
	
		public void setUniversitySubjectId(Integer universitySubjectId) {
			this.universitySubjectId = universitySubjectId;
		}
	
		public Integer getUniversitySubjectCode() {
			return universitySubjectCode;
		}
	
		public void setUniversitySubjectCode(Integer universitySubjectCode) {
			this.universitySubjectCode = universitySubjectCode;
		}
	
		public Integer getUniversitySubjectName() {
			return universitySubjectName;
		}
	
		public void setUniversitySubjectName(Integer universitySubjectName) {
			this.universitySubjectName = universitySubjectName;
		}
	
		public Integer getUniversitySubjectType() {
			return universitySubjectType;
		}
	
		public void setUniversitySubjectType(Integer universitySubjectType) {
			this.universitySubjectType = universitySubjectType;
		}
	
		public University_Program getUniversityProgram() {
			return universityProgram;
		}
	
		public void setUniversityProgram(University_Program universityProgram) {
			this.universityProgram = universityProgram;
		}
}
