package com.data.services;

import java.util.List;

import com.data.entities.QualificationLevel;

public interface QualificationLevelService {
	QualificationLevel getById(Integer id);
	List<QualificationLevel> getByMajorLevel(Integer majorLevel);
	List<QualificationLevel> getAllOrderByQualificationMainLevel(Boolean ascending);
	List<QualificationLevel> getAllMainQualificationOrderByQualificationMainLevel(Boolean ascending);
}
