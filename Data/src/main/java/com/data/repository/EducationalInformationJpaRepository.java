package com.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.data.entities.EducationalInformation;

@Repository("educationalInformationJpaRepository")
public interface EducationalInformationJpaRepository extends JpaRepository<EducationalInformation, Integer> {

}
