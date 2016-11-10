package com.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.data.entities.PersonalDetail;
import com.data.entities.User;

@Repository("personalDetailJpaRepository")
public interface PersonalDetailJpaRepository extends JpaRepository<PersonalDetail, Integer> {
	PersonalDetail findByUser(User user);
}
