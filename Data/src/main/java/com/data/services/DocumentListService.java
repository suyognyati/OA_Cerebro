package com.data.services;

import java.util.List;

import com.data.entities.DocumentList;

public interface DocumentListService {
	DocumentList getById(Integer documentId);
	List<DocumentList> getByDocumentFor(Integer documentFor);
}
