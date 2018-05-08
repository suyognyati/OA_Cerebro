package com.data.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.data.entities.EducationalInformation;
import com.data.entities.QualificationLevel;
import com.data.entities.User;

@Repository("educationalInformationJpaRepository")
public interface EducationalInformationJpaRepository extends JpaRepository<EducationalInformation, Integer> {
	List<EducationalInformation> 
		findByUserOrderByQualificationLevelQualificationGroupAscQualificationLevelQualificationGroupLevelAsc
		(User user);
	List<EducationalInformation> 
		findByUserOrderByQualificationLevelQualificationGroupDescQualificationLevelQualificationGroupLevelDesc
		(User user);
	EducationalInformation getByUserAndQualificationLevel(User user, QualificationLevel qualificationLevel);
	EducationalInformation getByUserAndEducationalInformationId(User user, Integer educationalInformationId);
	
	/**
	 * This function will give all allowed qualification to apply for perticuler program
	 * @param user
	 * @param qualificationLevels
	 * @return List of EducationalInformation
	 */
	List<EducationalInformation> 
		findByUserAndQualificationLevelInOrderByQualificationLevelQualificationGroupAscQualificationLevelQualificationGroupLevelAsc
		(User user, List<QualificationLevel> qualificationLevels);
}
