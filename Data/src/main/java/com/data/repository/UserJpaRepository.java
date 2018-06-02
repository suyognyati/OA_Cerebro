package com.data.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.data.entities.User;

@Repository("userJpaRepository")
public interface UserJpaRepository extends JpaRepository<User, Integer>{
	User findByUserId(Integer userId);
	User findByUserName(String userName);
	
	/**
	 * It will give user list of student 
	 * @param id
	 * @return
	 */
	List<User> findByStudentId(Integer id);
}
