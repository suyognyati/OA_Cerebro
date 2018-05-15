package com.data.services.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.data.entities.EducationalInformation;
import com.data.entities.QualificationLevel;
import com.data.entities.University_Program;
import com.data.entities.UserDetail;
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
	public List<EducationalInformation> getEducationalHistory(UserDetail userDetail) {
		return educationalInformationJpaRepository.
				findByUserDetailOrderByQualificationLevelQualificationGroupAscQualificationLevelQualificationGroupLevelAsc(userDetail);
	}

	@Override
	public EducationalInformation getByUserDetailAndQualificationLevel(UserDetail userDetail, QualificationLevel qualificationLevel) {
		return educationalInformationJpaRepository.getByUserDetailAndQualificationLevel(userDetail, qualificationLevel);
	}
	
	@Override
	public EducationalInformation getByEducationalInformationId(UserDetail userDetail, Integer educationalInformationId) {
		return educationalInformationJpaRepository.getByUserDetailAndEducationalInformationId(userDetail, educationalInformationId);
	}
	
	@Override
	public Boolean saveEducationalInformation(EducationalInformation educationalInformation) {
		educationalInformationJpaRepository.save(educationalInformation);
		return true;
	}
	
	@Override
	public Boolean deleteEducationalInformation(UserDetail userDetail, Integer educationalInformationId) {
		Boolean success = false;
		EducationalInformation educationalInformation = getByEducationalInformationId(userDetail, educationalInformationId);
		if(educationalInformation != null) {
			educationalInformationJpaRepository.delete(educationalInformationId);
			success = true;
		} else {
			success = false;
		}
		return success;
	}

	@Override
	public List<EducationalInformation> getAllowedLastQualification(UserDetail userDetail, University_Program program) {
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
				educationalInformationJpaRepository.findByUserDetailAndQualificationLevelInOrderByQualificationLevelQualificationGroupAscQualificationLevelQualificationGroupLevelAsc
				(userDetail, qualificationLevels);		
		
		return allowedEducationalInformation;
	}

	@Override
	public EducationalInformation getById(Integer educationalInformationId) {
		return educationalInformationJpaRepository.findOne(educationalInformationId);
	}
	
}
