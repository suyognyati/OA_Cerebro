package com.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.data.entities.BasicDetail;

@Repository("basicDetailJpaRepository")
public interface BasicDetailJpaRepository extends JpaRepository<BasicDetail, Integer> {

}
