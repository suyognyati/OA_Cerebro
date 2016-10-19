package com.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.data.entities.UserRole;

@Repository("userRoleJpaRepository")
public interface UserRoleJpaRepository extends JpaRepository<UserRole, Integer>{

}
