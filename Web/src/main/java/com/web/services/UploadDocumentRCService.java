package com.web.services;

import com.data.entities.User;
import com.web.model.UploadDocumentModel;

public interface UploadDocumentRCService {
	UploadDocumentModel getUserDocuments(User user);
	byte[] getDocument(User user, Integer userDocumentId);
}
