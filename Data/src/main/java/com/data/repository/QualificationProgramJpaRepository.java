package com.data.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.data.entities.QualificationLevel;
import com.data.entities.QualificationProgram;

@Repository("qualificationProgramJpaRepository")
public interface QualificationProgramJpaRepository extends JpaRepository<QualificationProgram, Integer> {
	/**
	 * This function will give available courses for particular qualification
	 * @param qualificationLevelId
	 * @return List of QualificationCourse
	 */
	List<QualificationProgram> findByQualificationLevel(QualificationLevel qualificationLevelId);
}
