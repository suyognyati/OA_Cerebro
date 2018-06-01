package com.data.services;

import java.util.List;

import com.data.entities.Application;
import com.data.entities.CollegeProgramMap;
import com.data.entities.StudentSelectedSubject;
import com.data.entities.Student;

public interface StudentSelectedSubjectsDao {

	/**
	 * This function will save the entire subject list of applied course.
	 * @param studentSelectedSubjectList
	 * @return List<StudentSelectedSubject>
	 */
	public List<StudentSelectedSubject> save(List<StudentSelectedSubject> studentSelectedSubjectList);
	
	/**
	 * This function will provide selected subject list of application of particular program by student. 
	 * @param application
	 * @param collegeProgramMap
	 * @param student
	 * @return List<StudentSelectedSubject>
	 */
	public List<StudentSelectedSubject> getSelectedSubjectOfApplication(Application application, CollegeProgramMap collegeProgramMap, Student student);
	
	/**
	 * This function will provide selected subject list for application.
	 * @param applicationId
	 * @return List<StudentSelectedSubject>
	 */
	public List<StudentSelectedSubject> getSelectedSubjectOfApplication(Integer applicationId);
	
	/**
	 * Delete student selected subjects by studentSelectedSubject list.
	 * @param studentSelectedSubjectList
	 * @return Boolean
	 */
	public Boolean deleteBySelectedSubjectList(List<StudentSelectedSubject> studentSelectedSubjectList);
}
