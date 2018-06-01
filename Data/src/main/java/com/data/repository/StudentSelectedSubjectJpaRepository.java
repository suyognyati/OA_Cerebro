package com.data.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.data.entities.Application;
import com.data.entities.CollegeProgramMap;
import com.data.entities.StudentSelectedSubject;
import com.data.entities.Student;

@Repository("studentSelectedSubjectsJpaRepository")
public interface StudentSelectedSubjectJpaRepository extends JpaRepository<StudentSelectedSubject, Integer> {
 
	/**
	 * This will give all selected subject list for particular application, collegeProgramMap and student.
	 * @param application
	 * @param collegeProgramMap
	 * @param student
	 * @return
	 */
	List<StudentSelectedSubject> findByApplicationAndCollegeProgramMapAndStudent(Application application, CollegeProgramMap collegeProgramMap, Student student);
	
	/**
	 * This will give all selected subjects of student by application id.
	 * @param applicationId
	 * @return
	 */
	List<StudentSelectedSubject> findByApplicationApplicationId(Integer applicationId);
}
