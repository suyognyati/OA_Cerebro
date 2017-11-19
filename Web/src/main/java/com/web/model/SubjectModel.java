package com.web.model;

import java.util.List;

import com.data.entities.CourseGroupLevelOne;

public class SubjectModel {

	private List<CourseGroupLevelOne> courseGroupLevelOneList; 
		
		public List<CourseGroupLevelOne> getCourseGroupLevelOneList() {
			return courseGroupLevelOneList;
		}
		public void setCourseGroupLevelOneList(List<CourseGroupLevelOne> courseGroupLevelOneList) {
			this.courseGroupLevelOneList = courseGroupLevelOneList;
		}
	
}
