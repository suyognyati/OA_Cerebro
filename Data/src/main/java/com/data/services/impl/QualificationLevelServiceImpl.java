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
	
	public QualificationLevel getByMainAndSubLevel(Integer qualificationMainLevel, Integer qualificationSubLevel) {
		List<QualificationLevel> qualificationLevelList = qualificationLevelJpaRepository.findByQualificationMainLevelAndQualificationSubLevel(qualificationMainLevel, qualificationSubLevel);
		if(qualificationLevelList != null && qualificationLevelList.size() > 0)
			return qualificationLevelList.get(0);
		else
			return null;
	}
	
	public List<QualificationLevel> getByMainLevel(Integer mainLevel, Boolean ascending) {
		if(ascending)
			return qualificationLevelJpaRepository.findByQualificationMainLevelAndQualificationSubLevelGreaterThanOrderByQualificationSubLevelAsc(mainLevel, 0);
		else
			return qualificationLevelJpaRepository.findByQualificationMainLevelAndQualificationSubLevelGreaterThanOrderByQualificationSubLevelDesc(mainLevel, 0);
	}

	public List<QualificationLevel> getAllOrderByQualificationMainLevel(Boolean ascending) {
		if(ascending)
			return qualificationLevelJpaRepository.findByOrderByQualificationMainLevelAsc();
		else
			return qualificationLevelJpaRepository.findByOrderByQualificationMainLevelDesc();
		
	}
	
	public List<QualificationLevel> getAllMainQualificationLevel() {
		return qualificationLevelJpaRepository.findByQualificationSubLevelOrderByQualificationMainLevelAsc(0);
	}

	@Override
	public List<QualificationLevel> getSubQualificationLevels(Integer qualificationMainLevel) {
		return qualificationLevelJpaRepository.findByQualificationMainLevelAndQualificationSubLevelNot(qualificationMainLevel, 0);
	}

	@Override
	public QualificationLevel getQualificationMainLevel(Integer qualificationMainLevel) {
		List<QualificationLevel> qualificationLevelList = qualificationLevelJpaRepository.findByQualificationMainLevelAndQualificationSubLevel(qualificationMainLevel, 0);
		if(qualificationLevelList != null && qualificationLevelList.size() > 0)
			return qualificationLevelList.get(0);
		else
			return null;
	}

}
