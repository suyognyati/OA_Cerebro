package com.data.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.data.entities.EducationalInformation;
import com.data.entities.QualificationLevel;
import com.data.entities.UserDetail;

@Repository("educationalInformationJpaRepository")
public interface EducationalInformationJpaRepository extends JpaRepository<EducationalInformation, Integer> {
	List<EducationalInformation> 
		findByUserDetailOrderByQualificationLevelQualificationGroupAscQualificationLevelQualificationGroupLevelAsc
		(UserDetail userDetail);
	List<EducationalInformation> 
		findByUserDetailOrderByQualificationLevelQualificationGroupDescQualificationLevelQualificationGroupLevelDesc
		(UserDetail userDetail);
	EducationalInformation getByUserDetailAndQualificationLevel(UserDetail userDetail, QualificationLevel qualificationLevel);
	EducationalInformation getByUserDetailAndEducationalInformationId(UserDetail userDetail, Integer educationalInformationId);
	
	/**
	 * This function will give all allowed qualification to apply for perticuler program
	 * @param userDetail
	 * @param qualificationLevels
	 * @return List of EducationalInformation
	 */
	List<EducationalInformation> 
		findByUserDetailAndQualificationLevelInOrderByQualificationLevelQualificationGroupAscQualificationLevelQualificationGroupLevelAsc
		(UserDetail userDetail, List<QualificationLevel> qualificationLevels);
}
