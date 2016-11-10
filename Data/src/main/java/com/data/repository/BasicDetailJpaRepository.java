package com.data.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.data.entities.BasicDetail;
import com.data.entities.User;

@Repository("basicDetailJpaRepository")
public interface BasicDetailJpaRepository extends JpaRepository<BasicDetail, Integer> {
	List<BasicDetail> findByFirstName(String firstName);
	BasicDetail findByUser(User user);
}
