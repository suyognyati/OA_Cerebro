package com.data.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.data.entities.EducationalInformation;
import com.data.entities.QualificationLevel;
import com.data.entities.Student;

@Repository("educationalInformationJpaRepository")
public interface EducationalInformationJpaRepository extends JpaRepository<EducationalInformation, Integer> {
	List<EducationalInformation> 
		findByStudentOrderByQualificationLevelQualificationGroupAscQualificationLevelQualificationGroupLevelAsc
		(Student student);
	List<EducationalInformation> 
		findByStudentOrderByQualificationLevelQualificationGroupDescQualificationLevelQualificationGroupLevelDesc
		(Student student);
	EducationalInformation getByStudentAndQualificationLevel(Student student, QualificationLevel qualificationLevel);
	EducationalInformation getByStudentAndEducationalInformationId(Student student, Integer educationalInformationId);
	
	/**
	 * This function will give all allowed qualification to apply for perticuler program
	 * @param student
	 * @param qualificationLevels
	 * @return List of EducationalInformation
	 */
	List<EducationalInformation> 
		findByStudentAndQualificationLevelInOrderByQualificationLevelQualificationGroupAscQualificationLevelQualificationGroupLevelAsc
		(Student student, List<QualificationLevel> qualificationLevels);
	
	/**
	 * This will give educational detail where QualificationLevel does not support MultiRefered
	 * @param student
	 * @param multiRefered
	 * @return List of EducationalInformation
	 */
	List<EducationalInformation> findByStudentAndQualificationLevelQualificationGroupAndQualificationLevelMultiReferred(Student student, Integer qualificationGroup, Boolean multiRefered);
}
