package com.data.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.data.entities.Application;
import com.data.entities.CollegeProgramMap;
import com.data.entities.StudentSelectedSubject;
import com.data.entities.UserDetail;

@Repository("studentSelectedSubjectsJpaRepository")
public interface StudentSelectedSubjectJpaRepository extends JpaRepository<StudentSelectedSubject, Integer> {
 
	List<StudentSelectedSubject> findByApplicationAndCollegeProgramMapAndStudent(Application application, CollegeProgramMap collegeProgramMap, UserDetail student);
}
