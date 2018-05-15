package com.data.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.data.entities.DocumentList;
import com.data.entities.UserDetail;
import com.data.entities.UserDocument;

@Repository("userDocumentJpaRepository")
public interface UserDocumentJpaRepository extends JpaRepository<UserDocument, Integer> {
	List<UserDocument> findByUserDetailAndStateIn(UserDetail userDetail, List<Integer> stateIn);
	List<UserDocument> findByUserDetailAndStateNotIn(UserDetail userDetail, List<Integer> stateNotIn);
	List<UserDocument> findByUserDetailAndDocumentDocumentFor(UserDetail userDetail, Integer documentFor);
	List<UserDocument> findByUserDetailAndDocumentIn(UserDetail userDetail, List<DocumentList> documentList);
	List<UserDocument> findByUserDetailAndDocument(UserDetail userDetail, DocumentList document);
}
