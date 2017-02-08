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
	
	public List<QualificationLevel> getByMainLevel(Integer mainLevel) {
		return qualificationLevelJpaRepository.findByQualificationMainLevel(mainLevel);
	}

	public List<QualificationLevel> getAllOrderByQualificationMainLevel(Boolean ascending) {
		if(ascending)
			return qualificationLevelJpaRepository.findByOrderByQualificationMainLevelAsc();
		else
			return qualificationLevelJpaRepository.findByOrderByQualificationMainLevelDesc();
		
	}
	
	public List<QualificationLevel> getAllMainQualificationOrderByQualificationMainLevel(Boolean ascending) {
		if(ascending)
			return qualificationLevelJpaRepository.findByQualificationSubLevelOrderByQualificationMainLevelAsc(0);
		else
			return qualificationLevelJpaRepository.findByQualificationSubLevelOrderByQualificationMainLevelDesc(0);
	}

}
