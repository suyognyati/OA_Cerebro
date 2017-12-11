package com.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.data.entities.SubmittedApplications;

@Repository("submittedApplicationsJPARepository")
public interface SubmittedApplicationsJPARepository extends JpaRepository<SubmittedApplications, Integer> {
	
}