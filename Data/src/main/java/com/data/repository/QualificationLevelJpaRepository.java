package com.data.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.data.entities.QualificationLevel;

@Repository("qualificationLevelJpaRepository")
public interface QualificationLevelJpaRepository extends JpaRepository<QualificationLevel, Integer> {
	QualificationLevel findByQualificationLevelId(Integer qualificationLevelId);
	
	List<QualificationLevel> findByQualificationGroupAndQualificationSubLevel(Integer qualificationGroup, Integer qualificationSubLevel);
	
	/**
	 * This function will give all sub qualification levels
	 * @param qualificationGroup
	 * @param qualificationSubLevel this should be zero
	 * @return List of QualificationLevel
	 */
	List<QualificationLevel> findByQualificationGroupAndQualificationSubLevelNot(Integer qualificationGroup, Integer qualificationSubLevel);
	
	List<QualificationLevel> findByQualificationGroup(Integer qualificationGroup);
	
	List<QualificationLevel> findByQualificationGroupAndQualificationSubLevelGreaterThanOrderByQualificationSubLevelAsc(Integer qualificationGroup, Integer zeroval);
	
	List<QualificationLevel> findByQualificationGroupAndQualificationSubLevelGreaterThanOrderByQualificationSubLevelDesc(Integer qualificationGroup, Integer zeroval);
	
	List<QualificationLevel> findByOrderByQualificationGroupAsc();
	
	List<QualificationLevel> findByOrderByQualificationGroupDesc();
	
	List<QualificationLevel> findDistinctByQualificationGroupOrderByQualificationGroupAsc(Integer qualificationGroup);
	
	List<QualificationLevel> findDistinctByQualificationGroupOrderByQualificationGroupDesc(Integer qualificationGroup);
	
	List<QualificationLevel> findByQualificationSubLevelOrderByQualificationGroupAsc(Integer qualificationSubLevel);
	
	List<QualificationLevel> findByQualificationSubLevelOrderByQualificationGroupDesc(Integer qualificationSubLevel);
}
