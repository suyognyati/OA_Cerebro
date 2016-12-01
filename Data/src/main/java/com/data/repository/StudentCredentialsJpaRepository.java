package com.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.data.entities.StudentCredentials;

@Repository("studentCredentialsJpaRepository")
public interface StudentCredentialsJpaRepository extends JpaRepository<StudentCredentials, String> {

}
