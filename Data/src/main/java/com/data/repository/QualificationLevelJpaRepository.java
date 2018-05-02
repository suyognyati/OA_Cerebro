package com.data.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.data.entities.QualificationLevel;

@Repository("qualificationLevelJpaRepository")
public interface QualificationLevelJpaRepository extends JpaRepository<QualificationLevel, Integer> {
	QualificationLevel findByQualificationLevelId(Integer qualificationLevelId);
	
	List<QualificationLevel> findByQualificationMainLevelAndQualificationSubLevel(Integer qualificationMainLevel, Integer qualificationSubLevel);
	
	/**
	 * This function will give all sub qualification levels
	 * @param qualificationMainLevel
	 * @param qualificationSubLevel this should be zero
	 * @return List of QualificationLevel
	 */
	List<QualificationLevel> findByQualificationMainLevelAndQualificationSubLevelNot(Integer qualificationMainLevel, Integer qualificationSubLevel);
	
	List<QualificationLevel> findByQualificationMainLevel(Integer qualificationMainLevel);
	
	List<QualificationLevel> findByQualificationMainLevelAndQualificationSubLevelGreaterThanOrderByQualificationSubLevelAsc(Integer qualificationMainLevel, Integer zeroval);
	
	List<QualificationLevel> findByQualificationMainLevelAndQualificationSubLevelGreaterThanOrderByQualificationSubLevelDesc(Integer qualificationMainLevel, Integer zeroval);
	
	List<QualificationLevel> findByOrderByQualificationMainLevelAsc();
	
	List<QualificationLevel> findByOrderByQualificationMainLevelDesc();
	
	List<QualificationLevel> findDistinctByQualificationMainLevelOrderByQualificationMainLevelAsc(Integer qualificationMainLevel);
	
	List<QualificationLevel> findDistinctByQualificationMainLevelOrderByQualificationMainLevelDesc(Integer qualificationMainLevel);
	
	List<QualificationLevel> findByQualificationSubLevelOrderByQualificationMainLevelAsc(Integer qualificationSubLevel);
	
	List<QualificationLevel> findByQualificationSubLevelOrderByQualificationMainLevelDesc(Integer qualificationSubLevel);
}
