package com.data.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.data.entities.DocumentList;
import com.data.entities.User;
import com.data.entities.UserDocument;

@Repository("userDocumentJpaRepository")
public interface UserDocumentJpaRepository extends JpaRepository<UserDocument, Integer> {
	List<UserDocument> findByUserAndStateIn(User user, List<Integer> stateIn);
	List<UserDocument> findByUserAndStateNotIn(User user, List<Integer> stateNotIn);
	List<UserDocument> findByUserAndDocumentDocumentFor(User user, Integer documentFor);
	List<UserDocument> findByUserAndDocumentIn(User user, List<DocumentList> documentList);
	List<UserDocument> findByUserAndDocument(User user, DocumentList document);
}
