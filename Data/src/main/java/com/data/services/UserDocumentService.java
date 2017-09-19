package com.data.services;

import java.util.List;

import com.data.entities.DocumentList;
import com.data.entities.User;
import com.data.entities.UserDocument;

public interface UserDocumentService {
	UserDocument getById(Integer userDocumentId);
	List<UserDocument> getByUser(User user);
	List<UserDocument> getByDocumentFor(User user, Integer documentFor);
	List<UserDocument> getByDocuments(User user, List<DocumentList> documentList);
	Boolean addByDocumentFor(User user, Integer documentFor);
	Boolean deleteByDocumentFor(User user, Integer documentFor);
	Boolean deleteByUserDocument(List<UserDocument> userDocuments);
	Boolean deleteByUserDocument(UserDocument userDocument);
	Boolean saveDocument(UserDocument userDocument);
	Boolean saveDocument(List<UserDocument> userDocuments);
}
