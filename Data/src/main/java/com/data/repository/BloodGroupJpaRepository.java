package com.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.data.entities.BloodGroup;

@Repository("bloodGroupJpaRepository")
public interface BloodGroupJpaRepository extends JpaRepository<BloodGroup, Integer> {

}
