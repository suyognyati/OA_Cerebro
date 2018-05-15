package com.data.services;

import java.util.List;

import com.data.entities.DocumentList;
import com.data.entities.UserDetail;
import com.data.entities.UserDocument;

public interface UserDocumentService {
	UserDocument getById(Integer userDocumentId);
	List<UserDocument> getByUserDetail(UserDetail userDetail);
	List<UserDocument> getByDocumentFor(UserDetail userDetail, Integer documentFor);
	List<UserDocument> getByDocuments(UserDetail userDetail, List<DocumentList> documentList);
	Boolean addByDocumentFor(UserDetail userDetail, Integer documentFor);
	Boolean deleteByDocumentFor(UserDetail userDetail, Integer documentFor);
	Boolean deleteByUserDocument(List<UserDocument> userDocuments);
	Boolean deleteByUserDocument(UserDocument userDocument);
	Boolean saveDocument(UserDocument userDocument);
	Boolean saveDocument(List<UserDocument> userDocuments);
}
