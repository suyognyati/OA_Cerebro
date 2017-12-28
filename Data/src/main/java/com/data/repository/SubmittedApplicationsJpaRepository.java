package com.data.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.data.entities.College;
import com.data.entities.SubmittedApplications;
import com.data.entities.User;

@Repository("submittedApplicationsJpaRepository")
public interface SubmittedApplicationsJpaRepository extends JpaRepository<SubmittedApplications, Integer> {
	List<SubmittedApplications> findByUserAndCollegeProgramMapCollege(User user, College college);
}