package com.data.services;

import java.util.List;

import com.data.entities.DocumentList;
import com.data.entities.Student;
import com.data.entities.UserDocument;

public interface UserDocumentService {
	UserDocument getById(Integer userDocumentId);
	List<UserDocument> getByStudent(Student student);
	List<UserDocument> getByDocumentFor(Student student, Integer documentFor);
	List<UserDocument> getByDocuments(Student student, List<DocumentList> documentList);
	Boolean addByDocumentFor(Student student, Integer documentFor);
	Boolean deleteByDocumentFor(Student student, Integer documentFor);
	Boolean deleteByUserDocument(List<UserDocument> userDocuments);
	Boolean deleteByUserDocument(UserDocument userDocument);
	Boolean saveDocument(UserDocument userDocument);
	Boolean saveDocument(List<UserDocument> userDocuments);
}
