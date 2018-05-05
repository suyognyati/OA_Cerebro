package com.data.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.data.entities.QualificationLevel;
import com.data.repository.QualificationLevelJpaRepository;
import com.data.services.QualificationLevelService;

@Service("qualificationLevelService")
public class QualificationLevelServiceImpl implements QualificationLevelService {

	@Autowired
	QualificationLevelJpaRepository qualificationLevelJpaRepository;
	
	public QualificationLevel getById(Integer id) {
		return qualificationLevelJpaRepository.findByQualificationLevelId(id);
	}
	
	public QualificationLevel getByMainAndSubLevel(Integer qualificationGroup, Integer qualificationGroupLevel) {
		List<QualificationLevel> qualificationLevelList = qualificationLevelJpaRepository.findByQualificationGroupAndQualificationGroupLevel(qualificationGroup, qualificationGroupLevel);
		if(qualificationLevelList != null && qualificationLevelList.size() > 0)
			return qualificationLevelList.get(0);
		else
			return null;
	}
	
	public List<QualificationLevel> getByMainLevel(Integer mainLevel, Boolean ascending) {
		if(ascending)
			return qualificationLevelJpaRepository.findByQualificationGroupAndQualificationGroupLevelGreaterThanOrderByQualificationGroupLevelAsc(mainLevel, 0);
		else
			return qualificationLevelJpaRepository.findByQualificationGroupAndQualificationGroupLevelGreaterThanOrderByQualificationGroupLevelDesc(mainLevel, 0);
	}

	public List<QualificationLevel> getAllOrderByQualificationGroup(Boolean ascending) {
		if(ascending)
			return qualificationLevelJpaRepository.findByOrderByQualificationGroupAsc();
		else
			return qualificationLevelJpaRepository.findByOrderByQualificationGroupDesc();
		
	}
	
	public List<QualificationLevel> getAllMainQualificationLevel() {
		return qualificationLevelJpaRepository.findByQualificationGroupLevelOrderByQualificationGroupAsc(0);
	}

	@Override
	public List<QualificationLevel> getSubQualificationLevels(Integer qualificationGroup) {
		return qualificationLevelJpaRepository.findByQualificationGroupAndQualificationGroupLevelNot(qualificationGroup, 0);
	}

	@Override
	public QualificationLevel getQualificationGroup(Integer qualificationGroup) {
		List<QualificationLevel> qualificationLevelList = qualificationLevelJpaRepository.findByQualificationGroupAndQualificationGroupLevel(qualificationGroup, 0);
		if(qualificationLevelList != null && qualificationLevelList.size() > 0)
			return qualificationLevelList.get(0);
		else
			return null;
	}

}
