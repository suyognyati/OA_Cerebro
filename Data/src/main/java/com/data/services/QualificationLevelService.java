package com.data.services;

import java.util.List;

import com.data.entities.QualificationLevel;

public interface QualificationLevelService {
	QualificationLevel getById(Integer id);
	QualificationLevel getByMainAndSubLevel(Integer qualificationMainLevel, Integer qualificationSubLevel);
	List<QualificationLevel> getByMainLevel(Integer mainLevel);
	List<QualificationLevel> getAllOrderByQualificationMainLevel(Boolean ascending);
	List<QualificationLevel> getAllMainQualificationOrderByQualificationMainLevel(Boolean ascending);
}
