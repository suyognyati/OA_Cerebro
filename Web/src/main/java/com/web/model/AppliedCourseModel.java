package com.web.model;

import java.util.List;

import com.data.entities.University_Subject;

public class AppliedCourseModel {

	Integer collegeProgramId;
	List<University_Subject> selectedSubjectList;
	
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
}
