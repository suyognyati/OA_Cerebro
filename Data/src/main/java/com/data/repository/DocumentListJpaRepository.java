package com.data.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.data.entities.DocumentList;

@Repository("documentListJpaRepository")
public interface DocumentListJpaRepository extends JpaRepository<DocumentList, Integer> {
	List<DocumentList> findByDocumentFor(Integer documentFor);
}
