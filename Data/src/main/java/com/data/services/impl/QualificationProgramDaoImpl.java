package com.data.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.data.entities.QualificationLevel;
import com.data.entities.QualificationProgram;
import com.data.repository.QualificationProgramJpaRepository;
import com.data.services.QualificationProgramDao;

@Service("qualificationProgramDao")
public class QualificationProgramDaoImpl implements QualificationProgramDao {

	@Autowired
	QualificationProgramJpaRepository qualificationProgramJpaRepository;
	
	@Override
	public List<QualificationProgram> getProgramListOfQualification(QualificationLevel qualificationLevel) {
		return qualificationProgramJpaRepository.findByQualificationLevel(qualificationLevel);		
	}

}
