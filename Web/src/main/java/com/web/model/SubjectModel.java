package com.web.model;

import java.util.List;

import com.data.entities.CourseGroupLevelOne;
import com.data.entities.University_Program;
import com.data.entities.University_Subject;

public class SubjectModel {

	private University_Program program;
	private List<University_Subject> subjectListOfCollege;
	private List<CourseGroupLevelOne> courseGroupLevelOneList; 
		
		public void setProgram(University_Program program) {
			this.program = program;
		}
		public University_Program getProgram() {
			return program;
		}
		public List<University_Subject> getSubjectListOfCollege() {
			return subjectListOfCollege;
		}
		public void setSubjectListOfCollege(List<University_Subject> subjectListOfCollege) {
			this.subjectListOfCollege = subjectListOfCollege;
		}
		public List<CourseGroupLevelOne> getCourseGroupLevelOneList() {
			return courseGroupLevelOneList;
		}
		public void setCourseGroupLevelOneList(List<CourseGroupLevelOne> courseGroupLevelOneList) {
			this.courseGroupLevelOneList = courseGroupLevelOneList;
		}
	
}
