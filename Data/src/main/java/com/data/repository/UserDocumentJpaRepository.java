package com.data.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.data.entities.DocumentList;
import com.data.entities.Student;
import com.data.entities.UserDocument;

@Repository("userDocumentJpaRepository")
public interface UserDocumentJpaRepository extends JpaRepository<UserDocument, Integer> {
	List<UserDocument> findByStudentAndStateIn(Student student, List<Integer> stateIn);
	List<UserDocument> findByStudentAndStateNotIn(Student student, List<Integer> stateNotIn);
	List<UserDocument> findByStudentAndDocumentDocumentFor(Student student, Integer documentFor);
	List<UserDocument> findByStudentAndDocumentIn(Student student, List<DocumentList> documentList);
	List<UserDocument> findByStudentAndDocument(Student student, DocumentList document);
}
