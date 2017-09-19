package com.data.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.data.entities.DocumentList;
import com.data.repository.DocumentListJpaRepository;
import com.data.services.DocumentListService;

@Service("documentListService")
public class DocumentListServiceImpl implements DocumentListService{
	
	@Autowired
	DocumentListJpaRepository documentListJPARepository;

	@Override
	public DocumentList getById(Integer documentId) {
		return documentListJPARepository.findOne(documentId);
	}

	@Override
	public List<DocumentList> getByDocumentFor(Integer documentFor) {
		return documentListJPARepository.findByDocumentFor(documentFor);
	}
	
	
}
