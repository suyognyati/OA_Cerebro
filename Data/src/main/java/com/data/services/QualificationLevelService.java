package com.data.services;

import java.util.List;

import com.data.entities.QualificationLevel;
import com.data.entities.Student;

public interface QualificationLevelService {
	QualificationLevel getById(Integer id);
	QualificationLevel getByMainAndSubLevel(Integer qualificationGroup, Integer qualificationGroupLevel);
	List<QualificationLevel> getByMainLevel(Integer mainLevel, Boolean ascending);
	List<QualificationLevel> getAllOrderByQualificationGroup(Boolean ascending);
	
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
	List<QualificationLevel> getSubQualificationLevels(Integer qualificationGroup);
	
	/**
	 * This will give those qualification levels where multirefered is false and 
	 * educational information is not filled for current user. 
	 * @param qualificationGroup
	 * @param qualificationLevelIds
	 * @return
	 */
	List<QualificationLevel> getSubQualificationLevelsWithNoEducationalInfoAvailableWithMultireferedFalse
		(Integer qualificationGroup, List<Integer> qualificationLevelIds);
	
	/**
	 * This function will give 
	 * <b>main qualification level</b>
	 */
	QualificationLevel getQualificationGroup(Integer qualificationGroup);
	
	/**
	 * This will give QualificationLevelIdList of filled Educational Information where multirefered will be false.
	 * @param student
	 * @return List<Integer>
	 */
	List<Integer> getQualificationLevelIdListWithNoMultireferedForFilledEducationalInformation(Student student, Integer qualificationGroup);
	
	/**
	 * This will give count of qualificationGroupLevel under qualificationGroup
	 * @param qualificationGroupId
	 * @return Integer
	 */
	Integer getQualificationGroupLevelCount(Integer qualificationGroup);
	
	/**
	 * This function will return true if multirefered exist in qualificationGroup else false
	 * @param qualificationGroup
	 * @return Boolean
	 */
	Boolean isMultireferedUnderQualificationGroupExist(Integer qualificationGroup);
}
