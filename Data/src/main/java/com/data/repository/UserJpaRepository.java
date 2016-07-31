package com.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.data.entities.User;

@Repository("userJpaRepository")
public interface UserJpaRepository extends JpaRepository<User, Integer> {

}
