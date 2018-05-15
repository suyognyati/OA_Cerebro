package com.data.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.data.entities.College;
import com.data.entities.SubmittedApplications;
import com.data.entities.UserDetail;
import com.data.poco.AppliedStudentPOCO;

@Repository("submittedApplicationsJpaRepository")
public interface SubmittedApplicationsJpaRepository extends JpaRepository<SubmittedApplications, Integer> {
	List<SubmittedApplications> findByUserDetailAndCollegeProgramMapCollege(UserDetail userDetail, College college);
	
	@Query(name="SubmittedApplications.getAllMeritStudents")
	List<AppliedStudentPOCO> getMeritStudents(@Param("collegeProgramMapId") Integer collegeProgramMapId);
	
}