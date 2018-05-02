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
	
	/**
	 * This function will give all <b>sub levels</b> of 
	 * <b>main qualification level in ascending order</b>
	 */
	List<QualificationLevel> getSubQualificationLevels(Integer qualificationMainLevel);
	
	/**
	 * This function will give 
	 * <b>main qualification level</b>
	 */
	QualificationLevel getQualificationMainLevel(Integer qualificationMainLevel);
}
