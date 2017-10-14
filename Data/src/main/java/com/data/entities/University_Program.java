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
@Table(name="University_Programs")
public class University_Program {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="ProgramId")
	private Integer universityProgramId;
	
	@Column(name="ProgramCode")
	private String universityProgramCode;
	
	@Column(name="ProgramName")
	private String universityProgramName;
	
	@Column(name="ProgramFaculty")
	private String universityProgramFaculty;
	
	@ManyToOne
	@JoinColumn(name="FK_UniversityId")
	private University_University universityUniversity;

		public Integer getUniversityProgramId() {
			return universityProgramId;
		}
	
		public void setUniversityProgramId(Integer universityProgramId) {
			this.universityProgramId = universityProgramId;
		}
	
		public String getUniversityProgramCode() {
			return universityProgramCode;
		}
	
		public void setUniversityProgramCode(String universityProgramCode) {
			this.universityProgramCode = universityProgramCode;
		}
	
		public String getUniversityProgramName() {
			return universityProgramName;
		}
	
		public void setUniversityProgramName(String universityProgramName) {
			this.universityProgramName = universityProgramName;
		}
	
		public String getUniversityProgramFaculty() {
			return universityProgramFaculty;
		}
	
		public void setUniversityProgramFaculty(String universityProgramFaculty) {
			this.universityProgramFaculty = universityProgramFaculty;
		}
	
		public University_University getUniversity() {
			return universityUniversity;
		}
	
		public void setUniversity(University_University university) {
			this.universityUniversity = university;
		}
}
