package com.data.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="ProgramFileMap")
public class ProgramFileMap {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="ProgramFileId")
	Integer programFileId;
	
	@Column(name="UniversityFolderName")
	String universityFolderName;
	
	@Column(name="ViewFileName")
	String viewFileName;

		public Integer getProgramFileId() {
			return programFileId;
		}
	
		public void setProgramFileId(Integer programFileId) {
			this.programFileId = programFileId;
		}
	
		public String getUniversityFolderName() {
			return universityFolderName;
		}
	
		public void setUniversityFolderName(String universityFolderName) {
			this.universityFolderName = universityFolderName;
		}
	
		public String getViewFileName() {
			return viewFileName;
		}
	
		public void setViewFileName(String viewFileName) {
			this.viewFileName = viewFileName;
		}
	
}
