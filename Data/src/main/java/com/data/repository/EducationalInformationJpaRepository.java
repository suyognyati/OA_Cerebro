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
		findByUserOrderByQualificationLevelQualificationGroupAscQualificationLevelQualificationSubLevelAsc
		(User user);
	List<EducationalInformation> 
		findByUserOrderByQualificationLevelQualificationGroupDescQualificationLevelQualificationSubLevelDesc
		(User user);
	EducationalInformation getByUserAndQualificationLevel(User user, QualificationLevel qualificationLevel);
	EducationalInformation getByUserAndEducationalInformationId(User user, Integer educationalInformationId);
}
