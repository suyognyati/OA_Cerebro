package com.web.model;

import java.util.List;

import com.data.entities.CourseGroupLevelOne;
import com.data.entities.University_Program;

public class SubjectModel {

	private University_Program program;
	private List<CourseGroupLevelOne> courseGroupLevelOneList; 
		
		public void setProgram(University_Program program) {
			this.program = program;
		}
		public University_Program getProgram() {
			return program;
		}	
		public List<CourseGroupLevelOne> getCourseGroupLevelOneList() {
			return courseGroupLevelOneList;
		}
		public void setCourseGroupLevelOneList(List<CourseGroupLevelOne> courseGroupLevelOneList) {
			this.courseGroupLevelOneList = courseGroupLevelOneList;
		}
	
}
