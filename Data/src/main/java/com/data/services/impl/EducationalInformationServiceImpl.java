package com.data.services.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.data.entities.EducationalInformation;
import com.data.entities.QualificationLevel;
import com.data.entities.University_Program;
import com.data.entities.User;
import com.data.repository.EducationalInformationJpaRepository;
import com.data.repository.QualificationLevelJpaRepository;
import com.data.services.EducationalInformationService;

@Service("educationalInformationService")
public class EducationalInformationServiceImpl implements EducationalInformationService {

	@Autowired
	EducationalInformationJpaRepository educationalInformationJpaRepository;
	
	@Autowired
	QualificationLevelJpaRepository qualificationLevelJpaRepository;
	
	@Override
	public List<EducationalInformation> getEducationalHistory(User user) {
		return educationalInformationJpaRepository.
				findByUserOrderByQualificationLevelQualificationGroupAscQualificationLevelQualificationGroupLevelAsc(user);
	}

	@Override
	public EducationalInformation getByUserAndQualificationLevel(User user, QualificationLevel qualificationLevel) {
		return educationalInformationJpaRepository.getByUserAndQualificationLevel(user, qualificationLevel);
	}
	
	@Override
	public EducationalInformation getByEducationalInformationId(User user, Integer educationalInformationId) {
		return educationalInformationJpaRepository.getByUserAndEducationalInformationId(user, educationalInformationId);
	}
	
	@Override
	public Boolean saveEducationalInformation(EducationalInformation educationalInformation) {
		educationalInformationJpaRepository.save(educationalInformation);
		return true;
	}
	
	@Override
	public Boolean deleteEducationalInformation(User user, Integer educationalInformationId) {
		Boolean success = false;
		EducationalInformation educationalInformation = getByEducationalInformationId(user, educationalInformationId);
		if(educationalInformation != null) {
			educationalInformationJpaRepository.delete(educationalInformationId);
			success = true;
		} else {
			success = false;
		}
		return success;
	}

	@Override
	public List<EducationalInformation> getAllowedLastQualification(User user, University_Program program) {
		/*Getting all allowed qualifications from program*/
		String strAllowedQualifications = program.getAllowedLastQualifications();
		String[] tokens = strAllowedQualifications.split(",");
		List<Integer> qualificationLevelIds = new ArrayList<Integer>();
		for (String token : tokens)
        {
			try {
				Integer qualificationId = Integer.parseInt(token);
				qualificationLevelIds.add(qualificationId);
			} catch (Exception e) {
				System.out.println("\n Error - token : " + token + " not able to parse");
			}			
        }		
		List<QualificationLevel> qualificationLevels = qualificationLevelJpaRepository.findAll(qualificationLevelIds);
		
		/*Getting educational history for allowed qualification*/
		List<EducationalInformation> allowedEducationalInformation =
				educationalInformationJpaRepository.findByUserAndQualificationLevelInOrderByQualificationLevelQualificationGroupAscQualificationLevelQualificationGroupLevelAsc
				(user, qualificationLevels);		
		
		return allowedEducationalInformation;
	}
	
}
