package com.data.services.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.data.entities.EducationalInformation;
import com.data.entities.QualificationLevel;
import com.data.entities.UserDetail;
import com.data.repository.EducationalInformationJpaRepository;
import com.data.repository.QualificationLevelJpaRepository;
import com.data.services.QualificationLevelService;

@Service("qualificationLevelService")
public class QualificationLevelServiceImpl implements QualificationLevelService {

	@Autowired
	QualificationLevelJpaRepository qualificationLevelJpaRepository;
	
	@Autowired
	EducationalInformationJpaRepository educationalInformationJpaRepository;
	
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
	public List<QualificationLevel> getSubQualificationLevelsWithNoEducationalInfoAvailableWithMultireferedFalse(
			Integer qualificationGroup, List<Integer> qualificationLevelIds) {
		return qualificationLevelJpaRepository.findByQualificationLevelIdNotInAndQualificationGroupAndQualificationGroupLevelNot
				(qualificationLevelIds, qualificationGroup, 0);
	}

	@Override
	public QualificationLevel getQualificationGroup(Integer qualificationGroup) {
		List<QualificationLevel> qualificationLevelList = qualificationLevelJpaRepository.findByQualificationGroupAndQualificationGroupLevel(qualificationGroup, 0);
		if(qualificationLevelList != null && qualificationLevelList.size() > 0)
			return qualificationLevelList.get(0);
		else
			return null;
	}

	@Override
	public List<Integer> getQualificationLevelIdListWithNoMultireferedForFilledEducationalInformation(
			UserDetail userDetail, Integer qualificationGroup) {
		List<Integer> qualificationLevelIdList = new ArrayList<Integer>();
		
		List<EducationalInformation> educationalInformationList = educationalInformationJpaRepository.findByUserDetailAndQualificationLevelQualificationGroupAndQualificationLevelMultiReferred(userDetail, qualificationGroup, false);
		for(EducationalInformation educationalInformation : educationalInformationList) {
			QualificationLevel qualificationLevel = educationalInformation.getQualificationLevel();
			if(qualificationLevel != null)
				qualificationLevelIdList.add(qualificationLevel.getQualificationLevelId());
		}
		return qualificationLevelIdList;
	}

	@Override
	public Integer getQualificationGroupLevelCount(Integer qualificationGroup) {
		List<QualificationLevel> qualificationLevels = qualificationLevelJpaRepository.findByQualificationGroupAndQualificationGroupLevelNot(qualificationGroup, 0);
		Integer count = 0;
		if(qualificationLevels != null)
			count = qualificationLevels.size();
		return count;
	}

	@Override
	public Boolean isMultireferedUnderQualificationGroupExist(Integer qualificationGroup) {
		List<QualificationLevel> multireferedQualificationLevels = qualificationLevelJpaRepository.findByQualificationGroupAndQualificationGroupLevelNotAndMultiReferred(qualificationGroup, 0, true);
		if(multireferedQualificationLevels != null && multireferedQualificationLevels.size() > 0)
			return true;
		return false;
	}

}
