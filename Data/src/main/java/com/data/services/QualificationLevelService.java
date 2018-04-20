package com.data.services;

import java.util.List;

import com.data.entities.QualificationLevel;

public interface QualificationLevelService {
	QualificationLevel getById(Integer id);
	QualificationLevel getByMainAndSubLevel(Integer qualificationMainLevel, Integer qualificationSubLevel);
	List<QualificationLevel> getByMainLevel(Integer mainLevel, Boolean ascending);
	List<QualificationLevel> getAllOrderByQualificationMainLevel(Boolean ascending);
	
	/**
	 * This function will give all main levels of 
	 * <b>qualification level in ascending order</b>
	 * which also can be called as groups
	 */
	List<QualificationLevel> getAllMainQualificationLevel();
}
