package com.web.model;

import java.util.List;

import com.data.entities.UserDocument;

public class UploadDocumentModel {
	private List<UserDocument> userDocuments;

		public List<UserDocument> getUserDocuments() {
			return userDocuments;
		}	
		public void setUserDocuments(List<UserDocument> userDocuments) {
			this.userDocuments = userDocuments;
		}
}
