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
	
	@Column(name="ProgramYear")
	private String universityProgramYear;
	
	@Column(name="AllowedLastQualifications")
	private String allowedLastQualifications;
	
	@ManyToOne
	@JoinColumn(name="FK_UniversityId")
	private University_University universityUniversity;
	
	@ManyToOne
	@JoinColumn(name="FK_FileMap")
	ProgramFileMap programFileMap;

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
	
		public String getUniversityProgramYear() {
			return universityProgramYear;
		}
	
		public void setUniversityProgramYear(String universityProgramYear) {
			this.universityProgramYear = universityProgramYear;
		}		
	
		public String getAllowedLastQualifications() {
			return allowedLastQualifications;
		}

		public void setAllowedLastQualifications(String allowedLastQualifications) {
			this.allowedLastQualifications = allowedLastQualifications;
		}

		public University_University getUniversityUniversity() {
			return universityUniversity;
		}
	
		public void setUniversityUniversity(University_University universityUniversity) {
			this.universityUniversity = universityUniversity;
		}

		public ProgramFileMap getProgramFileMap() {
			return programFileMap;
		}

		public void setProgramFileMap(ProgramFileMap programFileMap) {
			this.programFileMap = programFileMap;
		}

}
