package com.data.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.data.entities.UserDetail;
import com.data.entities.User;

@Repository("userDetailJpaRepository")
public interface UserDetailJpaRepository extends JpaRepository<UserDetail, Integer> {
	List<UserDetail> findByFirstName(String firstName);
}
