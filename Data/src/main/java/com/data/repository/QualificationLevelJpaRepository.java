package com.data.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.data.entities.QualificationLevel;

@Repository("qualificationLevelJpaRepository")
public interface QualificationLevelJpaRepository extends JpaRepository<QualificationLevel, Integer> {
	QualificationLevel findByQualificationLevelId(Integer qualificationLevelId);
	
	List<QualificationLevel> findByQualificationGroupAndQualificationGroupLevel(Integer qualificationGroup, Integer qualificationGroupLevel);
	
	/**
	 * This function will give all sub qualification levels
	 * @param qualificationGroup
	 * @param qualificationGroupLevel this should be zero
	 * @return List of QualificationLevel
	 */
	List<QualificationLevel> findByQualificationGroupAndQualificationGroupLevelNot(Integer qualificationGroup, Integer qualificationGroupLevel);
	
	/**
	 * This function will give those sub qualification levels for which educationalInformation is not yet added. 
	 * @param qualificationLevelIds
	 * @param qualificationGroup
	 * @param qualificationGroupLevel this should be zero
	 * @return List of QualificationLevel
	 */
	List<QualificationLevel> findByQualificationLevelIdNotInAndQualificationGroupAndQualificationGroupLevelNot(List<Integer> qualificationLevelIds, Integer qualificationGroup, Integer qualificationGroupLevel);
	
	List<QualificationLevel> findByQualificationGroup(Integer qualificationGroup);
	
	List<QualificationLevel> findByQualificationGroupAndQualificationGroupLevelGreaterThanOrderByQualificationGroupLevelAsc(Integer qualificationGroup, Integer zeroval);
	
	List<QualificationLevel> findByQualificationGroupAndQualificationGroupLevelGreaterThanOrderByQualificationGroupLevelDesc(Integer qualificationGroup, Integer zeroval);
	
	List<QualificationLevel> findByOrderByQualificationGroupAsc();
	
	List<QualificationLevel> findByOrderByQualificationGroupDesc();
	
	List<QualificationLevel> findDistinctByQualificationGroupOrderByQualificationGroupAsc(Integer qualificationGroup);
	
	List<QualificationLevel> findDistinctByQualificationGroupOrderByQualificationGroupDesc(Integer qualificationGroup);
	
	List<QualificationLevel> findByQualificationGroupLevelOrderByQualificationGroupAsc(Integer qualificationGroupLevel);
	
	List<QualificationLevel> findByQualificationGroupLevelOrderByQualificationGroupDesc(Integer qualificationGroupLevel);
	
	/**
	 * This function will return list of QualificationGroupLevel of QualificationGroup where multirefered is true
	 * @param qualificationGroup
	 * @param zero
	 * @param multiRefered
	 * @return List<QualificationLevel>
	 */
	List<QualificationLevel> findByQualificationGroupAndQualificationGroupLevelNotAndMultiReferred(Integer qualificationGroup, Integer zero, Boolean multiRefered);
}
