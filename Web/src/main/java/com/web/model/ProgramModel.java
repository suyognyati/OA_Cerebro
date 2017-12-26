package com.web.model;

import com.data.entities.ProgramFileMap;

public class ProgramModel {
	
	private Integer collegeProgramId;
	private String programCode;
	private String programName;
	private String facultyOrCollege;
	private String applicationDates;
	private Integer programId;
	private ProgramFileMap fileMap;
	
	
		public Integer getCollegeProgramId() {
			return collegeProgramId;
		}
		public void setCollegeProgramId(Integer collegeProgramId) {
			this.collegeProgramId = collegeProgramId;
		}
		
		
		public String getProgramCode() {
			return programCode;
		}
		public void setProgramCode(String programCode) {
			this.programCode = programCode;
		}
		
		
		public String getProgramName() {
			return programName;
		}
		public void setProgramName(String programName) {
			this.programName = programName;
		}
		
		
		public String getFacultyOrCollege() {
			return facultyOrCollege;
		}
		public void setFacultyOrCollege(String facultyOrCollege) {
			this.facultyOrCollege = facultyOrCollege;
		}
		
		
		public String getApplicationDates() {
			return applicationDates;
		}
		public void setApplicationDates(String applicationDates) {
			this.applicationDates = applicationDates;
		}
		
		
		
		public Integer getProgramId() {
			return programId;
		}
		public void setProgramId(Integer programId) {
			this.programId = programId;
		}
		
		
		public ProgramFileMap getFileMap() {
			return fileMap;
		}
		public void setFileMap(ProgramFileMap fileMap) {
			this.fileMap = fileMap;
		}
	
}