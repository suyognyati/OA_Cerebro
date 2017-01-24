package com.data.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.data.entities.QualificationLevel;

@Repository("qualificationLevelJpaRepository")
public interface QualificationLevelJpaRepository extends JpaRepository<QualificationLevel, Integer> {
	QualificationLevel findByQualificationLevelId(Integer qualificationLevelId);
	List<QualificationLevel> findByQualificationMainLevel(Integer qualificationMainLevel);
	List<QualificationLevel> findByOrderByQualificationMainLevelAsc();
	List<QualificationLevel> findByOrderByQualificationMainLevelDesc();
	List<QualificationLevel> findDistinctByQualificationMainLevelOrderByQualificationMainLevelAsc(Integer qualificationMainLevel);
	List<QualificationLevel> findDistinctByQualificationMainLevelOrderByQualificationMainLevelDesc(Integer qualificationMainLevel);
	List<QualificationLevel> findByQualificationSubLevelOrderByQualificationMainLevelAsc(Integer qualificationSubLevel);
	List<QualificationLevel> findByQualificationSubLevelOrderByQualificationMainLevelDesc(Integer qualificationSubLevel);
}
